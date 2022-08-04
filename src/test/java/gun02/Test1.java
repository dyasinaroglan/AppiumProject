package gun02;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.*;
import static utils.Utils.openApp;

public class Test1 {

    AppiumDriver<?> driver;  //MobileElement yerine soru işareti koyabiliriz.
    WebDriverWait wait;

    @Test
    public void runAppiumTest() {

        Driver.runAppium();

        Driver.stopAppium();

    }
    @Test
    public void testGetDriver(){
        Driver.runAppium();

        driver = Driver.getDriver(Device.MyEmulatör, App.APIAPP);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();

        Driver.stopAppium();
    }
    @Test
    public void openAppTest(){

        By accecibility = By.xpath("//android.widget.TextView[@content-desc='Accessibility']");
        By customView = By.xpath("//android.widget.TextView[@content-desc=\"Custom View\"]");

        driver = openApp(Device.MyEmulatör, App.APIAPP);

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(accecibility)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(customView)).click();
        driver.navigate().back();
        driver.closeApp();
        Driver.stopAppium();
    }
}
