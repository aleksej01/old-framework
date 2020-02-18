package mt.com.vodafone.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import mt.com.vodafone.testframework.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Created by user: piecar
 * Date: 11/01/2019
 */
public class DriverScreenShotHelper {

    public static void takeScreenShot(Scenario scenario) {

        // Take screen shot
        File sourceImageFile = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.FILE);

        if (sourceImageFile == null) {
            throw new RuntimeException("Source Image File cannot be null - screen shot not taken!");
        }

        String htmlReportsPath = "reports/html-reports/";
        String imageName = System.currentTimeMillis() + ".jpeg";
        String screenShotPath = htmlReportsPath + imageName;
        try {
            // Copy original image file created by Selenium WebDriver to the file specified
            FileUtils.copyFile(sourceImageFile, new File(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cucumberFailureScreenShotPath;

        // This handles screen shot paths when test is run on Jenkins
        String buildURL = System.getenv("BUILD_URL");

        if (buildURL != null) {
            // Replaces the build number with ws/ in http://40.127.132.250:8080/job/TestJob/8/
            buildURL = buildURL.replaceAll("\\d+/$", "ws/");
            String absoluteImagePath = buildURL + screenShotPath;
            cucumberFailureScreenShotPath = absoluteImagePath.replace(" ", "%20");
        } else {
            // This is the path for tests executed on local machine
            cucumberFailureScreenShotPath = imageName;
        }

        scenario.write("<a href=\"" + cucumberFailureScreenShotPath + "\" target=\"_blank\">Click to reveal screenshot at time of failure</a>");
    }

    public static void takeAndroidScreenShot(Scenario scenario) {

        // Take screen shot
        File sourceImageFile = (Driver.getAndroidDriver()).getScreenshotAs(OutputType.FILE);

        if (sourceImageFile == null) {
            throw new RuntimeException("Source Image File cannot be null - screen shot not taken!");
        }

        String htmlReportsPath = "reports/html-reports/";
        String imageName = System.currentTimeMillis() + ".jpeg";
        String screenShotPath = htmlReportsPath + imageName;

        try {
            // Copy original image file created by Selenium WebDriver to the file specified
            FileUtils.copyFile(sourceImageFile, new File(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cucumberFailureScreenShotPath;

        // This handles screen shot paths when test is run on Jenkins
        String buildURL = System.getenv("BUILD_URL");

        if (buildURL != null) {
            // Replaces the build number with ws/ in http://40.127.132.250:8080/job/TestJob/8/
            buildURL = buildURL.replaceAll("\\d+/$", "ws/");
            String absoluteImagePath = buildURL + screenShotPath;
            cucumberFailureScreenShotPath = absoluteImagePath.replace(" ", "%20");
        } else {
            // This is the path for tests executed on local machine
            cucumberFailureScreenShotPath = imageName;
        }

        scenario.write("<a href=\"" + cucumberFailureScreenShotPath + "\" target=\"_blank\">Click to reveal screenshot at time of failure</a>");
    }

    public static void makeReport() {

        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("reports/html-reports/screenshots/report.html");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        String imageName = System.currentTimeMillis() + ".jpeg";

    }

}