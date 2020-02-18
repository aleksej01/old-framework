package mt.com.vodafone.stepdefinitions.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import mt.com.vodafone.api.request.GetUserRequest;
import mt.com.vodafone.api.response.GetUserResponse;
import mt.com.vodafone.testframework.utils.Utilities;

import static org.junit.Assert.*;

/**
 * Created by piecar
 * Date: 24/02/2019
 */
public class UserSteps {

    private GetUserResponse userResponse;

    @Given("^I request to make a call to fetch a User object by id (\\d+)$")
    public void iRequestToMakeACallToFetchAUserObjectByIdId(int id) throws Exception {

        GetUserRequest request = new GetUserRequest(id);
        userResponse = (GetUserResponse) request.execute();

        assertNotNull(userResponse);
        assertEquals(id, userResponse.getId());
    }

    @Then("^The response should contain the respective User object$")
    public void theResponseShouldContainTheRespectiveUserObject() {

        assertNotNull(userResponse);

        // Assert correct JSON structure
        assertTrue(Utilities.isJsonValid(userResponse.getRawJson()));
    }

}
