package gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Test2 {

    /*
    Appium'u açmadığımızda veya unuttuğumuzda Appium'u java ile çalıştırmak için AppiumDriverLocalService'ı kullanıyoruz.
    Service'ı start ediyoruz
    Capabilities'ı oluşturuyoruz
    driver'ı oluşturuyoruz ve driver'ımızı AppiumDriverLocalService'ı kullanarak bağlıyoruz
    ve service'ın getUrl adresini kullanarak driver'ın bağlantısını sağlıyoruz.
    en son service'ın stop edilmesini istiyoruz.
     */
    AppiumDriverLocalService service;

    @Test
    public void test2(){

        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort().build();
        service.start();

        //Desired Capability
        //hangi cihaz ve hangi uygulama bağlanaılacak

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid","emulator-5554");
        capabilities.setCapability("appium:version","11");
        capabilities.setCapability("appium:deviceName","Pixel12");
        capabilities.setCapability("platformName","Android");

        capabilities.setCapability("appium:appPackage","io.appium.android.apis");
        capabilities.setCapability("appium:appActivity","io.appium.android.apis.ApiDemos");

        // RemoteWebDriver -> WebDriver -> AppiumDriver --> (AndroidDriver, iOSDriver)

        AppiumDriver<MobileElement> driver;

        driver = new AndroidDriver<>(service.getUrl(),capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();

        driver.closeApp();
        service.stop();
    }
}
