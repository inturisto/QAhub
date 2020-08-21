import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TVnetTests {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop='headline name']");
    private final By COMMENT_COUNT = By.xpath(".//span[@itemprop='url']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop='headline name']");
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//span[contains(@class,'item--count')]");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.xpath(".//span[contains(@class,'article-comments')]");

    @Test
    public void articleTitleCommentsCheck() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tvnet.lv/");

        List<WebElement> articles = driver.findElements(ARTICLE);
        WebElement article = articles.get(2);
        String articleTitle = article.findElement(TITLE).getText();
        int commentCount = 0;
        if (!article.findElements(COMMENT_COUNT).isEmpty()) {
            commentCount = parseCommentCount(article.findElement(COMMENT_COUNT).getText());
        }
        System.out.println(articleTitle + " " + commentCount);
        article.findElement(TITLE).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        Assertions.assertTrue(articleTitle.startsWith(articlePageTitle), "Wrong title");

        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_COMMENT_COUNT));
        int articlePageCommentCount = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).getText());
        Assertions.assertEquals(articlePageCommentCount, commentCount, "Does not match!");
        driver.findElement(ARTICLE_PAGE_COMMENT_COUNT).click();

        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        int commentsCountsPageCommentsCount = Integer.valueOf(driver.findElement(COMMENT_PAGE_COMMENT_COUNT).getText());
        Assertions.assertTrue(articlePageTitle.startsWith(commentsPageTitle), "Wrong page title!");
        Assertions.assertEquals(commentsCountsPageCommentsCount, articlePageCommentCount, "FCKYOU!");
    }

    private int parseCommentCount(String textToParse) {
        return Integer.parseInt(textToParse.substring(1, textToParse.length() - 1));
    }
}
