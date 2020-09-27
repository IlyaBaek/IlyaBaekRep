package automationpractice.com.tests;

import WebDriverSingleton.WebDriverSingleton;
import automationpractice.com.pages.LoggedHomePage;
import automationpractice.com.pages.NotLoggedHomePage;
import automationpractice.com.pages.WomenStorePage;
import automationpracticeListener.AutomationpracticeListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;

import static org.testng.Assert.assertEquals;

@Listeners(AutomationpracticeListener.class)
public class AddToCartTest {
    private static final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final String email = "1@1.com";
    private static final String password = "QWEQWE";
    private HashSet<Integer> randomProduct = new HashSet<>();
    private Random random = new Random();
    private double sum;
    DecimalFormat df = new DecimalFormat("#.00");

    @BeforeClass
    public static void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(url);
        new NotLoggedHomePage().logIn(email, password);
    }

    @AfterClass
    public static void endUp() {
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Feature("Add to Cart")
    @Description("Verify ability to add to Cart")
    @TmsLink("TC-5")
    @Test
    public void addThreeRandomProductsToCartTest() {
        LoggedHomePage loggedHomePage = new LoggedHomePage();
        WomenStorePage womenStorePage = loggedHomePage.openWomenStorePage();

        addThreeRandomProductsToCart(womenStorePage);

        double total = loggedHomePage.getTotalCartPrice();
        assertEquals(df.format(sum), df.format(total));
    }

    public void addThreeRandomProductsToCart(WomenStorePage womenStorePage) {
        do {
            randomProduct.add(random.nextInt(womenStorePage.getCountOfProducts()));
        } while (randomProduct.size() < 3);


        for (Integer option : randomProduct) {
            womenStorePage.pressAddtoCartButton(option);
            womenStorePage.pressContinueShoppingButton();
            sum = sum + womenStorePage.getProductPrice(option);
        }
    }
}
