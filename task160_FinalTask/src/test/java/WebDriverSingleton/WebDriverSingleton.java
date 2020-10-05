package WebDriverSingleton;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static ThreadLocal<WebDriverSingleton> object = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Properties p = new Properties();
    private FileReader reader;

    /*private static final String USERNAME = "piugoboss";
    private static final String ACCESS_KEY = "dcb5e1c7-5d61-4c4f-9fdf-cc3842f88d51";
    private static final String SAUCE_URL = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";
    private static final String URL ="https://" + USERNAME + ":" + ACCESS_KEY + SAUCE_URL;*/

    private WebDriverSingleton() {
        //local
        loadProperties();
        switch (p.getProperty("browser")) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static WebDriverSingleton getInstance() {
        if (object.get() == null) {
            object.set(new WebDriverSingleton());
        }
        return object.get();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void driverQuit() {
        getDriver().quit();
        object.remove();
    }

    public WebDriverWait getWebDriverWait() {
        int TIMEOUT = 5;
        int POLLING = 100;
        return new WebDriverWait(getDriver(), TIMEOUT, POLLING);
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) WebDriverSingleton.getInstance().getDriver();
    }

    public Actions getActions() {
        return new Actions(WebDriverSingleton.getInstance().getDriver());
    }

    public void loadProperties() {
        {
            try {
                reader = new FileReader("src/test/resources/Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        {
            try {
                p.load(reader);
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//driver = new ChromeDriver();

//SeleniumGrid
        /*try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/

//Cloud
/*
        String sauceUserName = "piugoboss";
        String sauceAccessKey = "dcb5e1c7-5d61-4c4f-9fdf-cc3842f88d51";
        String sauceURL = "https://ondemand.saucelabs.com/wd/hub";

        MutableCapabilities sauceOptions = new MutableCapabilities();
*/
        /*EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
        browserOptions.setCapability("sauce:options", sauceOptions);*/
/*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", sauceUserName);
        capabilities.setCapability("accessKey", sauceAccessKey);
        capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");
        capabilities.setCapability("name", "2-user-site");
        //point1
   */
/*        capabilities.setCapability("browserName", "MicrosoftEdge");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "latest");*/
//point2
/*        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("platform", "Windows 8.1");
        capabilities.setCapability("version", "39.0");*/
//point3
     /*   capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("platform", "Linux");
        capabilities.setCapability("version", "40.0");


        try {
            driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
//-----------------------
