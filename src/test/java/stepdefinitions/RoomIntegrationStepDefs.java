package stepdefinitions;

import com.airbnb.controller.RoomController;
import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoomIntegrationStepDefs {
    @Autowired
    RoomController roomController;
    Room room;
    @Given("I have a Spring Endpoint")
    public void iHaveASpringEndpoint() {
        assertNotNull(roomController);
    }

    @When("I call the endpoint by name for rooms")
    public void iCallTheEndpointByNameForRooms() {
        room= roomController.findByName("Cliffhanger");
    }

    @Then("Cliffhanger should return from the server")
    public void cliffhangerShouldReturnFromTheServer() {
        assertEquals("Cliffhanger",room.getName());
    }
}
