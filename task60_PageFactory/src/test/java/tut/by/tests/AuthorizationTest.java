package tut.by.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tut.by.pages.HomePage;
import tut.by.pages.LoginPage;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest {
    static String url = "https://www.tut.by/";
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
    public void loginTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openLoginWindow();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(username,password);

        this.takeScreenshot(driver,"E://homePageLogin.png");
        assertEquals(homePage.getCurrentUserText(), usertext);
    }

    @Test
    public void logoutTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.openLoginWindow();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(username,password);

        homePage.logOut();

        this.takeScreenshot(driver,"E://homePageLogout.png");
        Assert.assertTrue(homePage.getUnauthorized());
    }

    public static void takeScreenshot(WebDriver driver, String filePath) throws Exception{
        TakesScreenshot scrShot = ((TakesScreenshot)driver);

        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File(filePath);

        FileUtils.copyFile(srcFile,DestFile);
    }
}
