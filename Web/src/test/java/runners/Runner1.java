package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilsweb.Driver;


@CucumberOptions(
        features = {"Web/src/test/java/features/Feature1.feature"},
        glue = {"stepdefs"}



)

public class Runner1 extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("ortam")
    public void beforeTest(@Optional("PC") String ortam){
        if(ortam.equalsIgnoreCase("mobil"))
            Driver.getMobilDriver();
        else
            Driver.getDriver();
    }



}
