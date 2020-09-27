package automationpractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class WishlistPage extends BasePage {
    @FindBy(className = "table")
    private WebElement WISHLIST_TABLE;
    @FindBy(css = "li.clearfix>a")
    private List<WebElement> LIST_OF_SOME_PRODUCTS;
    @FindBy(css = "tr>td:first-child>a")
    private WebElement MY_WISHLIST_LINK;
    @FindBy(css = "ul.wlp_bought_list>li:first-child div.product_image>a")
    private WebElement MY_FIRST_ITEM_IN_MY_WISHLIST;
    @FindBy(css = ".product_image")
    private WebElement MY_FIRST_ITEM_IN_MY_WISHLIST_TEST;
    @FindBy(css = "tbody>tr")
    private List<WebElement> LIST_OF_WISHLISTS;
    @FindBy(css = "tbody>tr:first-child a.icon")
    private WebElement FIRST_DELETE_ICON;
    @FindBy(id = "name")
    private WebElement NEW_WISHLIST_NAME_INPUT;
    @FindBy(id = "submitWishlist")
    private WebElement SAVE_WISHLIST_BUTTON;

    public WishlistPage() {

    }

    //Return True if there are no wishlists created yet, return False if there are some wishlists
    public boolean getWishlistState() {
        try {
            WISHLIST_TABLE.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ProductDetailsPage openRandomProductDetails() {
        int randomProduct = new Random().nextInt(LIST_OF_SOME_PRODUCTS.size());
        clickOn(LIST_OF_SOME_PRODUCTS.get(randomProduct));
        return new ProductDetailsPage();
    }

    public WishlistPage openMyWishList() {
        clickOn(MY_WISHLIST_LINK);
        return new WishlistPage();
    }

    public ProductDetailsPage openMyItemFromWishList() {
        moveMouse(MY_FIRST_ITEM_IN_MY_WISHLIST_TEST);
        clickOn(MY_FIRST_ITEM_IN_MY_WISHLIST_TEST);
        return new ProductDetailsPage();
    }

    public void deleteWishlist() {
        clickOn(FIRST_DELETE_ICON);
    }

    public void createWishlist(String name) {
        typeIn(NEW_WISHLIST_NAME_INPUT, name);
        clickOn(SAVE_WISHLIST_BUTTON);
    }
}
