package WebDriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriverSingleton object = null;
    private static WebDriver driver;

    private WebDriverSingleton() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriverSingleton getInstance() {
        if (object == null) {
            object = new WebDriverSingleton();
        }
        return object;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void driverQuit() {
        getDriver().quit();
        object = null;
    }
}

