package core.basefunc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        LOGGER.info("Setting up driver's path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        LOGGER.info("Opening new browser");
        driver = new ChromeDriver();
        LOGGER.info("Maximizing window");
        driver.manage().window().maximize();
        LOGGER.info("Setting up wait conditions");
        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String url) {
        LOGGER.info("Checking url before proceeding to web-page");
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        LOGGER.info("Proceeding to web-page");
        driver.get(url);
    }

    public List<WebElement> findElements(By locator) {
        LOGGER.info("Finding all web-element by locator");
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        LOGGER.info("Finding exact element by locator");
        return driver.findElement(locator);
    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        LOGGER.info("Clicking on web-element");
    }

    public int parseCommentCount(String textToParse) {
        LOGGER.info("Parsing to integer");
        return Integer.parseInt(textToParse.substring(1, textToParse.length() - 1));
    }

    public void closeBrowser() {
        LOGGER.info("Closing browser");
        driver.quit();
    }

    public void visibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

