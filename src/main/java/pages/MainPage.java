package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import settings.Driver;

import static settings.Utils.getCurrentURL;

/**
 * Created by Ruslan on 17.01.2017.
 */
public class MainPage extends PageFactorySettings {
    public WebDriverWait wait = new WebDriverWait(Driver.get(), 35);
    private String url = "https://www.olx.ua/";

    @FindBy (id = "postNewAdLink")
    private WebElement newAdvertButton;


    @Step("Open Home page")
    public void openPage(){
        Driver.get().get(url);
        Driver.get().manage().window().maximize();
        Assert.assertEquals(getCurrentURL(), url, "Current URL was not as expected");
        System.out.println("Open main page successful!");
    }

    @Step("Click to new advert link")
    public void clickToNewAdvertLink(){
        wait.until(ExpectedConditions.visibilityOf(newAdvertButton));
        newAdvertButton.click();
    }
}
