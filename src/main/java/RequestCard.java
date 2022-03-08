import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class RequestCard {

    private JsonNode jCard;

    RequestCard(Deck myDeck) throws IOException, InterruptedException {

        System.out.println(myDeck.getDeck_id());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("https://deckofcardsapi.com/api/deck/new/draw/?count=1"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Card Response OK: " + response.statusCode());
        } else {
            throw new RuntimeException("Bad response!");
        }
        ObjectMapper mapper = new ObjectMapper();
        jCard = mapper.readTree(response.body());
    }

    public JsonNode getjCard() {
        return jCard;
    }
}
