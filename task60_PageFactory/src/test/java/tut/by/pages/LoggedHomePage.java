package tut.by.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends BasePage {
    @FindBy(className = "uname")
    private WebElement USER_NAME;
    @FindBy(className = "auth__reg")
    private WebElement LOGOUT_BUTTON;

    public LoggedHomePage() {
       USER_NAME.isDisplayed();
    }

    public String getCurrentUserText() {
        return USER_NAME.getText();
    }

    public NotLoggedHomePage logOut() {
        clickOn(USER_NAME);
        clickOn(LOGOUT_BUTTON);
        return new NotLoggedHomePage();
    }
}
