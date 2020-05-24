package tut.by.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage  extends BasePage {
    private static final By LOGIN_WINDOW_BUTTON = By.className("enter");
    private static final By USER_NAME = By.className("uname");
    private static final By LOGOUT_BUTTON = By.className("auth__reg");

    public HomePage(WebDriver driver){
       super(driver);
      isDisplayed(LOGIN_WINDOW_BUTTON);
    }

    public LoginPage openLoginWindow(){
        clickOn(LOGIN_WINDOW_BUTTON);
        return new LoginPage(driver);

    }

    public String getCurrentUserText(){
        return getText(USER_NAME);
    }

    public HomePage logOut(){
        clickOn(USER_NAME);
        clickOn(LOGOUT_BUTTON);
        return new HomePage(driver);
    }

    public boolean getUnauthorized(){
        return isEnabled(LOGIN_WINDOW_BUTTON);

    }
}
