package tut.by.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class HomePage  extends BasePage {
    private By LOGIN_WINDOW_BUTTON = By.className("enter");
    private By USER_NAME = By.className("uname");
    private By LOGOUT_BUTTON = By.className("auth__reg");

    public HomePage(WebDriver driver){
       super(driver);
       assertTrue(isDisplayed(LOGIN_WINDOW_BUTTON));
    }

    public void openLoginWindow(){
        clickOn(LOGIN_WINDOW_BUTTON);
    }

    public String getCurrentUserText(){
        return getText(USER_NAME);
    }

    public void logOut(){
        clickOn(USER_NAME);
        clickOn(LOGOUT_BUTTON);
    }

    public boolean getUnauthorized(){
        return isEnabled(LOGIN_WINDOW_BUTTON);
    }
}
