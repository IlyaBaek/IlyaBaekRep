package WebDriverSingleton;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static WebDriverSingleton object = null;
    private WebDriver driver;
    /*private static final String USERNAME = "piugoboss";
    private static final String ACCESS_KEY = "dcb5e1c7-5d61-4c4f-9fdf-cc3842f88d51";
    private static final String SAUCE_URL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";
    private static final String URL ="https://" + USERNAME + ":" + ACCESS_KEY + SAUCE_URL;*/

    private WebDriverSingleton() {
        //local
        //driver = new FirefoxDriver();

        //SeleniumGrid
        /*try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/

        //Cloud

        String sauceUserName = "piugoboss";
        String sauceAccessKey = "dcb5e1c7-5d61-4c4f-9fdf-cc3842f88d51";
        String sauceURL = "https://ondemand.saucelabs.com/wd/hub";

        MutableCapabilities sauceOptions = new MutableCapabilities();

        /*EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
        browserOptions.setCapability("sauce:options", sauceOptions);*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");
        capabilities.setCapability("name", "2-user-site");
        //point1
/*        capabilities.setCapability("browserName", "MicrosoftEdge");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "latest");*/
        //point2
/*        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("platform", "Windows 8.1");
        capabilities.setCapability("version", "39.0");*/
        //point3
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platform", "Linux");
        capabilities.setCapability("version", "40.0");


        try {
            driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

