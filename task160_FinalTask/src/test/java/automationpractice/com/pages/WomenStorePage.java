package automationpractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class WomenStorePage extends BasePage {
    @FindBy(css = "div.product-container")
    private List<WebElement> ALL_PRODUCTS;
    @FindBy(css = ".ajax_add_to_cart_button")
    private List<WebElement> ADD_TO_CART_BUTTONS;
    @FindBy(css = ".right-block span.price")
    private List<WebElement> PRODUCT_PRICE;
    @FindBy(css = "span.continue")
    private WebElement CONTINUE_SHOPPING_BUTTON;

    public WomenStorePage() {
        int randomProduct = new Random().nextInt(ADD_TO_CART_BUTTONS.size());
        ADD_TO_CART_BUTTONS.get(randomProduct).isDisplayed();
    }

    public void pressAddtoCartButton(int index) {
        moveMouse(ALL_PRODUCTS.get(index));
        clickOn(ADD_TO_CART_BUTTONS.get(index));
    }

    public int getCountOfProducts() {
        return ADD_TO_CART_BUTTONS.size();
    }

    public double getProductPrice(int index) {
        return Double.parseDouble(getText(PRODUCT_PRICE.get(index)).replace("$", ""));
    }

    public void pressContinueShoppingButton() {
        clickOn(CONTINUE_SHOPPING_BUTTON);
    }
}
