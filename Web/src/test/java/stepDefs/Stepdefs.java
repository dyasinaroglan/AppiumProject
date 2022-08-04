package stepDefs;

import com.sun.javafx.collections.MappingChange;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilsweb.Driver;

import java.io.IOException;
import java.util.Map;

import static utilsweb.Locators.*;
import static utils.Locators.*;


public class Stepdefs {

    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
    }

    @Given("user on homePage")
    public void userOnHomePage() {

        driver.get(url);
    }

    @When("user fill the login form as follows")
    public void userFillTheLoginFormAsFollows(DataTable table) {
        Map<String, String> map = table.asMap(null,null);
        wait.until(ExpectedConditions.visibilityOfElementLocated(luserName)).sendKeys(map.get("username"));
        driver.findElement(lPassword).sendKeys(map.get("password"));

    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        driver.findElement(lSubmitButton).click();
    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lWelcome));
    }

    @And("driver close")
    public void driverClose() {
        driver.quit();
    }
}
