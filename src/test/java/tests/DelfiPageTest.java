package tests;

import core.delfi_pages.CommentPage;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import core.delfi_pages.ArticlePage;
import core.BaseFunc;
import core.delfi_pages.HomePage;

import static org.apache.logging.log4j.LogManager.*;
import static org.junit.jupiter.api.Assertions.*;

public class DelfiPageTest {
    private final int ARTICLE_NUMBER = 1;
    private final Logger LOGGER = getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titleTest() {
        LOGGER.info("Starting title test.");

        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("New Home page started.");

        String homePageTitle = homePage.getTitleById(ARTICLE_NUMBER);

        LOGGER.info("Got article title according chosen number on Home page.");

        ArticlePage articlePage = homePage.goToArticlePageById(ARTICLE_NUMBER);

        LOGGER.info("New Article page started.");

        String articlePageTitle = articlePage.getTitle();

        LOGGER.info("Got article title text on Article page.");

        LOGGER.info("Comparing titles.");

        assertEquals(homePageTitle, articlePageTitle, "Tiles does not match!");

        LOGGER.info("Titles matches!");

        CommentPage commentPage = articlePage.goToCommentPage();

        LOGGER.info("New Comment page started.");

        String commentPageTitle = commentPage.getTitle();

        LOGGER.info("Got article title text.");

        LOGGER.info("Comparing titles.");

        assertEquals(homePageTitle, commentPageTitle, "Titles does not match!");

        LOGGER.info("Titles matches!");
    }

    @Test
    public void commentCountTest() {
        LOGGER.info("Starting comment count test.");

        HomePage homePage = new HomePage(baseFunc);

        LOGGER.info("New Home page started.");

        int homePageCommentCount = homePage.getCommentCountById(ARTICLE_NUMBER);

        LOGGER.info("Got comment count according chosen number on Home page.");

        ArticlePage articlePage = homePage.goToTitleById(ARTICLE_NUMBER);

        LOGGER.info("New Article page started.");

        int articlePageCommentCount = articlePage.getCommentCount();

        LOGGER.info("Got comment count  on Article page.");

        LOGGER.info("Comparing comment count.");

        assertEquals(homePageCommentCount, articlePageCommentCount, "Comment count does not match!");

        LOGGER.info("Comment counts matches!");

        CommentPage commentPage = articlePage.goToCommentPage();

        LOGGER.info("New Comment page started.");

        int commentPageCommentCount = commentPage.getCommentCount();

        LOGGER.info("Got comment count  on Comment page.");

        LOGGER.info("Comparing comment count");

        assertEquals(articlePageCommentCount, commentPageCommentCount, "Comment count does not match!");

        LOGGER.info("Comment counts matches!");
    }

    @AfterEach
    public void closeBrowser() {
        LOGGER.info("Finishing test.");

        baseFunc.closeBrowser();
    }
}




