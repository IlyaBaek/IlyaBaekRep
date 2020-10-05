package automationpractice.com.tests;

import WebDriverSingleton.WebDriverSingleton;
import automationpractice.com.pages.LoggedHomePage;
import automationpractice.com.pages.NotLoggedHomePage;
import automationpracticeListener.AutomationpracticeListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners(AutomationpracticeListener.class)
public class LoginTest {
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final String EMAIL = "1@1.com";
    private static final String PASSWORD = "QWEQWE";


    @BeforeClass
    public static void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(URL);
    }

    @AfterClass
    public static void endUp() {
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Feature("Login")
    @Description("Verify ability to log in")
    @TmsLink("TC-2")
    @Test
    public void loginTest() {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        LoggedHomePage loggedHomePage = notLoggedHomePage.logIn(EMAIL, PASSWORD);

        assertTrue(loggedHomePage.getAuthorized(),
                "if True than user is logged in and his profile button is displayed");
    }
}
