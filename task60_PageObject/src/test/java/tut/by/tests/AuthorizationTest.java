package tut.by.tests;

import WebDriverSingleton.WebDriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tut.by.pages.LoggedHomePage;
import tut.by.pages.LoginPage;
import tut.by.pages.NotLoggedHomePage;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest {
    private static final String url = "https://www.tut.by/";
    private static final String username = "seleniumtests@tut.by";
    private static final String password = "123456789zxcvbn";
    private static final String usertext = "Selenium Test";

    @BeforeMethod
    public void setUp() {
        WebDriverSingleton.getInstance();
        WebDriverSingleton.getDriver().get(url);
    }

    @AfterMethod
    public void endUp() {
        WebDriverSingleton.driverQuit();
    }

    @Test
    public void loginTest() {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoginPage loginPage = notLoggedHomePage.openLoginWindow();

        LoggedHomePage loggedHomePage = loginPage.logIn(username, password);

        assertEquals(loggedHomePage.getCurrentUserText(), usertext);
    }

    @Test
    public void logoutTest() {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoginPage loginPage = notLoggedHomePage.openLoginWindow();
        LoggedHomePage loggedHomePage = loginPage.logIn(username, password);

        loggedHomePage.logOut();

        Assert.assertTrue(notLoggedHomePage.getUnauthorized(), "Return true if login button is available(the user is not logged in");
    }
}
