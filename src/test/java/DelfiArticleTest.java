import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void articleTitleAndCommentCheck() {
        LOGGER.info("This test is checking title and comment count");

        LOGGER.info("Setting up driver's path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Opening new browser");
        driver = new ChromeDriver();

        LOGGER.info("Maximizing window");
        driver.manage().window().maximize();

        LOGGER.info("Opening new web-page");
        driver.get(WEB_PAGE);

        LOGGER.info("Setting wait conditions");
        WebDriverWait wait = new WebDriverWait(driver, 15);

        LOGGER.info("Getting all articles on webpage");
        List<WebElement> articles = driver.findElements(ARTICLE);

        LOGGER.info("Getting article");
        WebElement article = articles.get(0);

        LOGGER.info("Getting article title");
        String articleTitleHomePage = article.findElement(HOME_PAGE_ARTICLE_TITLE).getText().trim();

        LOGGER.info("Getting comment count for article on home page");
        int commentCount = 0;
        if (!articles.get(0).findElements(HOME_PAGE_COMMENT_COUNT).isEmpty()) {
            commentCount = parseCommentCount(article.findElement(HOME_PAGE_COMMENT_COUNT).getText());
        }
        System.out.println(articleTitleHomePage + " : " + commentCount + " " + "komentari");

        LOGGER.info("Clicking on article link");
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_ARTICLE_TITLE));
        article.findElement(HOME_PAGE_ARTICLE_TITLE).click();

        LOGGER.info("Comparing article page title with home page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_ARTICLE_TITLE));
        Assertions.assertEquals(articleTitleHomePage, driver.findElement(ARTICLE_PAGE_ARTICLE_TITLE).getText().
                trim(), "Article titles does not match with home page!");

        LOGGER.info("Comparing article page comment count with home page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_COMMENT_COUNT));
        Assertions.assertEquals(commentCount, parseCommentCount(driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).getText()),
                "Comment count does not match with home page!");

        LOGGER.info("Clicking on comment page link");
        driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).click();

        LOGGER.info("Comparing comment page title with home page");
        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_PAGE_ARTICLE_TITLE));
        Assertions.assertEquals(articleTitleHomePage, driver.findElement(COMMENT_PAGE_ARTICLE_TITLE).getText().
                trim(), "Article title does not match with home page!");

        LOGGER.info("Comparing comment page comment count with home page");
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
