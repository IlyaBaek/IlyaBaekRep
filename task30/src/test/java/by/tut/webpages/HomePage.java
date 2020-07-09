package by.tut.webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private By HomePageUserName = By.className("uname");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageUserName(){
        WebDriverWait wait = new WebDriverWait(this.driver, 6, 1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageUserName));                           //POINT 4
        return driver.findElement(HomePageUserName).getText();
    }
}
