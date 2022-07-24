package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Driver {

    public static AppiumDriver<MobileElement> driver;
    static AppiumDriverLocalService service;

    public static void runAppium() {
        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1")
                .usingPort(1111)
                .usingAnyFreePort().build();
    }

}
