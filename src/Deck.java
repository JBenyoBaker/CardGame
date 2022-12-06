import java.util.ArrayList;

public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();
    int numCardsLeft;

    public Deck(ArrayList<Card> deck)
    {
        this.deck = deck;
        numCardsLeft = deck.size();
    }

    public boolean isEmpty()
    {
        return numCardsLeft == 0;
    }

    public int getNumCardsLeft()
    {
        return numCardsLeft;
    }

    public Card deal()
    {
        return deck.remove(0);
    }

    public void shuffle()
    {
        int size = deck.size();
        for (int i = size - 1; i >= 0; i--)
        {
            Card cardToAdd = deck.get((int)(Math.random() * size));
            deck.add(cardToAdd);
        }
    }
}
