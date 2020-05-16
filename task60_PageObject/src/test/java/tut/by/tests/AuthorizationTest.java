package tut.by.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tut.by.pages.HomePage;
import tut.by.pages.LoginPage;
import static org.testng.Assert.assertEquals;

public class AuthorizationTest {
    private static final String url = "https://www.tut.by/";
    private static final String username = "seleniumtests@tut.by";
    private static final String password = "123456789zxcvbn";
    private static final String usertext = "Selenium Test";
    private WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void endUp(){
        driver.close();
    }

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openLoginWindow();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn(username,password);

        assertEquals(homePage.getCurrentUserText(), usertext);
    }

    @Test
    public void logoutTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openLoginWindow();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(username,password);

        homePage.logOut();

        Assert.assertTrue(homePage.getUnauthorized());
    }
}
