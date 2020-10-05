package automationpractice.com.tests;

import WebDriverSingleton.WebDriverSingleton;
import automationpractice.com.Models.UserAccontModel;
import automationpractice.com.pages.CreateAnAccountPage;
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

import java.util.Random;

import static org.testng.Assert.assertTrue;

@Listeners(AutomationpracticeListener.class)
public class CreateAnAccountTest {
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private Random randomEmail = new Random();
    private int randomInt = randomEmail.nextInt(10000);
    private String email = "test" + randomInt + "@com.com";

    @BeforeClass
    public static void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(URL);
    }

    @AfterClass
    public static void endUp() {
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Feature("Create An Account")
    @Description("Verify ability to create an account")
    @TmsLink("TC-1")
    @Test
    public void createAccountTest() {
        NotLoggedHomePage notLoggedHomePage = new NotLoggedHomePage();
        CreateAnAccountPage createAnAccountPage = notLoggedHomePage.openCreateAccountPage(email);
        UserAccontModel userAccontModel = new UserAccontModel();

        LoggedHomePage loggedHomePage = createAnAccountPage.register(userAccontModel);
        assertTrue(loggedHomePage.getAuthorized(),
                "if True than user is created and logged in and his profile button is displayed");
    }
}
