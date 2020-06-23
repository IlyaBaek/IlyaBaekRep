package tut.by.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.testng.Assert.assertTrue;

public class HomePage  extends BasePage {
    @FindBy(className = "enter")
    private WebElement LOGIN_WINDOW_BUTTON;
    @FindBy(className = "uname")
    private WebElement USER_NAME;
    @FindBy(className = "auth__reg")
    private WebElement LOGOUT_BUTTON;

    public HomePage(WebDriver driver){
       super(driver);
       assertTrue(LOGIN_WINDOW_BUTTON.isDisplayed());
    }

    public void openLoginWindow(){
        clickOn(LOGIN_WINDOW_BUTTON);
    }

    public String getCurrentUserText(){
        return USER_NAME.getText();
    }

    public void logOut(){
        clickOn(USER_NAME);
        clickOn(LOGOUT_BUTTON);
    }

    public boolean getUnauthorized(){
        return LOGIN_WINDOW_BUTTON.isEnabled();
    }
}
