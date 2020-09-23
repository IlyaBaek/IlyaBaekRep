package tut.by.tests;

import WebDriverSingleton.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tut.by.pages.LoggedHomePage;
import tut.by.pages.LoginPage;
import tut.by.pages.NotLoggedHomePage;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest {
    private static final String url = "https://www.tut.by/";
    private static final String username = "seleniumtests@tut.by";
    private static final String password = "123456789zxcvbn";
    private static final String usertext = "Selenium Test";

    @BeforeMethod
    public void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(url);
    }

    @AfterMethod
    public void endUp() {
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Test
    public void loginTest() throws Exception {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoginPage loginPage = notLoggedHomePage.openLoginWindow();

        LoggedHomePage loggedHomePage = loginPage.logIn(username, password);

        this.takeScreenshot(WebDriverSingleton.getInstance().getDriver(), "src/test/resources/homePageLoginTest.png");
        assertEquals(loggedHomePage.getCurrentUserText(), usertext);
    }

    @Test
    public void logoutTest() throws Exception {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoginPage loginPage = notLoggedHomePage.openLoginWindow();
        LoggedHomePage loggedHomePage = loginPage.logIn(username, password);

        loggedHomePage.logOut();

        this.takeScreenshot(WebDriverSingleton.getInstance().getDriver(), "src/test/resources/homePageLogoutTest.png");
        Assert.assertTrue(notLoggedHomePage.getUnauthorized(),"Return true if login button is available(the user is not logged in");
    }

    public void takeScreenshot(WebDriver driver, String filePath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File(filePath);

        FileUtils.copyFile(srcFile, DestFile);
    }
}
