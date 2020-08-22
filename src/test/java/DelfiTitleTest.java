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
        String homePageTitle = homePage.getTitleById(2);
        homePage.goToTitleById(2);

        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Does not match!");
    }
}


