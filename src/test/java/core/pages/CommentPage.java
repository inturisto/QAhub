package core.pages;

import core.basefunc.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentPage {
    private final By COMMENT_PAGE_ARTICLE_TITLE = By.xpath(".//h1[@class='article-title']");
    private final By COMMENT_PAGE_COMMENT_COUNT = By.xpath(".//span[@class='type-cnt']");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Finding article title");
        return baseFunc.findElement(COMMENT_PAGE_ARTICLE_TITLE).getText().trim();
    }

    public int getCommentCount() {
        LOGGER.info("Finding comment count");
        baseFunc.visibilityOfElement(COMMENT_PAGE_COMMENT_COUNT);
        int commentCount = baseFunc.parseCommentCount(baseFunc.findElements(COMMENT_PAGE_COMMENT_COUNT).get(0).getText())
                + baseFunc.parseCommentCount(baseFunc.findElements(COMMENT_PAGE_COMMENT_COUNT).get(1).getText());
        return commentCount;
    }
}
