package stepdefinitions;

import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateRoomStepDefs {

    RestClient restClient;
    String uriBase;
    Room room,testRoom;
    @Given("I have this Rest Spring Endpoint {string}")
    public void iHaveThisRestSpringEndpointEndpoint(String uriBase) {
        this.uriBase=uriBase;
        restClient=RestClient.create();
    }

    @When("I call the {string} with  {string} and {double} a new room is created")
    public void iCallTheCreateEndpointWithRoomAndRateANewRoomIsCreated(String roomEndpoint,String name, double rate) {
        room=restClient.post().uri(uriBase+"/"+roomEndpoint+"/"+name+"/"+rate).retrieve().body(Room.class);

    }

    @Then("I call the {string} to test the recently added room")
    public void iCallTheTestCreateEndpointToTestTheRecentlyAddedRoom(String roomEndpoint) {
        testRoom=restClient.get().uri(uriBase+roomEndpoint).retrieve().body(Room.class);
        assertEquals(room.getName(),testRoom.getName());
    }
}
