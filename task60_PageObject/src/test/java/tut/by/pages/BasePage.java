package tut.by.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }

    protected WebElement getElement(By locartor){
        try{
            return wait.until(ExpectedConditions.presenceOfElementLocated(locartor));
        }
        catch (ElementNotVisibleException ex){
            throw ex;
        }
    }

    protected void clickOn(By locator){
       wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
    }
    protected void typeIn(By locator, String string){
        wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).sendKeys(string);
    }

    protected boolean isEnabled(By locator){
        return getElement(locator).isEnabled();
    }

    protected boolean isDisplayed(By locator){
        return getElement(locator).isDisplayed();
    }

    protected String getText(By locator){
        return getElement(locator).getText();
    }
}
