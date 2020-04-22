package by.tut.tests;
import by.tut.webpages.HomePage;
import by.tut.webpages.LoginPage;
import by.tut.webpages.Task2AllByElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    String login = "seleniumtests@tut.by";
    String password = "123456789zxcvbn";
    String URL = "https://www.tut.by/";
    LoginPage objLoginPage;
    HomePage objHomePage;
    Task2AllByElements objAllElements;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.quit();
    }

    @Test
    public void loginTest() {
        objLoginPage = new LoginPage(driver);

        objLoginPage.signInToTutBy(login,password);

        objHomePage = new HomePage(driver);
        assertEquals(objHomePage.getHomePageUserName(),"Selenium Test");
    }

    @Test
    public void taskTwoAllByElements(){
        objAllElements = new Task2AllByElements(driver);

        objAllElements.locateElements();
    }
}
