import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiArticleTest {
    private static WebDriver driver;
    private final String WEB_PAGE = "https://www.delfi.lv/";
    private final By ARTICLE = By.tagName("article");
    private final By HOME_PAGE_ARTICLE_TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By HOME_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'comment-count')]");
    private final By ARTICLE_PAGE_ARTICLE_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'d-print-none')]");
    private final By COMMENT_PAGE_ARTICLE_TITLE = By.xpath(".//h1[@class='article-title']");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.xpath(".//span[@class='type-cnt']");

    @Test
    public void articleTitleAndCommentCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);
        WebDriverWait wait = new WebDriverWait(driver, 15);

        List<WebElement> articles = driver.findElements(ARTICLE);
        WebElement article = articles.get(1);
        String articleTitleHomePage = article.findElement(HOME_PAGE_ARTICLE_TITLE).getText().trim();
        int commentCount = 0;
        if (!articles.get(0).findElements(HOME_PAGE_COMMENT_COUNT).isEmpty()) {
            commentCount = parseCommentCount(article.findElement(HOME_PAGE_COMMENT_COUNT).getText());
        }
        System.out.println(articleTitleHomePage + " : " + commentCount + " " + "komentari");
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_ARTICLE_TITLE));
        article.findElement(HOME_PAGE_ARTICLE_TITLE).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_ARTICLE_TITLE));
        Assertions.assertEquals(articleTitleHomePage, driver.findElement(ARTICLE_PAGE_ARTICLE_TITLE).getText().
                trim(), "Article titles does not match with home page!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_COMMENT_COUNT));
        int commentCountArticlePage = parseCommentCount(driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).getText());
        Assertions.assertEquals(commentCount, commentCountArticlePage,
                "Comment count does not match with home page!");
        driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_PAGE_ARTICLE_TITLE));
        Assertions.assertEquals(articleTitleHomePage, driver.findElement(COMMENT_PAGE_ARTICLE_TITLE).getText().
                trim(), "Article title does not match with home page!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_PAGE_COMMENT_COUNT));
        int commentCountCommentPage = parseCommentCount(driver.findElements(COMMENT_PAGE_COMMENT_COUNT).get(0).getText())
                + parseCommentCount(driver.findElements(COMMENT_PAGE_COMMENT_COUNT).get(1).getText());
        Assertions.assertEquals(commentCount, commentCountCommentPage,
                "Comment count does not match with home page!");
    }

    private int parseCommentCount(String textToParse) {
        return Integer.parseInt(textToParse.substring(1, textToParse.length() - 1));

    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }
}
