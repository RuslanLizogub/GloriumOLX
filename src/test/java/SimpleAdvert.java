
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.OrderPage;
import settings.BaseTestSettings;

/**
 * Created by Ruslan on 17.01.2017.
 */
public class SimpleAdvert extends BaseTestSettings{
    MainPage mainPage;
    LoginPage loginPage;
    OrderPage orderPage;

    @Test
    public void simpleAdvertTest() throws InterruptedException {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        orderPage = new OrderPage();

        mainPage.openPage();
        mainPage.clickToNewAdvertLink();
        loginPage.loginToAccount();
        loginPage.checkLoginToAccount();
        orderPage.newOrder();
        orderPage.checkNewOrder();
    }
}
