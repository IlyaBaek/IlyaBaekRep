package SingletonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    public static WebDriver driver;
    //public static String browserName = "Chrome";

    public static void initialize(){
        if(driver==null){
            driver = new ChromeDriver();
            /*if(browserName.equalsIgnoreCase("Chrome")){
                driver = new ChromeDriver();
            }
            else  if(browserName.equalsIgnoreCase("FF")){
                driver = new FirefoxDriver();
            }*/
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver=null;
    }

    public static void closeDriver(){
        driver.close();
        driver=null;
    }

    public static void openurl(String URL)
    {
        driver.get(URL);
    }
}
