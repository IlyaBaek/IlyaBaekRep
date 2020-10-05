package automationpractice.com.pages;

import WebDriverSingleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class BasePage {
    public BasePage() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void clickOn(WebElement locator) {
        WebDriverSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void moveMouse(WebElement locator) {
        WebDriverSingleton.getInstance().getJavascriptExecutor().executeScript("arguments[0].scrollIntoView();", locator);
        WebDriverSingleton.getInstance().getActions().moveToElement(locator).build().perform();
    }

    protected void typeIn(WebElement locator, String string) {
        locator.clear();
        WebDriverSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(string);
    }

    protected void selectFromDropdown(WebElement locator, Integer integer) {
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(locator);
        select.selectByIndex(integer);
    }

    protected String getText(WebElement locator) {
        return WebDriverSingleton.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(locator)).getText();
    }
    /*
    protected void acceptAlert() {
        WebDriverSingleton.getInstance().getDriver().switchTo().alert().accept();
    }
    */
}


