package core.one_a_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.xpath;

public class SubMenuComputersPage {

    private final By LINK = xpath(".//a[text()='Portatīvie datori un aksesuāri']");
    private final By PAGE_VERIFICATION = xpath(".//h1");
    private final String VERIFICATION_TEXT = "Datortehnika, preces birojam";

    private final Logger LOGGER = getLogger(this.getClass());

    private BaseFunc baseFunc;


    public SubMenuComputersPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

//        assertEquals(baseFunc.findElement(PAGE_VERIFICATION).getText(),VERIFICATION_TEXT,
//                "Not on 'Datortehnika, preces birojam' page!");

        LOGGER.info("We are on 'Datortehnika, preces birojam' page!");


        IframeHelper iframeHelper = new IframeHelper(baseFunc);
        iframeHelper.closeCookies();
        iframeHelper.closeIframes();
//        baseFunc.navigateOnPreviousPage();
    }

    public NotepadAndAccPage getNotepadAndAccPage(){
       baseFunc.clickOnWebElement(baseFunc.findElement(LINK));
        return new NotepadAndAccPage(baseFunc);
    }
}
