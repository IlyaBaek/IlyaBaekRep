package WebDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriverSingleton object = null;
    private WebDriver driver;

    private WebDriverSingleton() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriverSingleton getInstance() {
        if (object == null) {
            object = new WebDriverSingleton();
        }
        return object;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void driverQuit() {
        getDriver().quit();
        object = null;
    }
}

