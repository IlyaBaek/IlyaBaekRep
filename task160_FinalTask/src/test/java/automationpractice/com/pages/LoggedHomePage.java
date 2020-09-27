package automationpractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends BasePage {
    @FindBy(css = "a.account")
    private WebElement AUTHORIZED_DIV;
    @FindBy(className = "lnk_wishlist")
    private WebElement WISHLIST_BUTTON;
    @FindBy(css = "a[title='Women']")
    private WebElement WOMEN_STORE_LINK;
    @FindBy(css = ".cart_block_total")
    private WebElement TOTAL_CART_PRICE;
    @FindBy(css = ".cart_block_shipping_cost ")
    private WebElement TOTAL_CART_SHIPPING_PRICE;
    @FindBy(css = ".shopping_cart>a")
    private WebElement CART_SECTION;

    public LoggedHomePage() {
        AUTHORIZED_DIV.isEnabled();
    }

    public boolean getAuthorized() {
        return AUTHORIZED_DIV.isDisplayed();
    }

    public WishlistPage openMyWishlistsPage() {
        clickOn(WISHLIST_BUTTON);
        return new WishlistPage();
    }

    public LoggedHomePage openLoggedHomePage() {
        moveMouse(AUTHORIZED_DIV);
        clickOn(AUTHORIZED_DIV);
        return new LoggedHomePage();
    }

    public WomenStorePage openWomenStorePage() {
        clickOn(WOMEN_STORE_LINK);
        return new WomenStorePage();
    }

    public Double getTotalCartPrice() {
        moveMouse(CART_SECTION);
        return Double.parseDouble(getText(TOTAL_CART_PRICE).replace("$", ""))
                - Double.parseDouble(getText(TOTAL_CART_SHIPPING_PRICE).replace("$", ""));
    }
}
