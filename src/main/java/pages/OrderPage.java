package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.Driver;

import java.util.List;

/**
 * Created by Ruslan on 18.01.2017.
 */
public class OrderPage extends PageFactorySettings{
    public WebDriverWait wait = new WebDriverWait(Driver.get(), 35);

    @FindBy(id = "fancybox-close")
    private WebElement closeButtonForConfirmPhone;

    @FindBy(xpath = "//input[@name='data[title]']")
    private WebElement titleForOrder;

    @FindBy(id = "choose-category-ilu")
    private WebElement categoryChoise;

    @FindBy(id = "cat-37")
    private WebElement catgoryTypeLvl1;

    @FindBy(xpath = "//span[text()='Телефоны и аксессуары']")
    private WebElement categoryTypeLvl2;

    @FindBy(xpath = "//span[text()='Запчасти для телефонов']")
    private WebElement categoryTypeLvl3;

    @FindBy(xpath = "//input[@class=\"text x-normal br3 light min price paramPriceInput fleft marginleft10\"]")
    private WebElement inputPrice;

    @FindBy(xpath = "//dl[@id='targetparam430']")
    private WebElement ddlSparePart;

    @FindBy(xpath = ".//*[@id='targetparam430']//li")
    private List<WebElement> sparePartList;

    @FindBy(xpath = "//dl[@id='targetid_private_business']")
    private WebElement dlUserType;

    @FindBy(xpath = "//li//a[text()='Частное лицо']")
    private List<WebElement> objUserType;

    @FindBy(id = "add-description")
    private WebElement addDescription;

    @FindBy(id = "mapAddress")
    private WebElement mapAddress;

    @FindBy(xpath = "//span[text()='ская область']")
    private WebElement mapAddressChoise;

    @FindBy(id = "add-person")
    private WebElement addPersonName;

    @FindBy(id = "save")
    private WebElement saveOrderButton;

    @FindBy(xpath = "//p[text()='Ваше объявление принято!']")
    private WebElement actualCheckOrderMessage;

    public void newOrder() throws InterruptedException {
        Assert.assertTrue(titleForOrder.isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(titleForOrder)).sendKeys("TestTitle");
        wait.until(ExpectedConditions.visibilityOf(categoryChoise)).click();
        wait.until(ExpectedConditions.visibilityOf(catgoryTypeLvl1)).click();
        wait.until(ExpectedConditions.visibilityOf(categoryTypeLvl2)).click();
        wait.until(ExpectedConditions.visibilityOf(categoryTypeLvl3)).click();
        wait.until(ExpectedConditions.visibilityOf(inputPrice)).sendKeys("200");

        ddlSparePart.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(sparePartList));
        Driver.get().findElement(By.xpath(".//*[@id='targetparam430']//li/a[text()='Антенны']")).click();

        dlUserType.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(objUserType));
        Driver.get().findElement(By.xpath("//li//a[text()='Частное лицо']")).click();

        wait.until(ExpectedConditions.visibilityOf(addDescription)).sendKeys("Test description. Bla bla bla bla .... bla.");

        wait.until(ExpectedConditions.visibilityOf(mapAddress)).clear();
        mapAddress.sendKeys("киев");
        wait.until(ExpectedConditions.visibilityOf(mapAddressChoise)).click();

        wait.until(ExpectedConditions.visibilityOf(addPersonName)).clear();
        addPersonName.sendKeys("Ruslan");

        wait.until(ExpectedConditions.visibilityOf(saveOrderButton)).click();
        System.out.println("Order case!");
    }

    public void checkNewOrder(){
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(actualCheckOrderMessage)).getText(),"Ваше объявление принято!");
        System.out.println("Order successful!");
    }
}
