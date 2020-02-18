package mt.com.vodafone.stepdefinitions.web;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mt.com.vodafone.pageobjects.interfaces.LoginPage;
import mt.com.vodafone.pageobjects.web.Login;
import mt.com.vodafone.testframework.context.RunningContext;
import mt.com.vodafone.testframework.driver.Driver;
import mt.com.vodafone.testframework.utils.Utilities;

import static org.junit.Assert.*;

/**
 * Created by piecar
 * Date: 19/02/2019
 */
public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps() {
        loginPage = new Login();
    }

    @Given("^I access the Vodafone website and I insert the username \"([^\"]*)\" and the password \"([^\"]*)\"$")
    public void iInsertTheUsernameAndThePassword(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @When("^I click on the Sign In button$")
    public void iClickOnTheSignInButton() {
        loginPage.signIn();
    }

    @Then("^I should be redirected to the landing page$")
    public void iShouldBeRedirectedToTheLandingPage() {

        String landingPageUrl = RunningContext.getInstance().getDefaultEnvironment().getLandingPageUrl();
        String currentUrl = Driver.getWebDriver().getCurrentUrl();
        assertEquals("Landing loginPage URL mismatch!", landingPageUrl, currentUrl);
    }

    @And("^I should be able to verify the username \"([^\"]*)\" and number \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyTheUsernameAndNumber(String username, String number)  {

        // Verify username.
        String usernameFromPage = loginPage.getUsername();
        assertNotNull(usernameFromPage);
        assertTrue(!usernameFromPage.isEmpty());
        assertEquals("Username mismatch!", username, usernameFromPage);

        // Verify number.
        String numberFromPage = loginPage.getNumber();
        assertNotNull(numberFromPage);
        assertTrue(!numberFromPage.isEmpty());
        assertTrue(Utilities.isNumeric(numberFromPage));
        assertEquals("Username mismatch!", number, numberFromPage);
    }

    @Then("^I log out from the website$")
    public void iLogOutFromTheWebsite() {
        loginPage.signOut();
    }

}
