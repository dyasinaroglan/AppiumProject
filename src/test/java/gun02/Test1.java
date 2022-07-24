package gun02;

import org.testng.annotations.Test;
import utils.DriverSelenium;

public class Test1 {

    @Test
    public void test1() {

        DriverSelenium.getDriver().get("https://www.google.com");
        DriverSelenium.quitDriver();

    }
}
