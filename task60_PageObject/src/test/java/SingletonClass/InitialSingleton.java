package SingletonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class InitialSingleton {
    public static WebDriver driver = null;
    public static String browserName = "Chrome";

    public static void initialize(){
        if(driver==null){
            if(browserName.equalsIgnoreCase("Chrome")){
                driver = new ChromeDriver();
            }
            else  if(browserName.equalsIgnoreCase("FF")){
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver(){
        driver.close();
    }
}
