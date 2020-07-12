package tut.by.pages;

import WebDriverSingleton.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    private WebDriverWait wait;

    public BasePage() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    protected WebElement getElement(By locartor) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locartor));
    }

    protected void clickOn(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
    }

    protected void typeIn(By locator, String string) {
        wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).sendKeys(string);
    }

    protected boolean isEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    protected boolean isDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    protected String getText(By locator) {
        return getElement(locator).getText();
    }
}
