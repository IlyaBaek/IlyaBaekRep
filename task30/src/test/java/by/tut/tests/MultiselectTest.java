package by.tut.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

@Test(groups = "task40")                                                                                                               //POINT 5
public class MultiselectTest {
    private WebDriver driver;
    private static final String URL = "https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
    private By dropdownOption = By.cssSelector("select#multi-select option");
    private int selectedItems;

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
        //Preparation
        List<WebElement> itemsIndDropdown = driver.findElements(dropdownOption);
        Collections.shuffle(itemsIndDropdown);

        //selecting random items
        for (int i=0; i < 3; i++){
            itemsIndDropdown.get(i).click();
        }

        //Assert
        for (WebElement webElement : itemsIndDropdown) {
            String itemFromDropdownText;
            if (webElement.isSelected()) {
                itemFromDropdownText = webElement.getText();
                System.out.println(itemFromDropdownText + " is selected");
                selectedItems++;
            } else {
                itemFromDropdownText = webElement.getText();
                System.out.println(itemFromDropdownText + " is not selected");
            }
        }
        assertEquals(selectedItems,3, "3 Items should be selected");
    }
}
