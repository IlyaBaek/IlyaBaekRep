package automationpractice.com.pages;

import automationpractice.com.Models.UserAccontModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public LoggedHomePage register(UserAccontModel newUser) {
        typeIn(FIRST_NAME_INPUT, newUser.getFirstName());
        typeIn(LAST_NAME_INPUT, newUser.getLastName());
        //typeIn(EMAIL_INPUT, newUser.getEmail());
        typeIn(PASSWORD_INPUT, newUser.getPassword());
        selectFromDropdown(DAY_OF_BIRTH_SELECT, newUser.getDayOfBirth());
        selectFromDropdown(MONTH_OF_BIRTH_SELECT, newUser.getMonthOfBirth());
        selectFromDropdown(YEAR_OF_BIRTH_SELECT, newUser.getYearOfBirth());
        typeIn(ADDRESS_FIRST_NAME_INPUT, newUser.getAddressFirstName());
        typeIn(ADDRESS_LAST_NAME_INPUT, newUser.getAddressLastName());
        typeIn(ADDRESS_INPUT, newUser.getAddress());
        typeIn(CITY_INPUT, newUser.getCity());
        selectFromDropdown(STATE_SELECT, newUser.getState());
        typeIn(POSTCODE_INPUT, newUser.getZipPostcode());
        //selectFromDropdown(COUNTRY_SELECT,country);
        typeIn(MOBILE_PHONE_INPUT, newUser.getMobilePhone());
        typeIn(ADDRESS_ALIAS_INPUT, newUser.getAddressAlias());
        clickOn(REGISTER_BUTTON);
        return new LoggedHomePage();
    }
}
   /* public UserAccontModel fillUserInfo(String firstName,
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
                                        String addressAlias) {
        UserAccontModel newUser = new UserAccontModel();

        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        //newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setDayOfBirth(dayOfBirth);
        newUser.setMonthOfBirth(monthOfBirth);
        newUser.setYearOfBirth(yearOfBirth);
        newUser.setAddressFirstName(addressFirstName);
        newUser.setAddressLastName(addressLastName);
        newUser.setAddress(address);
        newUser.setCity(city);
        newUser.setState(state);
        newUser.setZipPostcode(zipPostcode);
        newUser.setMobilePhone(mobilePhone);
        newUser.setAddressAlias(addressAlias);

        return newUser;}

*/