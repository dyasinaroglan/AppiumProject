package utilsweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Driver {

    private static WebDriver driver;
    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(drivers.get() == null){
            WebDriverManager.chromedriver().setup();
            drivers.set(new ChromeDriver());
        }
        return drivers.get();
    }
    public static WebDriver getMobilDriver() {

        if(drivers.get() == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("androidPackage","com.android.chrome");

            drivers.set(new ChromeDriver(options));
        }
        return drivers.get();
    }
}
