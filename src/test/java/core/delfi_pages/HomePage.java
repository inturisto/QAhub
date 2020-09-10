package core.delfi_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.apache.logging.log4j.LogManager.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class HomePage {
    private final By ARTICLE = tagName("article");
    private final By TITLE = xpath(".//h1[contains(@class,'headline__title')]");
    private final By COMMENTS = xpath(".//a[contains(@class,'comment-count')]");
    private final By IFRAME = xpath("//iframe[contains(@src,'javascript:')]");
    private final By CLOSE = id("Close");

    private final Logger LOGGER = getLogger(this.getClass());

    private String homePageName = "DELFI";
    private String homePageUrl = "delfi.lv";

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        openHomePage();
    }

    public void openHomePage() {
        LOGGER.info("Opening home page: " + homePageName);

        baseFunc.openPage(homePageUrl);

        LOGGER.info("Home page opened successfully!");

        LOGGER.info("Searching for pop-up windows.");

        try {
            if (baseFunc.isElementPresent(IFRAME)) {
                baseFunc.switchToFrame(IFRAME);
                baseFunc.clickByLocator(CLOSE);
                baseFunc.switchToDefault();

                LOGGER.info("Pop-up windows closed.");
            }
        } catch (Exception ignored) {
            LOGGER.info("No pop-up windows found.");
        }
    }

    public String getTitleById(int id) {
        LOGGER.info("Getting article title text by chosen article number.");

        return findArticleById(id).findElement(TITLE).getText().trim();
    }

    public ArticlePage goToTitleById(int id) {
        LOGGER.info("Executing switching to Article page through title WebElement.");

        baseFunc.clickOnWebElement(findArticleById(id).findElement(TITLE));

        LOGGER.info("Proceeding to selected Article page through title");

        return new ArticlePage(baseFunc);
    }

    public ArticlePage goToArticlePageById(int id) {
        LOGGER.info("Executing switching to Article page through article WebElement.");

        baseFunc.clickOnWebElement(findArticleById(id));

        LOGGER.info("Proceeding to selected Article page.");

        return new ArticlePage(baseFunc);
    }

    public int getCommentCountById(int id) {
        int commentCount = 0;

        LOGGER.info("Checking for comment presence on page.");

        if (getCommentsById(id).isDisplayed()) {
            commentCount = baseFunc.parseTextToNumber(getCommentsById(id).getText());

            LOGGER.info("Text parsed successfully!");
        }

        LOGGER.info("Returning verified comment count.");

        return commentCount;
    }

    public WebElement findArticleById(int id) {
        LOGGER.info("Finding all available articles.");

        List<WebElement> elements = baseFunc.findElements(ARTICLE);

        LOGGER.info("Checking for article presence on web-page.");

        assertFalse(elements.isEmpty(), "No articles found");

        LOGGER.info("Returning article by chosen number.");

        return elements.get(id - 1);
    }

    public WebElement getCommentsById(int id) {
        LOGGER.info("Getting comment count in article on Home page.");

        return findArticleById(id).findElement(COMMENTS);
    }
}

