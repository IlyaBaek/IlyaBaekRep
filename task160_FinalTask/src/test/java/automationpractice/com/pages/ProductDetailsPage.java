package automationpractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(id = "wishlist_button")
    private WebElement ADD_TO_WISHLIST_BUTTON;
    @FindBy(name = "Submit")
    private WebElement ADD_TO_CART_BUTTON;
    @FindBy(css = "#product_reference span")
    private WebElement PRODUCT_ID;
    @FindBy(css = "a.fancybox-close")
    private WebElement ADDED_TO_WISHLIST_POPUP_CLOSE_BUTTON;

    public ProductDetailsPage() {
        ADD_TO_CART_BUTTON.isDisplayed();
    }

    public void pressAddToWishlistButton() {
        clickOn(ADD_TO_WISHLIST_BUTTON);
        clickOn(ADDED_TO_WISHLIST_POPUP_CLOSE_BUTTON);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getProductId() {
        return PRODUCT_ID.getText();
    }

}
