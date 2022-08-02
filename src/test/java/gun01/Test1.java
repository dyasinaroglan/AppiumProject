package gun01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        //Desired Capability
        //Hangi cihaz ve hangi uygulamaya bağlanılacak

        /*
        {
            "appium:udid": "emulator-5554",
            "appium:version": "11",
            "appium:deviceName": "Pixel2",
            "platformName": "Android"
}
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid","emulator-5554");
        capabilities.setCapability("appium:version",11);
        capabilities.setCapability("appium:deviceName","Pixel12");
        capabilities.setCapability("platformName","Android");

        capabilities.setCapability("appium:appPackage","io.appium.android.apis"); //Uygulamanın package ismi
        capabilities.setCapability("appium:appActivity","io.appium.android.apis.ApiDemos"); //Uygulamanın activity ismi
        //burada çalıştıracağım emülatörü ve test edeceğim uygulamayı yazdım
        //RemoteDriver --> WebDriver --> AppiumDriver --> (AndroidDriver, İOSDriver)

        AppiumDriver<MobileElement> driver;
        //appium 4723 portundan çalışıyor olmalı

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();
        Thread.sleep(1000);
        driver.closeApp();

    }
}
