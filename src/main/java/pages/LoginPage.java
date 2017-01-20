package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import settings.Driver;

/**
 * Created by Ruslan on 18.01.2017.
 */
public class LoginPage extends PageFactorySettings {
    public WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    @FindBy(id = "userEmail")
    private WebElement emailForm;

    @FindBy(id = "userPass")
    private WebElement passForm;

    @FindBy(id = "se_userLogin")
    private WebElement inputButton;

    @FindBy(id = "headerLogo")
    private WebElement headerLogo;

    @Step("Login to account")
    public void loginToAccount(){
        wait.until(ExpectedConditions.visibilityOf(emailForm)).sendKeys("gloriumtechnologies@mail.ru");
        wait.until(ExpectedConditions.visibilityOf(passForm)).sendKeys("Qwerty123");
        wait.until(ExpectedConditions.visibilityOf(inputButton)).click();
    }

    @Step("Check login to account")
    public void checkLoginToAccount(){
        Assert.assertTrue(headerLogo.isDisplayed());
        System.out.println("Login to account successful!");
    }
}
