import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

public class RequestDeck {

    private static final String URL1 = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
    
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello World!"); // Display the string.

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(URL1))
                .build();
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 200){
            System.out.println("Deck Response OK: "+response.statusCode());

        }
        else {
            throw new RuntimeException("Bad response");
        }

            String jResponse = response.body();
            System.out.println(jResponse);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jResponse);

            System.out.println(jsonNode.toPrettyString());
            Deck myDeck = new Deck();

            myDeck.setSuccess(jsonNode.get("success").asBoolean());
            myDeck.setDeck_id(jsonNode.get("deck_id").asText());
            myDeck.setRemaining(jsonNode.get("remaining").asInt());
            myDeck.setShuffled(jsonNode.get("shuffled").asBoolean());

            System.out.println(myDeck);

            RequestCard c = new RequestCard(myDeck);
            System.out.println("***************************************");
            System.out.printf("Congratulations Deck  %s , you got the following card: \n",myDeck.getDeck_id());
            System.out.println(c.getjCard().toPrettyString());



    }





}
