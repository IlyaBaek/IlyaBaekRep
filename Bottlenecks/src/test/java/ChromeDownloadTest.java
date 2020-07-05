import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChromeDownloadTest {
    private WebDriver driver;
    private static final String URL_PDF = "https://dropmefiles.com/tsUr8";
    private static final String URL_ZIP = "https://dropmefiles.com/6HCGF";

    By DOWNLOAD_BUTTON = By.cssSelector("a.download_btn");

    @BeforeMethod
    public void setUp(){
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "d:\\");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
    }

    @AfterMethod
    public void closeWebDriver(){
        driver.close();
    }

    @Test
    public void downloadZipTest() throws InterruptedException {
        driver.get(URL_ZIP);
        driver.findElement(DOWNLOAD_BUTTON).click();
        Thread.sleep(2000);
    }

    @Test
    public void downloadPDFTest() throws InterruptedException {
        driver.get(URL_PDF);
        driver.findElement(DOWNLOAD_BUTTON).click();
        Thread.sleep(2000);
    }

    @Test
    public void downloadFileRevisitedTest() throws IOException {
        driver.get("http://the-internet.herokuapp.com/download");

        String link = driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).getAttribute("href");

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpHead request = new HttpHead(link);

        HttpResponse response = httpClient.execute(request);

        String contentType = response.getFirstHeader("Content-Type").getValue();

        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

        assertEquals(contentType,"image/jpeg");
        assertTrue(contentLength != 0);
        //assertEquals(contentType,"application/octet-stream");
        //assertEquals(contentLength, is(not(0)));
    }
}
