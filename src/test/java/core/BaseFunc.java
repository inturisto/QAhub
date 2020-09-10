package core;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Integer.*;
import static java.lang.System.*;
import static org.apache.logging.log4j.LogManager.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = getLogger(this.getClass());

    public BaseFunc() {

        LOGGER.info("Setting up driver's path.");

        setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Opening new browser.");

        driver = new ChromeDriver();

        LOGGER.info("Maximizing window.");

        driver.manage().window().maximize();

        LOGGER.info("Setting up wait conditions.");

        wait = new WebDriverWait(driver, 10);

        LOGGER.info("WebDriver successfully set up for further work.");
    }

    public void openPage(String url) {
        LOGGER.info("Checking url before proceeding to web-page.");

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }

        LOGGER.info("Proceeding to web-page.");

        driver.get(url);
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Finding all WebElements by locator.");

        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        LOGGER.info("Waiting for an element to appear.");

        wait.until(visibilityOfElementLocated(locator));

        LOGGER.info("Finding exact element by locator.");

        return driver.findElement(locator);
    }

    public String getText(By locator) {
        LOGGER.info("Getting text of element.");

        return findElement(locator).getText();
    }

    public void clickOnWebElement(WebElement webElement) {
        LOGGER.info("Waiting for WebElement clickable.");

        wait.until(elementToBeClickable(webElement));

        LOGGER.info("Clicking on WebElement.");

        webElement.click();

        LOGGER.info("Clicked on WebElement.");
    }

    public void clickByLocator(By locator) {
        LOGGER.info("Waiting for WebElement clickable.");

        wait.until(elementToBeClickable(locator));

        LOGGER.info("Clicking on WebElement.");

        findElement(locator).click();

        LOGGER.info("Clicked on WebElement.");
    }

    public int parseTextToNumber(String textToParse) {
        LOGGER.info("Parsing text to integer.");

        return parseInt(textToParse.substring(1, textToParse.length() - 1));
    }

    public void closeBrowser() {
        LOGGER.info("Executing closing browser.");

        driver.quit();

        LOGGER.info("Browser is closed successfully!");
    }

    public void visibilityOfElement(By locator) {
        LOGGER.info("Waiting for an element to appear.");

        wait.until(visibilityOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        LOGGER.info("Checking for element presence.");

        try {
            wait.until(presenceOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void switchToFrame(By locator) {
        LOGGER.info("Switching to iframe.");

        driver.switchTo().frame(findElement(locator));

        LOGGER.info("Switched to iframe successfully.");
    }

    public void switchToDefault() {
        LOGGER.info("Switching to default page.");

        driver.switchTo().defaultContent();

        LOGGER.info("Switched successfully to default page.");
    }
}

