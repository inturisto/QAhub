package core.delfi_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.apache.logging.log4j.LogManager.*;
import static org.openqa.selenium.By.*;

public class CommentPage {
    private final By TITLE = xpath(".//h1[@class='article-title']");
    private final By COMMENTS = xpath(".//span[@class='type-cnt']");

    private final Logger LOGGER = getLogger(this.getClass());

    private BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        LOGGER.info("Getting article title text.");

        return baseFunc.getText(TITLE);
    }

    public int getCommentCount() {
        LOGGER.info("Getting comment count.");

        baseFunc.visibilityOfElement(COMMENTS);
        int commentCount = baseFunc.parseTextToNumber(baseFunc.findElements(COMMENTS).get(0).getText())
                + baseFunc.parseTextToNumber(baseFunc.findElements(COMMENTS).get(1).getText());
        return commentCount;
    }
}
