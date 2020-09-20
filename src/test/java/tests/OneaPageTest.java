package tests;

import core.BaseFunc;
import core.one_a_pages.HomePage;
import core.one_a_pages.NotepadAndAccPage;
import core.one_a_pages.NotepadPage;
import core.one_a_pages.SubMenuComputersPage;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.apache.logging.log4j.LogManager.*;

public class OneaPageTest {
    private final Logger LOGGER = getLogger(this.getClass());

    BaseFunc baseFunc = new BaseFunc();

    @Test
    public void stepByStepTest() {
        HomePage homePage = new HomePage(baseFunc);
        SubMenuComputersPage subMenuComputersPage = homePage.getSubMenuAllComputers();
        NotepadAndAccPage notepadAndAccPage = subMenuComputersPage.getNotepadAndAccPage();
        NotepadPage notepadPage = notepadAndAccPage.getNotepadPage();
        notepadPage.checkFwdBckButtons(2);
        notepadPage.pickItem(1);
    }

//    @AfterEach
//    public void closeBrowser(){
//        baseFunc.closeBrowser();
//    }
}
