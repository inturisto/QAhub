package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    public BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitleById(int id) {
        List<WebElement> titles = baseFunc.findElements(TITLE);
        return titles.get(id-1).getText();
    }

    public void goToTitleById(int id){
        List<WebElement> titles = baseFunc.findElements(TITLE);
        baseFunc.click(titles.get(id-1));
    }
}
