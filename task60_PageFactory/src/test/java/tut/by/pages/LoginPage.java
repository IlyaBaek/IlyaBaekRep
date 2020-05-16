package tut.by.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage{
    @FindBy(name = "login")
    private WebElement LOGIN_INPUT;
    @FindBy(name = "password")
    private WebElement PASSWORD_INPUT;
    @FindBy(css = "div.b-hold>input[type='submit']")
    private WebElement LOGIN_BUTTON;

    public LoginPage(WebDriver driver){
        super(driver);
        assertTrue(LOGIN_BUTTON.isDisplayed());
    }

    public void logIn(String login, String password){
        typeIn(LOGIN_INPUT,login);
        typeIn(PASSWORD_INPUT,password);
        clickOn(LOGIN_BUTTON);
    }
}
