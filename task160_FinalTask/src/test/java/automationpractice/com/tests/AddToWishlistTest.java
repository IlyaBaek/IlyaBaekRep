package automationpractice.com.tests;

import WebDriverSingleton.WebDriverSingleton;
import automationpractice.com.pages.LoggedHomePage;
import automationpractice.com.pages.NotLoggedHomePage;
import automationpractice.com.pages.ProductDetailsPage;
import automationpractice.com.pages.WishlistPage;
import automationpracticeListener.AutomationpracticeListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(AutomationpracticeListener.class)
public class AddToWishlistTest {
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final String EMAIL = "1@1.com";
    private static final String PASSWORD = "QWEQWE";
    private static final String wishlistName = "WishlistName";
    private String addedProductId;
    private String wishlistProductId;

    @BeforeClass
    public static void setUp() {
        WebDriverSingleton.getInstance().getDriver().get(URL);
        new NotLoggedHomePage().logIn(EMAIL, PASSWORD);
    }

    @AfterClass
    public static void endUp() {
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Feature("Add product to auto-created wishlist")
    @Description("Verify ability add product to auto-created wishlist")
    @TmsLink("TC-3")
    @Test
    public void addAutoCreatedWishList() {
        LoggedHomePage loggedHomePage = new LoggedHomePage().openLoggedHomePage();
        WishlistPage wishlistPage = loggedHomePage.openMyWishlistsPage();

        //Return True if there are no wishlists created yet, return False if there are some wishlists
        checkIfWishlistIsEmpty(wishlistPage);
        addRandomProductDetailToWishlist(wishlistPage, loggedHomePage);

        assertEquals(addedProductId, wishlistProductId);
    }

    @Feature("Add product to specific wishlist")
    @Description("Verify ability add product to specific wishlist")
    @TmsLink("TC-4")
    @Test
    public void addToSpecificWishList() {
        LoggedHomePage loggedHomePage = new LoggedHomePage().openLoggedHomePage();
        WishlistPage wishlistPage = loggedHomePage.openMyWishlistsPage();

        //Return True if there are no wishlists created yet, return False if there are some wishlists
        checkIfWishlistIsEmpty(wishlistPage);
        wishlistPage.createWishlist(wishlistName);
        addRandomProductDetailToWishlist(wishlistPage, loggedHomePage);

        assertEquals(addedProductId, wishlistProductId);
    }

    public void checkIfWishlistIsEmpty(WishlistPage wishlistPage1) {
        if (wishlistPage1.getWishlistState()) {
            do {
                wishlistPage1.deleteWishlist();
                threadSleep();
                WebDriverSingleton.getInstance().getDriver().switchTo().alert().accept();
                threadSleep();
            } while (wishlistPage1.getWishlistState());
        }
    }

    public void addRandomProductDetailToWishlist(WishlistPage wishlistPage, LoggedHomePage loggedHomePage) {
        ProductDetailsPage productDetailsPage = wishlistPage.openRandomProductDetails();
        addedProductId = productDetailsPage.getProductId();
        productDetailsPage.pressAddToWishlistButton();
        wishlistPage = loggedHomePage.openLoggedHomePage().openMyWishlistsPage();
        wishlistProductId = wishlistPage.openMyWishList().openMyItemFromWishList().getProductId();
    }

    public void threadSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}