package automationpractice.com.pages;

import WebDriverSingleton.WebDriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    private WebDriverWait wait;
    private JavascriptExecutor jse = (JavascriptExecutor) WebDriverSingleton.getInstance().getDriver();

    public BasePage() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void clickOn(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void moveMouse(WebElement locator) {
        jse.executeScript("arguments[0].scrollIntoView();", locator);
        Actions actions = new Actions(WebDriverSingleton.getInstance().getDriver());
        actions.moveToElement(locator).build().perform();
    }

    protected void typeIn(WebElement locator, String string) {
        locator.clear();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(string);
    }

    protected void selectFromDropdown(WebElement locator, Integer integer) {
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(locator);
        select.selectByIndex(integer);
    }

    protected String getText(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator)).getText();
    }
    /*
    protected void acceptAlert() {
        WebDriverSingleton.getInstance().getDriver().switchTo().alert().accept();
    }
    */
}


