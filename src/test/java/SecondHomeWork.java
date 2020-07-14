import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondHomeWork {
    @Test
    public void toCompareHeading() {
        String articleTitleToCheck = "Удар коронавируса: за первое полугодие VID собрал на 1,5% меньше налогов, чем " +
                "годом ранее ";
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");
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
        driver.get("http://rus.delfi.lv");
        String actualCommentCount = driver.findElement(By.xpath(".//a[@class='comment-count text-red-ribbon']"))
                .getText().replaceAll("\\p{P}", "");
        Assertions.assertEquals(setCommentCount, actualCommentCount, "Does not match!");
        driver.quit();
    }
}
//
//    @Test
//    public void delfiTest(){
//        System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
//        WebDriver driver =new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://rus.delfi.lv");
//        List<String> articles = new ArrayList<String>();
//        Integer text = driver.findElement(By.xpath(".//h1")).hashCode();
//        System.out.println(text);
//    }
//}
