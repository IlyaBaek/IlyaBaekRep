package by.tut.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

@Test(groups = "task40")                                                                                                               //POINT 5
public class MultiselectTest {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    private By dropDownList = By.name("States");
    private Select statesDropdown;
    private Random random = new Random();
    private HashSet<Integer> randomOptions = new HashSet<>();

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //POINT 2
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.quit();
    }

    @Test
    public void multiselectTest() {
        statesDropdown = new Select( driver.findElement(dropDownList));
        do {
            randomOptions.add(random.nextInt(statesDropdown.getOptions().size()));
        } while (randomOptions.size()<3);

        randomOptions.forEach(option ->
                statesDropdown.selectByIndex(option)
        );

        assertEquals(statesDropdown.getOptions().size(),3, "3 Items should be selected");
    }
}
