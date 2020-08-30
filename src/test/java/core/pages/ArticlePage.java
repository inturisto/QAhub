package core.pages;

import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ArticlePage {
    private final By ARTICLE_PAGE_ARTICLE_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'d-print-none')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Finding Article title");
        return baseFunc.findElement(ARTICLE_PAGE_ARTICLE_TITLE).getText().trim();
    }

    public int getCommentCount() {
        LOGGER.info("Finding comment count");
        return baseFunc.parseCommentCount(baseFunc.findElement(ARTICLE_PAGE_COMMENT_COUNT).getText());
    }

    public CommentPage goToCommentPage() {
        LOGGER.info("Finding comment page");
        baseFunc.click(baseFunc.findElement(ARTICLE_PAGE_COMMENT_COUNT));
        LOGGER.info("Proceeding to comment page");
        return new CommentPage(baseFunc);
    }
}
