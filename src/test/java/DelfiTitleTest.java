import core.CommentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.ArticlePage;
import core.BaseFunc;
import core.HomePage;

public class DelfiTitleTest {

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void titleTest() {
        baseFunc.openHomePage();

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(1);
        homePage.goToTitleById(1);

        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Does not match!");

        articlePage.goToCommentPage();

        CommentPage commentPage = new CommentPage(baseFunc);
        String commentPageTitle = commentPage.getTitle();

        Assertions.assertEquals(homePageTitle,commentPageTitle,"Does not match");
    }
}


