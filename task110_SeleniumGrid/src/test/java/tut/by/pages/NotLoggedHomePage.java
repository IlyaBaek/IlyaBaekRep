package tut.by.pages;

import org.openqa.selenium.By;

public class NotLoggedHomePage extends BasePage {
    //Good locator
    //private static final By LOGIN_WINDOW_BUTTON = By.xpath("//a[@class='enter']");
    //Bad locator(but it helps not to fail test on "Unable to locate element instead of Assertion)
    private static final By LOGIN_WINDOW_BUTTON = By.className("enter");

    public NotLoggedHomePage() {
        isEnabled(LOGIN_WINDOW_BUTTON);
    }

    public LoginPage openLoginWindow() {
        clickOn(LOGIN_WINDOW_BUTTON);
        return new LoginPage();
    }

    public String getUnauthorizedText() {
        return getText(LOGIN_WINDOW_BUTTON);
    }
}
