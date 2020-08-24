package tests;

import core.pages.CommentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.pages.ArticlePage;
import core.basefunc.BaseFunc;
import core.pages.HomePage;

public class DelfiTitleTest {

    private BaseFunc baseFunc = new BaseFunc();
    int id = 2;

    @Test
    public void titleTest() {
        baseFunc.openHomePage();

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(id);
        homePage.goToTitleById(id);

        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Does not match!");

        articlePage.goToCommentPage();

        CommentPage commentPage = new CommentPage(baseFunc);
        String commentPageTitle = commentPage.getTitle();

        Assertions.assertEquals(homePageTitle,commentPageTitle,"Does not match");

    }

    @Test
    public void commentCountTest(){
        baseFunc.openHomePage();

        HomePage homePage = new HomePage(baseFunc);
        homePage.getCommentCountById(id);
        homePage.goToTitleById(id);


    }
    @AfterEach
    public void closeBrowser(){
        baseFunc.closeBrowser();
    }
}


