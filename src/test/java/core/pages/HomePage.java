package core.pages;

import core.basefunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By HOME_PAGE_COMMENT_COUNT = By.xpath(".//a[contains(@class,'comment-count')]");
    private final By ARTICLE = By.tagName("article");
    private BaseFunc baseFunc;


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleById(int id) {
        return baseFunc.findElements(TITLE).get(id - 1).getText().trim();
    }

    public void goToTitleById(int id) {
        baseFunc.click(baseFunc.findElements(TITLE).get(id - 1));
    }

    public void  goToArticlePageById(int id){
        List<WebElement> elements = baseFunc.findElements(ARTICLE);
        baseFunc.click(elements.get(id-1));

    }

    public int getCommentCountById(int id) {
        int commentCount = 0;
        if (!baseFunc.findElements(HOME_PAGE_COMMENT_COUNT).isEmpty()) {
            commentCount = baseFunc.parseCommentCount(baseFunc.findElements(HOME_PAGE_COMMENT_COUNT).get(id - 1).getText());
        }
        return commentCount;
    }
}

