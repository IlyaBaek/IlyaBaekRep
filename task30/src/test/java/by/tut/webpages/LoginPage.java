package by.tut.webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    By SignInWindowButton = By.className("enter");
    By LoginInput = By.name("login");
    By PasswordInput = By.name("password");
    By SignInButton = By.xpath("//input[@tabindex='4']");

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
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(SignInButton))).click();
    }

    public void signInToTutBy(String strUserName, String strPassword) {
        clickSignInWindowButton();
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        clickSignInButton();
    }
}
