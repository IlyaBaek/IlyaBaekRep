package tut.by.tests;

import TutbyListener.TutByListener;
import WebDriverSingleton.WebDriverSingleton;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tut.by.pages.LoggedHomePage;
import tut.by.pages.LoginPage;
import tut.by.pages.NotLoggedHomePage;

import static org.testng.Assert.assertEquals;

@Listeners(TutByListener.class)
public class AuthorizationTest {
    private static final String url = "https://www.tut.by/";
    private static final String username = "seleniumtests@tut.by";
    private static final String password = "123456789zxcvbn";
    private static final String usertext = "Selenium Test";
    private static final String unauthorizedText = "Войти";

    @BeforeMethod
    public void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(url);
    }

    @AfterMethod
    public void endUp() {
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Feature("Login")
    @Description("Verify ability to log in")
    @TmsLink("TC-1")
    @Test(groups = "Authorization")
    public void loginTest() {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoginPage loginPage = notLoggedHomePage.openLoginWindow();

        LoggedHomePage loggedHomePage = loginPage.logIn(username, password);

        assertEquals(loggedHomePage.getCurrentUserText(), usertext);
    }

    @Feature("Logout")
    @Description("Verify ability to log out")
    @TmsLink("TC-2")
    @Test(groups = "Authorization")
    public void logoutTest() {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoginPage loginPage = notLoggedHomePage.openLoginWindow();
        LoggedHomePage loggedHomePage = loginPage.logIn(username, password);

        loggedHomePage.logOut();

        assertEquals(notLoggedHomePage.getUnauthorizedText(), unauthorizedText);
    }
}
