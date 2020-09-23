package tut.by.tests;

import WebDriverSingleton.WebDriverSingleton;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OneMoreTest {
    private static final String url = "https://www.tut.by/";

    @Feature("URL2")
    @Description("URL2 description")
    @TmsLink("TC-4")
    @Test(groups = "OneMoreTest", enabled = false)
    private void goToUrl() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(url);
        assertEquals(driver.getCurrentUrl(), url);
        WebDriverSingleton.getInstance().driverQuit();
    }

    @Feature("URL2")
    @Description("URL2 description")
    @TmsLink("TC-4")
    @Test(groups = "OneMoreTest")
    private void goToURL2(){
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(url);
        assertEquals(driver.getCurrentUrl(), url);
        WebDriverSingleton.getInstance().driverQuit();
    }


}
