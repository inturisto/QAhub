import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SecondHomeWork {
    private final String WEB_PAGE = "http://rus.delfi.lv";
    private final String TEXT_TO_COMPARE = "Не обязан отвечать клеветникам: президент Латвии рассказал о " +
            "своем гражданстве, образовании и родителях  ";

    @Test
    public void toCompareHeading() {
        String articleTitleToCheck = "Удар коронавируса: за первое полугодие VID собрал на 1,5% меньше налогов, чем " +
                "годом ранее ";
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);
        String element = driver.findElement(By.xpath(".//h1[contains(@class,'headline__title')]")).getText();
        Assertions.assertEquals(articleTitleToCheck, element, "Does not match!");
        driver.quit();
    }

    @Test
    public void toCheckCommentCount() {
        String setCommentCount = "27";
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);
        String actualCommentCount = driver.findElement(By.xpath(".//a[@class='comment-count text-red-ribbon']"))
                .getText().replaceAll("\\p{P}", "");
        Assertions.assertEquals(setCommentCount, actualCommentCount, "Does not match!");
        driver.quit();
    }

    @Test
    public void toGetArticleNumber() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);
        List<WebElement> elements = driver.findElements(By.xpath(".//h1[contains(@class,'headline__title')]"));
        System.out.println("Size =" + elements.size());
        List<String> elementText = new ArrayList<String>();
        for (WebElement text : elements) {
            elementText.add(text.getText());

        }
        for (String outputText : elementText) {
            System.out.println(outputText);

        }

//        for (int i = 0; i < elementText.size(); i++) {
//            if (!elementText.get(i+1).equals(TEXT_TO_COMPARE)) {
//                i++;
//            } else {
//                System.out.println(elementText.get(i));
//                break;
//            }
//
//        }
        driver.quit();
    }
}