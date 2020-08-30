package core.pages;

import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final By ARTICLE = By.tagName("article");
    private final By HOME_PAGE_ARTICLE_TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By HOME_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'comment-count')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private String homePageName = "DELFI";
    private String homePageUrl = "delfi.lv";
    private WebDriverWait wait;

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        openHomePage();
    }

    public void openHomePage() {
        baseFunc.openPage(homePageUrl);
        LOGGER.info("Opening home page: " + homePageName);
    }

    public String getTitleById(int id) {
        LOGGER.info("Finding article title");
        return findArticleById(id).findElement(HOME_PAGE_ARTICLE_TITLE).getText().trim();
    }

    public ArticlePage goToTitleById(int id) {
        LOGGER.info("Finding title by ID");
        baseFunc.click(findArticleById(id).findElement(HOME_PAGE_ARTICLE_TITLE));
        LOGGER.info("Proceeding to selected Article page through title");
        return new ArticlePage(baseFunc);
    }

    public ArticlePage goToArticlePageById(int id) {
        LOGGER.info("Finding list with all Articles");
        baseFunc.click(findArticleById(id));
        LOGGER.info("Proceeding to selected Article page");
        return new ArticlePage(baseFunc);
    }

    public int getCommentCountById(int id) {
        int commentCount = 0;
        LOGGER.info("Checking for comment presence");
        if (findArticleById(id).findElement(HOME_PAGE_COMMENT_COUNT).isDisplayed()) {
            commentCount = baseFunc.parseCommentCount(findArticleById(id).findElement(HOME_PAGE_COMMENT_COUNT).getText());
        }
        LOGGER.info("Returning verified comment count");
        return commentCount;
    }

    public WebElement findArticleById(int id) {
        List<WebElement> elements = baseFunc.findElements(ARTICLE);
        Assertions.assertFalse(elements.isEmpty(), "No articles found");
        return elements.get(id - 1);
    }
}

