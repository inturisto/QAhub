package core.one_a_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

public class NotepadAndAccPage {
    private final By MENU = xpath(".//a[@class='list-filterable__label']");
    private final By PAGE_VERIFICATIONN = xpath("//h1");
    private final String VERIFICATION_TEXTT = "Portatīvie datori un aksesuāri";
    private final String MENU_TEXT = "Portatīvie datori";

    private final Logger LOGGER = getLogger(this.getClass());

    private BaseFunc baseFunc;

    public NotepadAndAccPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
//        assertEquals(baseFunc.findElement(PAGE_VERIFICATIONN).getText(), VERIFICATION_TEXTT,
//                "Not on 'Portatīvie datori un aksesuāri' page!");

        LOGGER.info("We are on 'Portatīvie datori un aksesuāri' page!");

        IframeHelper iframeHelper = new IframeHelper(baseFunc);
        iframeHelper.closeIframes();

    }
    public NotepadPage getNotepadPage(){
        List<WebElement> elements = baseFunc.findElements(MENU);
        int i=0;
        while (i<elements.size()) {
            if (elements.get(i).getText().equals(MENU_TEXT)){
                baseFunc.clickOnWebElement(elements.get(i));
            }
            i++;
        }
        return new NotepadPage(baseFunc);
    }
}
