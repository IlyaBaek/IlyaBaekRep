package tut.by.pages;

import org.openqa.selenium.By;

public class NotLoggedHomePage extends BasePage {
    private static final By LOGIN_WINDOW_BUTTON = By.className("enter");

    public NotLoggedHomePage() {
        isDisplayed(LOGIN_WINDOW_BUTTON);
    }

    public LoginPage openLoginWindow() {
        clickOn(LOGIN_WINDOW_BUTTON);
        return new LoginPage();
    }

    public boolean getUnauthorized() {
        return isEnabled(LOGIN_WINDOW_BUTTON);
    }
}
