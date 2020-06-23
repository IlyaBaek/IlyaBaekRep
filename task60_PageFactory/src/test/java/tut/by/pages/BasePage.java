package tut.by.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT),this);
    }

    protected void clickOn(WebElement locator){
       wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    protected void typeIn(WebElement locator,String string){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(string);
    }
}
