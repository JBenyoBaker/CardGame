import java.util.ArrayList;

public class Player
{
    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String addCard(Card c)
    {
        hand.add(c);
    }

}
