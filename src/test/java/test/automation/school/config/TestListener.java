package test.automation.school.config;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.tika.utils.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import test.automation.school.test.common.SeleniumTest;

import java.io.File;
import java.io.IOException;

/**
 * Test listener responsible for handling logging and errors
 */
public class TestListener extends TestListenerAdapter {
    @Override
    public void onConfigurationFailure(ITestResult iTestResult){
        super.onConfigurationFailure(iTestResult);
        addScreenshotToLog(iTestResult);
        Reporter.log(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        addScreenshotToLog(iTestResult);
        Reporter.log("<pre>" + ExceptionUtils.getStackTrace(iTestResult.getThrowable()) + "</pre>");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        super.onTestFailedButWithinSuccessPercentage(iTestResult);
        addScreenshotToLog(iTestResult);
        Reporter.log(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));
    }

    private void addScreenshotToLog(ITestResult iTestResult) {
        WebDriver driver = ((SeleniumTest)iTestResult.getInstance()).getDriver();
        File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = getLogPath(iTestResult, ".jpg");
        try {
            FileUtils.copyFile(scrnsht, new File(location));
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] scrByte = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment(location, "image/jpg", ".jpg", scrByte);

        Reporter.log("<a href=\"" + location + "\">" +
                "<img src=\"" + location.replace("//", File.separator) +
                "\" width=\"192\" height=\"108\" /></a>");
    }

    private String getLogPath(ITestResult iTestResult, String fileExtension) {
        return new StringBuilder()
                .append(System.getProperty("user.dir")).append(File.separator)
                .append("target").append(File.separator)
                .append("surefire-reports").append(File.separator)
                .append("log").append(File.separator)
                .append(getClassMethodDescriptor(iTestResult))
                .append(fileExtension).toString();
    }

    private String getClassMethodDescriptor(ITestResult iTestResult) {
        return new StringBuilder()
                .append(iTestResult.getInstanceName()).append("_")
                .append(iTestResult.getName()).append("_")
                .append(String.valueOf(iTestResult.getParameters().hashCode()))
                .toString();
    }
}