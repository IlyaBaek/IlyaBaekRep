package by.tut.webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;
    private By SignInWindowButton = By.className("enter");
    private By LoginInput = By.name("login");
    private By PasswordInput = By.name("password");
    private By SignInButton = By.cssSelector("div.b-hold>input[type='submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSignInWindowButton(){
        driver.findElement(SignInWindowButton).click();
    }

    public void setUserName(String strUserName){
        driver.findElement(LoginInput).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        driver.findElement(PasswordInput).sendKeys(strPassword);
    }

    public void clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SignInButton))).click();
    }

    public void signInToTutBy(String strUserName, String strPassword) {
        clickSignInWindowButton();
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        clickSignInButton();
    }
}
