package tut.by.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotLoggedHomePage extends BasePage {
    @FindBy(className = "enter")
    private WebElement LOGIN_WINDOW_BUTTON;

    public NotLoggedHomePage() {
       LOGIN_WINDOW_BUTTON.isDisplayed();
    }

    public LoginPage openLoginWindow() {
        clickOn(LOGIN_WINDOW_BUTTON);
        return new LoginPage();
    }

    public boolean getUnauthorized() {
        return LOGIN_WINDOW_BUTTON.isEnabled();
    }
}
