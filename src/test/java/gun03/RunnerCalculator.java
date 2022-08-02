package gun03;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/gun03/MyStepdefs.java", glue = "gun03")



public class RunnerCalculator extends AbstractTestNGCucumberTests {
}
