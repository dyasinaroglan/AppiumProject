package gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utils.App;
import utils.Device;

public class Test3 {

    AppiumDriverLocalService service;

    Device device = Device.PIXEL2;
    App app = App.APIDEMO;

    @Test
    public void test3(){
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(1111)
                .usingAnyFreePort().build();
        service.start();

        //Desired capability
        //hangi cihaz hangi uygulamaya bağlanıcak
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid",device.udid);
        capabilities.setCapability("appium:version",device.version);
        capabilities.setCapability("appium:deviceName",device.deviceName);

        capabilities.setCapability("appium:appPackage",app.appPackage);
        capabilities.setCapability("appium:appActivity",app.appActivity);

        // RemoteWebDriver -> WebDriver -> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;
        driver = new AndroidDriver<>(service.getUrl(),capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']")).click();

        driver.closeApp();
        service.stop();
    }
}
