import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondHomeWork {
    @Test
    public void compareDelfiData() {
        String articleTitleToCheck = "Удар коронавируса: за первое полугодие VID собрал на 1,5% меньше налогов, чем годом ранее ";
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");
        String element = driver.findElement(By.xpath(".//h1[contains(@class,'headline__title')]")).getText();
        Assertions.assertEquals(articleTitleToCheck, element, "Does not match!");
    }
}
