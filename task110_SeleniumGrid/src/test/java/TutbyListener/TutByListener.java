package TutbyListener;

import WebDriverSingleton.WebDriverSingleton;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TutByListener implements ITestListener {

    @Attachment(value = "Screenshot")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Environment")
    private String getEnv() {
        Capabilities cap = ((RemoteWebDriver) WebDriverSingleton.getInstance().getDriver()).getCapabilities();

        return "Browser: " + cap.getBrowserName() + "\n" + "Version: " + cap.getVersion() + "\n" + "OS: " + cap.getPlatform();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        takeScreenshot();
        getEnv();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
