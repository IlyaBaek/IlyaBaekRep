package by.tut.tests;
import by.tut.webpages.HomePage;
import by.tut.webpages.LoginPage;
import by.tut.webpages.Task2AllByElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private static final String URL = "https://www.tut.by/";
    private LoginPage objLoginPage;
    private HomePage objHomePage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                //POINT 2
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.quit();
    }

    @DataProvider(name = "credentialsDataSet")                                                              //POINT 1
    public Object[][] credentialsDataSet() {
        return new Object[][] {
                { "seleniumtests@tut.by", "123456789zxcvbn"},
                { "seleniumtests2@tut.by", "123456789zxcvbn"}
        };
    }

    @Test(dataProvider = "credentialsDataSet", groups = "task40")
    public void twoLoginsTest(String paramLogin, String paramPassword){
        objLoginPage = new LoginPage(driver);

        objLoginPage.signInToTutBy(paramLogin,paramPassword);

        objHomePage = new HomePage(driver);
        assertEquals(objHomePage.getHomePageUserName(),"Selenium Test");
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test(enabled = false, groups = "task30")
    public void loginTest() throws InterruptedException {
        objLoginPage = new LoginPage(driver);
         final String login = "seleniumtests@tut.by";
         final String password = "123456789zxcvbn";

        objLoginPage.signInToTutBy(login,password);

        Thread.sleep(100);                                                      //POINT 3  it is an Explicit wait.
        objHomePage = new HomePage(driver);
        assertEquals(objHomePage.getHomePageUserName(),"Selenium Test");
    }

    @Test(enabled = false, groups = "task30")
    public void taskTwoAllByElements(){
        Task2AllByElements objAllElements = new Task2AllByElements(driver);

        objAllElements.locateElements();
    }
}
