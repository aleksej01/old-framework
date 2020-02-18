package mt.com.vodafone.helper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import mt.com.vodafone.testframework.driver.Driver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by user: piecar
 * Date: 11/01/2019
 */
public class CucumberBeforeAfter {

    private static boolean areImagesCleaned = false;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private void clearImages() {
        // Delete all screen shots from previous execution
        // THIS SHOULD BE EXECUTED ONLY ONCE
        if (!areImagesCleaned) {
            File reportsDirectory = new File("reports/html-reports");
            final File[] files = reportsDirectory.listFiles((dir, name) -> {
                return name.matches(".*.jpeg");
            });
            for (final File file : files) {
                file.delete();
            }
            areImagesCleaned = true;
        }
    }

    // This ensures that this @Before is always executed first
    @Before(order = 0, value = "@web")
    public void setup() {

        clearImages();

        Driver.setBrowser(System.getProperty("browser"));
        Driver.startWebDriver();
    }

    // This ensures that this @After is always executed last
    @After(order = 1, value = "@web")
    public void webTearDown(Scenario scenario) {
        // If Cucumber scenario fails, output time of failure and take screen shot
        if (scenario.isFailed()) {
            scenario.write("Time of failure: " + dateFormat.format(Calendar.getInstance().getTime()));
            DriverScreenShotHelper.takeScreenShot(scenario);
        }

        if (Driver.getWebDriver() != null) {
            Driver.nullifyWebDriver();
        }
    }

    // This ensures that this @Before is always executed first
    @Before(order = 0, value = "@android")
    public void androidSetup() {

        clearImages();
        Driver.startAndroidDriver();
    }

    // This ensures that this @After is always executed last
    @After(order = 1, value = "@android")
    public void androidTearDown(Scenario scenario) {
        // If Cucumber scenario fails, output time of failure and take screen shot
        if (scenario.isFailed()) {
            scenario.write("Time of failure: " + dateFormat.format(Calendar.getInstance().getTime()));
            DriverScreenShotHelper.takeAndroidScreenShot(scenario);
        }

        if (Driver.getAndroidDriver() != null) {
            Driver.nullifyAndroidDriver();
        }
    }

    // This ensures that this @Before is always executed first
    @Before(order = 0, value = "@ios")
    public void iOsSetup() {

        clearImages();
        Driver.startiOsDriver();
    }

    // This ensures that this @After is always executed last
    @After(order = 1, value = "@ios")
    public void iOsTearDown(Scenario scenario) {
        // If Cucumber scenario fails, output time of failure and take screen shot
        if (scenario.isFailed()) {
            scenario.write("Time of failure: " + dateFormat.format(Calendar.getInstance().getTime()));
            DriverScreenShotHelper.takeAndroidScreenShot(scenario);
        }

        if (Driver.getiOsDriver() != null) {
            Driver.nullifyIosDriver();
        }
    }

}
