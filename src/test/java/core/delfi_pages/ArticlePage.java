package core.delfi_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.apache.logging.log4j.LogManager.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

public class ArticlePage {
    private final By TITLE = xpath(".//h1[contains(@class,'d-inline')]");
    private final By COMMENTS = xpath(".//a[contains(@class,'d-print-none')]");
    private final By TIME = xpath(".//time[contains(@class, 'd-block')]");
    private final By PAYMENT = xpath(".//div[@class='delfi-plus-payment-block']");

    private final Logger LOGGER = getLogger(this.getClass());

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        LOGGER.info("Verifying being on Article page.");

        assertTrue(baseFunc.isElementPresent(TIME), "Not on article page!");

        LOGGER.info("We are on Article page!");

        LOGGER.info("Checking whether article has paid content.");

        try {
            if (baseFunc.isElementPresent(PAYMENT)) {
                LOGGER.info("NOT POSSIBLE TO TEST PAID CONTENT!");

                baseFunc.closeBrowser();
            }
        } catch (Exception ignored) {
            LOGGER.info("Article has free access.");
        }
    }

    public String getTitle() {
        LOGGER.info("Getting article title text.");

        return baseFunc.getText(TITLE).trim();
    }

    public int getCommentCount() {

        LOGGER.info("Getting comment count.");

        return baseFunc.parseTextToNumber(baseFunc.getText(COMMENTS));
    }

    public CommentPage goToCommentPage() {


        LOGGER.info("Finding comment page.");

        baseFunc.clickByLocator(COMMENTS);

        LOGGER.info("Proceeding to comment page.");

        return new CommentPage(baseFunc);
    }
}
