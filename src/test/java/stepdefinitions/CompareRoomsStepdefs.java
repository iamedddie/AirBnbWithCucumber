package stepdefinitions;

import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareRoomsStepdefs {
    RestClient restClient;
    String uriBase;
    Room cheapRoom,expRoom;
    @Given("I have a Rest Spring Endpoint {string}")
    public void iHaveARestSpringEndpointEndpoint(String uriBase) {
        this.uriBase=uriBase;
        restClient=RestClient.create();
    }
    @When("I call the {string} for the cheapest room")
    public void iCallTheCheapEndpointForTheCheapestRoom(String roomEndpoint) {
        cheapRoom=restClient.get().uri(uriBase+roomEndpoint).retrieve().body(Room.class);
    }

    @Then("{string} is the cheapest from the server")
    public void cheaproomIsTheCheapestFromTheServer(String room) {
        assertEquals(room,cheapRoom.getName());
    }
    @When("I call the {string} for the most expensive room")
    public void iCallTheExpEndpointForTheMostExpensiveRoom(String roomEndpoint) {
        expRoom=restClient.get().uri(uriBase+roomEndpoint).retrieve().body(Room.class);
    }
    @Then("{string} is the most expensive from the server")
    public void exproomIsTheMostExpensiveFromTheServer(String room) {
        assertEquals(room,expRoom.getName());
    }



}
