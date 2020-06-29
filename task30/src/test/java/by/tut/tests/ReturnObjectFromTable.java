package by.tut.tests;

import by.tut.webpages.EmployeeTableModel;
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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Test(groups = "task40")                                                                                        //Point9
public class ReturnObjectFromTable {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/table-sort-search-demo.html";
    private By nextButton = By.id("example_next");
    private By lastPageElement = By.cssSelector("div#example_paginate>span>:last-child");
    private By firstPageElement = By.cssSelector("div#example_paginate>span>:first-child");
    private By rowElement = By.cssSelector("tbody>tr");
    private By nameElement = By.cssSelector("td:nth-child(1)");
    private By positionElement = By.cssSelector("td:nth-child(2)");
    private By officeElement = By.cssSelector("td:nth-child(3)");
    private By ageElement = By.cssSelector("td:nth-child(4)");
    private By salaryElement = By.cssSelector("td:nth-child(6)");
    private List<EmployeeTableModel> tableModelArrayList = new ArrayList<>();

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
        int age = 40;
        int salary = 100000;
        getDataFromTabelTest(age, salary);
    }

    public List<EmployeeTableModel> getDataFromTabelTest(int age, int salary) {
        int lastPage = Integer.parseInt(driver.findElement(lastPageElement).getText());
        int firstPage = Integer.parseInt(driver.findElement(firstPageElement).getText());

        Predicate<WebElement> isAgeOK = row -> Integer.parseInt(row.findElement(ageElement).getText()) > age ;
        Predicate<WebElement> isSalaryOK = row -> Integer.parseInt(row.findElement(salaryElement).getAttribute("data-order")) > salary;

        IntStream.rangeClosed(firstPage, lastPage).forEach(page-> {
            List < WebElement > rowList = driver.findElements(rowElement);
                   rowList.stream()
                   .filter(row -> isAgeOK.test(row) && isSalaryOK.test(row))
                   .map(this::setValuesForEmployeeTabelModel)
                   .collect(Collectors.toList());
            driver.findElement(nextButton).click();
        });
        //it just shows what we've done
        for (EmployeeTableModel EmployeeTableModel : tableModelArrayList) {
            System.out.println(EmployeeTableModel.getName() + " / " + EmployeeTableModel.getPosition() + " / " + EmployeeTableModel.getOffice() );
        }
        return tableModelArrayList;
    }

    private List <WebElement> setValuesForEmployeeTabelModel(WebElement rowToSet)
    {
        EmployeeTableModel employee = new EmployeeTableModel();

        employee.setName(rowToSet.findElement(nameElement).getText());
        employee.setPosition(rowToSet.findElement(positionElement).getText());
        employee.setOffice(rowToSet.findElement(officeElement).getText());

        tableModelArrayList.add(employee);

        return null;
    }
}


 /*
            IntStream.rangeClosed(firstPage, lastPage).forEach(page-> {
            List < WebElement > rowList = driver.findElements(rowElement);

            rowList.forEach((element) -> {

                int employeeAge = Integer.parseInt(element.findElement(ageElement).getText());
                int employeeSalary = Integer.parseInt(element.findElement(salaryElement).getAttribute("data-order"));

                if (employeeAge > age && employeeSalary <= salary) {
                    EmployeeTableModel employee = new EmployeeTableModel();

                    employee.setName(element.findElement(nameElement).getText());
                    employee.setPosition(element.findElement(positionElement).getText());
                    employee.setOffice(element.findElement(officeElement).getText());
                    tableModelArrayList.add(employee);
                }
            });
            driver.findElement(nextButton).click();
        });
 */







