package by.tut.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

@Test(groups = "task40")                                                                                                            //Point 6
public class AlertsTest {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html";
    private By alertBoxButton = By.cssSelector("button[onclick='myAlertFunction()']");
    private By confirmBoxButton = By.cssSelector("button[onclick='myConfirmFunction()']");
    private By confirmBoxResult = By.cssSelector("p#confirm-demo");

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.quit();
    }

    @Test
    public void javascriptAlertBoxTest() {
        driver.findElement(alertBoxButton).click();

        String jsAlertWindow = driver.switchTo().alert().getText();
        assertEquals(jsAlertWindow, "I am an alert box!");
    }

    @Test()
    public void javascriptConfirmBoxOKTest(){
        driver.findElement(confirmBoxButton).click();

        driver.switchTo().alert().accept();
        String actualText = driver.findElement(confirmBoxResult).getText();
        assertEquals(actualText, "You pressed OK!");
    }

    @Test()
    public void javascriptConfirmBoxCancelTest(){
        driver.findElement(confirmBoxButton).click();

        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(confirmBoxResult).getText();
        assertEquals(actualText, "You pressed Cancel!");
    }
}
