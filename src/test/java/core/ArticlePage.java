package core;

import org.openqa.selenium.By;

public class ArticlePage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By ARTICLE_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'d-print-none')]");
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.findElement(TITLE).getText().trim();
    }

    public void goToCommentPage(){
        baseFunc.click(baseFunc.findElement(ARTICLE_PAGE_COMMENT_COUNT));
    }
}
