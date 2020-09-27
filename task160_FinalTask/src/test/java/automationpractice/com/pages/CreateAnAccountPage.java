package automationpractice.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends BasePage {
    @FindBy(id = "submitAccount")
    private WebElement REGISTER_BUTTON;
    //YOUR PERSONAL INFORMATION
    @FindBy(id = "customer_firstname")
    private WebElement FIRST_NAME_INPUT;
    @FindBy(id = "customer_lastname")
    private WebElement LAST_NAME_INPUT;
    @FindBy(id = "email")
    private WebElement EMAIL_INPUT;
    @FindBy(id = "passwd")
    private WebElement PASSWORD_INPUT;
    @FindBy(id = "days")
    private WebElement DAY_OF_BIRTH_SELECT;
    @FindBy(id = "months")
    private WebElement MONTH_OF_BIRTH_SELECT;
    @FindBy(id = "years")
    private WebElement YEAR_OF_BIRTH_SELECT;
    @FindBy(id = "newsletter")
    private WebElement NEWSLETTER_CHECKBOX;
    @FindBy(id = "optin")
    private WebElement SPECIALOFFER_CHECKBOX;
    //YOUR ADDRESS
    @FindBy(id = "firstname")
    private WebElement ADDRESS_FIRST_NAME_INPUT;
    @FindBy(id = "lastname")
    private WebElement ADDRESS_LAST_NAME_INPUT;
    @FindBy(id = "company")
    private WebElement COMPANY_INPUT;
    @FindBy(id = "address1")
    private WebElement ADDRESS_INPUT;
    @FindBy(id = "city")
    private WebElement CITY_INPUT;
    @FindBy(id = "id_state")
    private WebElement STATE_SELECT;
    @FindBy(id = "postcode")
    private WebElement POSTCODE_INPUT;
    @FindBy(id = "id_country")
    private WebElement COUNTRY_SELECT;
    @FindBy(id = "other")
    private WebElement ADDITIONAL_INFORMATION_INPUT;
    @FindBy(id = "phone")
    private WebElement HOME_PHONE_INPUT;
    @FindBy(id = "phone_mobile")
    private WebElement MOBILE_PHONE_INPUT;
    @FindBy(id = "alias")
    private WebElement ADDRESS_ALIAS_INPUT;

    public CreateAnAccountPage() {
        REGISTER_BUTTON.isDisplayed();
    }

    public LoggedHomePage register(String firstName,
                                   String lastName,
                                   String email,
                                   String password,
                                   Integer dayOfBirth,
                                   Integer monthOfBirth,
                                   Integer yearOfBirth,
                                   String addressFirstName,
                                   String addressLastName,
                                   String address,
                                   String city,
                                   Integer state,
                                   String zipPostcode,
                                   //Integer country,
                                   String mobilePhone,
                                   String addressAlias
    ) {
        typeIn(FIRST_NAME_INPUT, firstName);
        typeIn(LAST_NAME_INPUT, lastName);
        typeIn(EMAIL_INPUT, email);
        typeIn(PASSWORD_INPUT, password);
        selectFromDropdown(DAY_OF_BIRTH_SELECT, dayOfBirth);
        selectFromDropdown(MONTH_OF_BIRTH_SELECT, monthOfBirth);
        selectFromDropdown(YEAR_OF_BIRTH_SELECT, yearOfBirth);
        typeIn(ADDRESS_FIRST_NAME_INPUT, addressFirstName);
        typeIn(ADDRESS_LAST_NAME_INPUT, addressLastName);
        typeIn(ADDRESS_INPUT, address);
        typeIn(CITY_INPUT, city);
        selectFromDropdown(STATE_SELECT, state);
        typeIn(POSTCODE_INPUT, zipPostcode);
        //selectFromDropdown(COUNTRY_SELECT,country);
        typeIn(MOBILE_PHONE_INPUT, mobilePhone);
        typeIn(ADDRESS_ALIAS_INPUT, addressAlias);
        clickOn(REGISTER_BUTTON);
        return new LoggedHomePage();
    }
}
