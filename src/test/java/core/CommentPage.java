package core;

import org.openqa.selenium.By;

public class CommentPage {
    private BaseFunc baseFunc;
    private final By COMMENT_PAGE_ARTICLE_TITLE = By.xpath(".//h1[@class='article-title']");

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle(){
        return baseFunc.findElement(COMMENT_PAGE_ARTICLE_TITLE).getText().trim();
    }
}
