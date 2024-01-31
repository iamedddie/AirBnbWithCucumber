package stepdefinitions;

import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import static org.junit.Assert.assertEquals;

public class RoomRestIntegrationStepDefs {
    RestClient restClient;
    String uriBase;
    Room room;
    @Given("I have a Rest Spring {string}")
    public void iHaveARestSpringEndpoint( String uriBase) {
        this.uriBase=uriBase;
        restClient=RestClient.create();
    }

    @When("I call the {string} by name for rooms")
    public void iCallTheRoomEndpointByNameForRooms(String roomEndpoint) {
        room=restClient.get().uri(uriBase+roomEndpoint).retrieve().body(Room.class);
    }

    @Then("{string} is the result from the server")
    public void cliffhangerIsTheResultFromTheServer(String roomName) {
        assertEquals(roomName,room.getName());
    }


}
