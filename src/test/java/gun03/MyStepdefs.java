package gun03;

import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.App;
import utils.Device;
import utils.Driver;

import java.util.List;

import static utils.Utils.openApp;

public class MyStepdefs {

    AppiumDriver<?> driver = Driver.getDriver();
    WebDriverWait wait;
    By lButtonAdd = By.id("calc_keypad_btn_add");
    By lButtonEqual = By.id("com.android.calculator2:id/eq");
    By lScreen = By.id("calc_screen");

    @Given("user on start page")
    public void userOnStartPage() {
        //driver = openApp(Device.MyEmulatör, App.APIAPP);
        //wait = new WebDriverWait(driver,20);
        driver.resetApp();  //uygulamayı kapatıp tekrar başlatıyor.
    }

    @When("user sum the following numbers")
    public void userSumTheFollowingNumbers(DataTable table) {

        List<Integer> list = table.asList(Integer.class);

        int max = list.size();
        int i = 1;

        for (Integer num : list) {
            click(num);
            if(i++ != max)  //önce işlem yapar yani eşit mi değil mi? sonra arttırma yapar.
            click(lButtonAdd);
        }
        click(lButtonEqual);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {
        Assert.assertTrue(driver.findElement(lScreen).getText().contains(result+""));
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void click(int num){
        if(num>=0 && num<=9) {
            click(By.xpath("//android.widget.Button[@content-desc='" + num + "']"));
        }
    }
}
