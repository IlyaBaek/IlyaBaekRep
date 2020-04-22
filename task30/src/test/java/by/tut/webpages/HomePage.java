package by.tut.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By HomePageUserName = By.className("uname");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHomePageUserName(){
        return driver.findElement(HomePageUserName).getText();
    }
}
