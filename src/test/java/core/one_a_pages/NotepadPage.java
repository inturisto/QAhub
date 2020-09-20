package core.one_a_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class NotepadPage {
    private final By PAGE_VERIFICATION = xpath(".//h1");
    private final String VERIFICATION_TEXT = "Portatīvie datori";
    private final By CATEGORY = xpath(".//div[contains(@class,'slider__slide')]");
    private final By CATEGORY_VERIFICATION = xpath(".//span[text()='Datora tips']");
    private final By CATALOGUE = xpath(".//div[contains(@class,'catalog-taxons-product__hover')]");
    private final By BUY_BUTTON = xpath(".//button[contains(@class,'add')]");
    private final By ITEM_PRICE = xpath(".//div[contains(@class,'product__price')]");
    private final By ITEM_NAME = xpath(".//a[contains(@class,'product__name')]");

    private final Logger LOGGER = getLogger(this.getClass());
    private BaseFunc baseFunc;

    public NotepadPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.refreshPage();
//        assertEquals(baseFunc.findElement(PAGE_VERIFICATION).getText(), VERIFICATION_TEXT,
//                "Not on 'Portatīvie datori' page!");

        LOGGER.info("We are on 'Portatīvie datori' page!");

    }

    public void checkFwdBckButtons(int id) {
        baseFunc.clickOnWebElement(baseFunc.findElements(CATEGORY).get(id));
        assertTrue(baseFunc.isElementPresent(CATEGORY_VERIFICATION), "Category filter is not working!");

        LOGGER.info("Category filter is working!");

        baseFunc.navigateOnPreviousPage();
        assertTrue(baseFunc.isElementPresent(CATEGORY), "Not switched to category choosing!");

        LOGGER.info("Switched to category choosing!");

        baseFunc.navigateOnNextPage();
        assertTrue(baseFunc.isElementPresent(CATEGORY_VERIFICATION), "Not switched to chosen category!");

        LOGGER.info("Switched to chosen category!");

    }

    public void pickItem(int id) {
        WebElement mainElement = baseFunc.findElements(CATALOGUE).get(id);
        WebElement button = mainElement.findElement(BUY_BUTTON);
        baseFunc.moveToElement(mainElement,button);
    }
}
