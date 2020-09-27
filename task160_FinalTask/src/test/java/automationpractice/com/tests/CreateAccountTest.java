package automationpractice.com.tests;

import WebDriverSingleton.WebDriverSingleton;
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
public class CreateAccountTest {
    private static final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    //private static final String email = "111@1.com";
    ///
    private static final String firstName = "qwe";
    private static final String lastName = "asd";
    private static final String password = "qweqwe";
    private static final Integer dayOfBirth = 1;
    private static final Integer monthOfBirth = 2;
    private static final Integer yearOfBirth = 3;
    private static final String addressFirstName = "qwe";
    private static final String addressLastName = "zxc";
    //private static final String company = "zxc";
    private static final String address = "qweasdzxc";
    private static final String city = "Minsk";
    private static final Integer state = 1;
    private static final String zipPostcode = "00000";
    //private static final Integer country = 2;
    private static final String mobilePhone = "+375 75 755 75 75";
    private static final String addressAlias = "qweasdzxcqweasdzxc";

    Random randomEmail = new Random();
    int randomInt = randomEmail.nextInt(10000);
    String email = "test" + randomInt + "@com.com";

    @BeforeClass
    public static void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(url);
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

        LoggedHomePage loggedHomePage = createAnAccountPage.register(
                firstName, lastName, email, password, dayOfBirth, monthOfBirth, yearOfBirth,
                addressFirstName, addressLastName, address, city, state, zipPostcode,
                mobilePhone, addressAlias);

        assertTrue(loggedHomePage.getAuthorized(),
                "if True than user is created and logged in and his profile button is displayed");
    }
}
