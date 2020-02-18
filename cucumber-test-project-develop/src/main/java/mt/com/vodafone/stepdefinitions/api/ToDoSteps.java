package mt.com.vodafone.stepdefinitions.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import mt.com.vodafone.api.request.GetToDoRequest;
import mt.com.vodafone.api.response.GetToDoResponse;
import mt.com.vodafone.testframework.utils.Utilities;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by piecar
 * Date: 24/02/2019
 */
public class ToDoSteps {

    private GetToDoResponse toDoResponse;

    @Given("^I request to make a call to fetch a ToDo object by id (\\d+)$")
    public void iRequestToMakeACallToFetchAToDoObjectById(int id) throws Throwable {
        GetToDoRequest request = new GetToDoRequest(id);
        toDoResponse = (GetToDoResponse) request.execute();

        assertNotNull(toDoResponse);
        assertEquals(id, toDoResponse.getId());
    }

    @Then("^The response should contain the respective ToDo object$")
    public void iResponseShouldContainTheRespectiveToDoObject() throws Throwable {

        assertNotNull(toDoResponse);

        // Assert correct JSON structure
        assertTrue(Utilities.isJsonValid(toDoResponse.getRawJson()));

        //Assert that a node called "title" exists
        final String TITLE_NODE = "title";

        Field titleNode = GetToDoResponse.class.getDeclaredField(TITLE_NODE);
        assertNotNull(titleNode);

        // Assert that title node text is: "delectus aut autem"
        final String TITLE_NODE_TEXT = "delectus aut autem";
        assertEquals(TITLE_NODE_TEXT, toDoResponse.getTitle());

        // Store the "completed" JSON node in a variable and convert it to boolean
        final boolean isCompleted = toDoResponse.isCompleted();
        assertFalse(isCompleted);
    }

}
