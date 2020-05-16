package tut.by.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage{
    private By LOGIN_INPUT = By.name("login");
    private By PASSWORD_INPUT = By.name("password");
    private By LOGIN_BUTTON = By.cssSelector("div.b-hold>input[type='submit']");

    public LoginPage(WebDriver driver){
        super(driver);
        assertTrue(isDisplayed(LOGIN_BUTTON));
    }

    public void logIn(String login, String password){
        typeIn(LOGIN_INPUT,login);
        typeIn(PASSWORD_INPUT,password);
        clickOn(LOGIN_BUTTON);
    }
}
