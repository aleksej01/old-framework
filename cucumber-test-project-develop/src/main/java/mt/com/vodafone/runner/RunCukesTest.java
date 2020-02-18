package mt.com.vodafone.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by piecar
 * Date: 03/02/2019
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/cucumber/features/",
        glue = "mt.com.vodafone",
        plugin = {"pretty", "junit:reports/junit.xml", "json:reports/cucumber.json", "html:reports/html-reports"},
        monochrome = true)

public class RunCukesTest {

    public static void main(String[] args) throws Throwable {
        String[] argv = new String[]{"-g", "mt.com.vodafone", "src/main/resources/cucumber/features/web/login.feature"};
        cucumber.api.cli.Main.main(argv);
    }
}
