package tests;

import core.pages.CommentPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.pages.ArticlePage;
import core.basefunc.BaseFunc;
import core.pages.HomePage;

public class DelfiPageTest {
    private final int ARTICLE_NUMBER = 6;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titleTest() {
        LOGGER.info("Starting Title test");
        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(ARTICLE_NUMBER);

        ArticlePage articlePage = homePage.goToArticlePageById(ARTICLE_NUMBER);
        String articlePageTitle = articlePage.getTitle();

        LOGGER.info("Comparing titles");
        Assertions.assertEquals(homePageTitle, articlePageTitle, "Does not match!");

        CommentPage commentPage = articlePage.goToCommentPage();
        String commentPageTitle = commentPage.getTitle();

        LOGGER.info("Comparing titles");
        Assertions.assertEquals(homePageTitle, commentPageTitle, "Does not match");
    }

    @Test
    public void commentCountTest() {
        LOGGER.info("Starting Comment Count test");
        HomePage homePage = new HomePage(baseFunc);
        int homePageCommentCount = homePage.getCommentCountById(ARTICLE_NUMBER);

        ArticlePage articlePage = homePage.goToTitleById(ARTICLE_NUMBER);
        int articlePageCommentCount = articlePage.getCommentCount();

        LOGGER.info("Comparing comment count");
        Assertions.assertEquals(homePageCommentCount, articlePageCommentCount, "Does not match!");

        CommentPage commentPage = articlePage.goToCommentPage();
        int commentPageCommentCount = commentPage.getCommentCount();

        LOGGER.info("Comparing comment count");
        Assertions.assertEquals(articlePageCommentCount, commentPageCommentCount, "Does not match!");

    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}


