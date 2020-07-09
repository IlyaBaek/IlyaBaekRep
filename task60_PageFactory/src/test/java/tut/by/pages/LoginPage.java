package tut.by.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "login")
    private WebElement LOGIN_INPUT;
    @FindBy(name = "password")
    private WebElement PASSWORD_INPUT;
    @FindBy(css = "div.b-hold>input[type='submit']")
    private WebElement LOGIN_BUTTON;

    public LoginPage() {
        LOGIN_BUTTON.isDisplayed();
    }

    public LoggedHomePage logIn(String login, String password) {
        typeIn(LOGIN_INPUT, login);
        typeIn(PASSWORD_INPUT, password);
        clickOn(LOGIN_BUTTON);
        return new LoggedHomePage();
    }
}
