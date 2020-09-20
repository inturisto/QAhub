package core.one_a_pages;

import core.BaseFunc;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.apache.logging.log4j.LogManager.getLogger;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class IframeHelper {
    private final By IFRAME = xpath(".//iframe[contains(@src,'//cdn')]");
    private final By CLOSE = xpath(".//div[contains(@class,'close-button-slider')]");
    private final By COOKIES = id("cookiebanner");
    private  final By BUTTON = xpath(".//a[@class='c-button']");
    private  final Logger LOGGER = getLogger(this.getClass());
    private  BaseFunc baseFunc;

    public IframeHelper(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public  void closeIframes() {

        LOGGER.info("Checking for Iframe windows.");

        try {
            if (baseFunc.isElementPresent(IFRAME)) {
                baseFunc.switchToFrame(IFRAME);
                baseFunc.clickByLocator(CLOSE);
                baseFunc.switchToDefault();

                LOGGER.info("Iframe windows closed.");
            }
        } catch (Exception ignored) {
            LOGGER.info("No iframe windows found.");
        }
    }

    public  void closeCookies() {
        try {
            if (baseFunc.isElementPresent(COOKIES)) {
                baseFunc.clickByLocator(BUTTON);

                LOGGER.info("Cookies windows closed.");
            }
        } catch (Exception ignored) {
            LOGGER.info("No cookies windows found.");
        }
    }
}

