package utilsweb;

import org.openqa.selenium.By;

public interface Locators {

    String url = "https://opensource-demo.orangehrmlive.com/";
    By luserName = By.id("txtUsername");
    By lPassword = By.id("txtPassword");
    By lSubmitButton = By.id("btnLogin");
    By lWelcome = By.id("welcome");

}
