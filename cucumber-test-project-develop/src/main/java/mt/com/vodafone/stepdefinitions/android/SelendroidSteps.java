package mt.com.vodafone.stepdefinitions.android;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import mt.com.vodafone.pageobjects.android.Selendroid;
import mt.com.vodafone.pageobjects.interfaces.SelendroidPage;

import static org.junit.Assert.assertTrue;

/**
 * Created by piecar
 * Date: 02/02/2019
 */
public class SelendroidSteps {

    private SelendroidPage selendroidPage;

    public SelendroidSteps() {
        selendroidPage = new Selendroid();
    }

    @Given("^I click on the Display Popup Window button$")
    public void iClickOnTheDisplayPopupWindowButton() {
        selendroidPage.clickTextButton();
    }

    @Then("^The text \"([^\"]*)\" should be displayed$")
    public void theTextShouldBeDisplayed(String text) {
        String popupWindowTextMessage = selendroidPage.getText();
        assertTrue("Text message mismatch!", text.equalsIgnoreCase(popupWindowTextMessage));
    }

}
