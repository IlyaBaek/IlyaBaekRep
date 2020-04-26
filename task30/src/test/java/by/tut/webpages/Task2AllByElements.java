package by.tut.webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task2AllByElements {
    //elements from tut.by
    WebDriver driver;
    By id = By.id("search");
    By name = By.name("search");
    By linkText = By.linkText("Па-беларуску");
    By partialLinkText = By.partialLinkText("редакцией");
    By classname = By.className("enter");
    By tagName = By.tagName("link");
    //CSS
    By cssSelectorTagAndId = By.cssSelector("input#search_from_str"); //
    By cssSelectorTagAndClass = By.cssSelector("a.header-logo"); //
    By cssSelectorTagAndAtribute = By.cssSelector("div[id=animated_mainmenu]");
    By cssSelectorTagAndClassAndAtribute = By.cssSelector("div.b-topbar[data-act=wide]");
    //cssSelector Matches
    By cssSelectorStartWith = By.cssSelector("input[id^='sear']");
    By cssSelectorEndtWith = By.cssSelector("input[id$='str']");
    By cssSelectorContatin = By.cssSelector("input[id*='from']");
    //XPATH
    By xpath = By.xpath("//div[@data-act='wide']");
    By xpathContains = By.xpath("//a[contains(@class,'topbar-burg')]");
    By xpathAnd = By.xpath("//div[@class='b-topbar' and @id='animated_mainmenu']");
    By xpathOr = By.xpath("//div[@class='b-topbar' or @id='animated_mainmenu']");
    By xpathStartWith = By.xpath("//input[starts-with(@id,'sear')]");
    By xpathText = By.xpath("//a[text()='Разделы']");

    public Task2AllByElements(WebDriver driver) {
        this.driver = driver;
    }

    public void locateElements(){
        driver.findElement(id);
        driver.findElement(name);
        driver.findElement(linkText);
        driver.findElement(partialLinkText);
        driver.findElement(classname);
        driver.findElements(tagName);

        driver.findElement(cssSelectorTagAndId);
        driver.findElement(cssSelectorTagAndClass);
        driver.findElement(cssSelectorTagAndAtribute);
        driver.findElement(cssSelectorTagAndClassAndAtribute);

        driver.findElement(cssSelectorStartWith);
        driver.findElement(cssSelectorEndtWith);
        driver.findElement(cssSelectorContatin);

        driver.findElement(xpath);
        driver.findElement(xpathContains);
        driver.findElement(xpathAnd);
        driver.findElement(xpathOr);
        driver.findElement(xpathStartWith);
        driver.findElement(xpathText);
    }
}
