package tut.by.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private static final By LOGIN_INPUT = By.name("login");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector("div.b-hold>input[type='submit']");

    public LoginPage(){
        isDisplayed(LOGIN_BUTTON);
    }

    public LoggedHomePage logIn(String login, String password){
        typeIn(LOGIN_INPUT,login);
        typeIn(PASSWORD_INPUT,password);
        clickOn(LOGIN_BUTTON);
        return new LoggedHomePage();
    }
}
