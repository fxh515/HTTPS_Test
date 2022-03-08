public class Deck {
    // Properties:
    private Boolean success;
    private String deck_id;
    private Boolean shuffled;
    private int remaining;

    /* Sample JSON Response:
        {
        "success": true,
        "deck_id": "3p40paa87x90",
        "shuffled": true,
        "remaining": 52
        }
    */


    // Constructor:
    public Deck(Boolean success, String deck_id, Boolean shuffled, int remaining) {
        this.success = success;
        this.deck_id = deck_id;
        this.shuffled = shuffled;
        this.remaining = remaining;
    }
    public Deck(){};

    // Getters & Setters:
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public void setShuffled(Boolean shuffled) {
        this.shuffled = shuffled;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "Deck Loaded = {" +
                "success=" + success +
                ", deck_id='" + deck_id + '\'' +
                ", shuffled=" + shuffled +
                ", remaining=" + remaining +
                '}';
    }
}
