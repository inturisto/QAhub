package core.pages;

import core.basefunc.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By ARTICLE = By.tagName("article");
    private final By HOME_PAGE_ARTICLE_TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By HOME_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'comment-count')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private String homePageName = "DELFI";
    private String homePageUrl = "delfi.lv";
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
        return baseFunc.findElements(HOME_PAGE_ARTICLE_TITLE).get(id - 1).getText().trim();

    }

    public ArticlePage goToTitleById(int id) {
        LOGGER.info("Finding title by ID");
        baseFunc.click(baseFunc.findElements(HOME_PAGE_ARTICLE_TITLE).get(id - 1));
        LOGGER.info("Proceeding to selected Article page through title");
        return new ArticlePage(baseFunc);
    }

    public ArticlePage goToArticlePageById(int id) {
        LOGGER.info("Finding list with all Articles");
        List<WebElement> elements = baseFunc.findElements(ARTICLE);
        LOGGER.info("Proceeding to selected Article page");
        baseFunc.click(elements.get(id - 1));
        return new ArticlePage(baseFunc);
    }

    public int getCommentCountById(int id) {
        int commentCount = 0;
        LOGGER.info("Checking for comment presence");
        if (!baseFunc.findElements(HOME_PAGE_COMMENT_COUNT).isEmpty()) {
            commentCount = baseFunc.parseCommentCount(baseFunc.findElements(HOME_PAGE_COMMENT_COUNT).get(id - 1).getText());
        }
        LOGGER.info("Returning verified comment count");
        return commentCount;
    }
}

