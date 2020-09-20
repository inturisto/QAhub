package core.one_a_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static core.one_a_pages.IframeHelper.*;
import static org.apache.logging.log4j.LogManager.*;
import static org.openqa.selenium.By.*;

public class HomePage {
    private final By SUB_MENU_COMPUTERS = xpath(".//a[@class='submenu-lvl1__link']");
    private final String SUB_MENU_TEXT = "Datortehnika, preces birojam";
    private final By SUB = xpath(".//a[@class='grid-item border-br']");

    private final Logger LOGGER = getLogger(this.getClass());
    private String homePageName = "1A";
    private String homePageUrl = "1a.lv";

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        openHomePage();
    }

    public void openHomePage() {
        baseFunc.openPage(homePageUrl);

        IframeHelper iframeHelper = new IframeHelper(baseFunc);

        LOGGER.info("Opening home page: " + homePageName);

        LOGGER.info("Checking for cookies settings.");

       iframeHelper.closeCookies();

        LOGGER.info("Checking for Iframe windows.");

        baseFunc.refreshPage();

        iframeHelper.closeIframes();
    }

    public SubMenuComputersPage getSubMenuAllComputers() {
        for (int i = 0; i < baseFunc.findElements(SUB_MENU_COMPUTERS).size(); i++)
            if (baseFunc.findElements(SUB_MENU_COMPUTERS).get(i).getText().equals(SUB_MENU_TEXT)) {
                baseFunc.findElements(SUB_MENU_COMPUTERS).get(i).click();
            }
        return new SubMenuComputersPage(baseFunc);
    }
}
//1a.lv написать тест переходит в раздел ноутбуки,кладёт в корзину,переход в корзину,проверка информации на верность.