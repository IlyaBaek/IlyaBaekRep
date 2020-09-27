package automationpractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotLoggedHomePage extends BasePage {
    //Create An Account
    @FindBy(id = "email_create")
    private WebElement CREATE_EMAIL_ADDRESS_INPUT;
    @FindBy(name = "SubmitCreate")
    private WebElement CREATE_AN_ACCOUNT_BUTTON;
    //Sign In
    @FindBy(id = "email")
    private WebElement EMAIL_ADDRESS_INPUT;
    @FindBy(id = "passwd")
    private WebElement PASSWORD_INPUT;
    @FindBy(id = "SubmitLogin")
    private WebElement SIGN_IN_BUTTON;

    public NotLoggedHomePage() {
        CREATE_AN_ACCOUNT_BUTTON.isDisplayed();
    }

    public CreateAnAccountPage openCreateAccountPage(String email) {
        typeIn(CREATE_EMAIL_ADDRESS_INPUT, email);
        clickOn(CREATE_AN_ACCOUNT_BUTTON);
        return new CreateAnAccountPage();
    }

    public LoggedHomePage logIn(String email, String password) {
        typeIn(EMAIL_ADDRESS_INPUT, email);
        typeIn(PASSWORD_INPUT, password);
        clickOn(SIGN_IN_BUTTON);
        return new LoggedHomePage();
    }
}
