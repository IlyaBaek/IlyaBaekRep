import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FireFoxDownloadTest {
    private WebDriver driver;
    private static final String URL_PDF = "https://dropmefiles.com/tsUr8";
    private static final String URL_ZIP = "https://dropmefiles.com/6HCGF";

    By DOWNLOAD_BUTTON = By.cssSelector("a.download_btn");

    @BeforeMethod
    public void setUp(){
        FirefoxProfile foxProfile = new FirefoxProfile();
        FirefoxOptions option = new FirefoxOptions();

        //download folder
        foxProfile.setPreference("browser.download.folderList", 2);
        foxProfile.setPreference("browser.download.dir", "d:\\");
        //autodownload
        foxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        foxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        foxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/zip, application/x-zip, application/x-zip-compressed, text/csv, application/pdf,application/x-pdf, application/octet-stream");
        foxProfile.setPreference("pdfjs.disabled", true);
        foxProfile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");

        option.setProfile(foxProfile);
        driver = new FirefoxDriver(option);

         //driver = new FirefoxDriver();
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
    public void downloadFileRevisitedTest() throws IOException, InterruptedException {
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
        Thread.sleep(1000);
    }
}
