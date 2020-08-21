import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SecondHomeWork {
    private final String WEB_PAGE = "http://rus.delfi.lv";
    private final int SET_COMMENT_COUNT = 27;
    private final String TEXT_TO_COMPARE = "Воскресенье будет жарким, но местами дождливым  ";
    private WebDriver driver;

    @BeforeEach
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void toCompareHeading() {
        String articleTitleToCheck = "Удар коронавируса: за первое полугодие VID собрал на 1,5% меньше налогов, чем " +
                "годом ранее ";
        String element = driver.findElement(By.xpath(".//h1[contains(@class,'headline__title')]")).getText();
        Assertions.assertEquals(articleTitleToCheck, element, "Does not match!");
    }

    @Test
    public void toCheckCommentCount() {
        String actualCommentCount = String.valueOf(driver.findElement(By.xpath(".//a[@class='comment-count text-red-ribbon']"))
                .getText().replaceAll("\\p{P}", ""));
//        Assertions.assertEquals(SET_COMMENT_COUNT, actualCommentCount, "Does not match!");
    }

    @Test
    public void toGetArticleNumber() {
        List<WebElement> elements = driver.findElements(By.xpath(".//h1[contains(@class,'headline__title')]"));
        System.out.println("Size =" + elements.size());
//        List<String> elementText = new ArrayList<String>();
//        for (WebElement text : elements) {
//            elementText.add(text.getText());
//
//        }
//        for (String outputText : elementText) {
//            System.out.println(outputText);
//
//        }

        for (int i = 0; i < elements.size(); i++) {
            if (!elements.get(i).getText().equals(TEXT_TO_COMPARE)) {
                i++;
            } else {
                System.out.println((i + 1));
                break;
            }

        }
    }
}