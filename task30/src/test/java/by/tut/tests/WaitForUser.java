package by.tut.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test(groups = "task40")                                                                                      //POINT 7
public class WaitForUser {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html";
    private By getNewUserButton = By.cssSelector("button.btn");
    private By getUser = By.xpath("//div[@id='loading' and contains(text(), 'First Name')]");
    private By getLoading = By.xpath("//div[@id='loading' and contains(text(), 'loading...')]");

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //POINT 2
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.quit();
    }

    @Test
    public void waitForUserTest() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        driver.findElement(getNewUserButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(getLoading));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getLoading));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUser));
    }
}


