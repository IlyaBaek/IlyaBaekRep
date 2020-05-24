package tut.by.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage{
    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector("div.b-hold>input[type='submit']");

    public LoginPage(WebDriver driver){
        super(driver);
        isDisplayed(LOGIN_BUTTON);
    }

    public HomePage logIn(String login, String password){
        typeIn(LOGIN_INPUT,login);
        typeIn(PASSWORD_INPUT,password);
        clickOn(LOGIN_BUTTON);
        return new HomePage(driver);
    }
}
