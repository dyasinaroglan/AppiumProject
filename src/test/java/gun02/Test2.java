package gun02;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Utils.openApp;

public class Test2 {

    AppiumDriver<?> driver;
    WebDriverWait wait;

    By accecibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");
    By customView = By.xpath("//android.widget.TextView[@content-desc=\"Custom View\"]");

    @BeforeTest
    public void beforeTest() {
        driver = openApp(Device.PIXEL2, App.APIAPP);
        wait = new WebDriverWait(driver, 20);
    }
    @Test
    public void test1(){

        wait.until(ExpectedConditions.elementToBeClickable(accecibility)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customView)).click();
        driver.navigate().back();
    }

    @AfterTest
    public void afterTest() {

        driver.closeApp();
        Driver.stopAppium();
    }
}
