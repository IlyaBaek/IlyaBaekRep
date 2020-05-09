package by.tut.tests;

import by.tut.webpages.myTabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Test(groups = "task40")                                                                                        //Point9
public class ReturnObjectFromTable {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
    private By nextButton = By.id("example_next");
    private By numbersOfPages = By.cssSelector("div#example_paginate>span>:last-child");
    private By rowElement = By.cssSelector("tbody>tr");
    private By nameElement = By.cssSelector("td:nth-child(1)");
    private By positionElement = By.cssSelector("td:nth-child(2)");
    private By officeElement = By.cssSelector("td:nth-child(3)");
    private By ageElement = By.cssSelector("td:nth-child(4)");
    private By salaryElement = By.cssSelector("td:nth-child(6)");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //POINT 2
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void closeWebDriver() {
        driver.quit();
    }

    @Test
    public void callGetDataFromTabelTestMethod() {
        getDataFromTabelTest(20, 103600);
    }

    public List<myTabel> getDataFromTabelTest(int x, int y) {
        int paging = Integer.parseInt(driver.findElement(numbersOfPages).getText());
        List<myTabel> tabelList = new ArrayList<>();
        for (int i = 0; i < paging; i++) {
            List<WebElement> rowList = driver.findElements(rowElement);
            rowList.forEach(
                    (element) ->
                               {if (Integer.parseInt(element.findElement(ageElement).getText()) > x &&
                                               Integer.parseInt(element.findElement(salaryElement).getAttribute("data-order")) <= y)
                            tabelList.add(new myTabel(element.findElement(nameElement).getText(),
                                    element.findElement(positionElement).getText(),
                                    element.findElement(officeElement).getText()));
                      }
            );
            driver.findElement(nextButton).click();
        }
        //it just shows what we've done
        for (by.tut.webpages.myTabel myTabel : tabelList) {
            System.out.println(myTabel.name + " / " + myTabel.position + " / " + myTabel.office );
        }

        return tabelList;
    }

}







