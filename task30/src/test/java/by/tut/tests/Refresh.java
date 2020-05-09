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

@Test(groups = "task40")                                                                                      //POINT 8
public class Refresh {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html";
    private By downloadButton = By.cssSelector("button#cricle-btn");
    private By precentText = By.cssSelector("div.percenttext");

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
    public void refreshTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        driver.findElement(downloadButton).click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(precentText), "50%"));
        driver.navigate().refresh();
    }
}
