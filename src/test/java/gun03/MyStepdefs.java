package gun03;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.App;
import utils.Device;

import java.util.List;

import static utils.Utils.openApp;

public class MyStepdefs {

    AppiumDriver<?> driver;
    WebDriverWait wait;
    By lButtonAdd = By.id("calc_keypad_btn_add");
    By lScreen = By.id("calc_screen");

    @Given("user on start page")
    public void userOnStartPage() {
        driver = openApp(Device.PIXEL2, App.APIAPP);
    }

    @When("user sum the following numbers")
    public void userSumTheFollowingNumbers(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        for (Integer num : list) {
            clickNum(num);
            
        }
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {
        System.out.println(driver.findElement(By.id("calc_edt_formula")).getText());
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void clickNum(int num){
        if(num>=0 && num<=9) {
            driver.findElement(By.xpath("//android.widget.Button[@content-desc='" + num + "']")).click();
        }
    }
}
