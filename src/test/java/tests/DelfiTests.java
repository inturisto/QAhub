package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DelfiTests {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private final String WEB_PAGE = "http://rus.delfi.lv";
    private WebDriver driver;

    @BeforeEach
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(WEB_PAGE);
    }

    @Test
    public void titleText() {
        List<WebElement> articles = driver.findElements(ARTICLE);
        final String TITLE_TO_FIND = "Северная Корея заявила о возможном первом случае случае заражения Covid-19  ";
        boolean isFound = false;
        for (WebElement article : articles) {
            if (article.findElement(TITLE).getText().equals(TITLE_TO_FIND)) {
                article.findElement(TITLE).click();
                isFound = true;
                break;
            }
        }
        Assertions.assertTrue(isFound, "Found");
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        Assertions.assertEquals(TITLE_TO_FIND, articlePageTitle, "Title does not match!");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
//
//    @Test
//    public void firstDelfiTest() {
//        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://rus.delfi.lv");
////        String text = driver.findElement(By.xpath(".//h1[contains(@class,'headline__title')]")).getText();
////        System.out.println(text);
//        List<WebElement> textes = driver.findElements(By.xpath(".//h1[contains(@class,'headline__title')]"));
//        for(int i = 0; i< textes.size(); i++){
//            System.out.println((i+1)+":"+textes.get(i).getText());
//        }
//    }
//
//    @Test
//    public void workingWithLists(){
//        List<String> studentNames = new ArrayList<String>();
//
//        System.out.println(studentNames.isEmpty());
//
//        studentNames.add("Zoja");
//        studentNames.add("Petja");
//        studentNames.add("Vova");
//
//        System.out.println(studentNames.isEmpty());
//        System.out.println(studentNames.size());
//        System.out.println(studentNames.get(1));
//    }
//

}

// Для 3ей статьи проверить заголовок и количество комментариев на главной странице
// ,на странице самой статьи и на странице комментрариев этой статьи.


//домашнее задание: дополнить делфи тест логами
//поиграться с дебугером