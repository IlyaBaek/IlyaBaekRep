package tut.by.pages;

import org.openqa.selenium.By;

public class LoggedHomePage extends BasePage {
    private static final By USER_NAME = By.className("uname");
    private static final By LOGOUT_BUTTON = By.className("auth__reg");

    public LoggedHomePage(){
        isDisplayed(USER_NAME);
    }

    public String getCurrentUserText(){
        return getText(USER_NAME);
    }

    public NotLoggedHomePage logOut(){
        clickOn(USER_NAME);
        clickOn(LOGOUT_BUTTON);
        return new NotLoggedHomePage();
    }
}
