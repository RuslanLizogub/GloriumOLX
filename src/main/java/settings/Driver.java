package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ruslan on 17.01.2017.
 */
public class Driver {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static void set(WebDriver driverInput) {
        driver = driverInput;
    }

    public static WebDriver get() {return driver;}

    public static void init() {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    public static WebDriverWait getWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(Driver.get(), 15);
        }
        return webDriverWait;
    }

    public static void tearDown() {
        Driver.get().quit();
        driver.close();
    }

}
