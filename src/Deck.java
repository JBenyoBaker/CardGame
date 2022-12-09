/**
 * Joshua Benyo Baker
 * December 8 2022
 */
import java.util.ArrayList;

public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();
    int numCardsLeft;

    //constructor
    public Deck(ArrayList<Card> deck)
    {
        this.deck = deck;
        numCardsLeft = deck.size();
    }

    //returns true if the deck is empty false if not
    public boolean isEmpty()
    {
        return numCardsLeft == 0;
    }

    //returns the number of cards left
    public int getNumCardsLeft()
    {
        return numCardsLeft;
    }

    //returns a card and removes it from the deck
    public Card deal()
    {
        return deck.remove(0);
    }

    //shuffles the cards in the deck
    public void shuffle()
    {
        int size = deck.size();
        for (int i = size - 1; i >= 0; i--)
        {
            Card cardToAdd = deck.remove((int)(Math.random() * size));
            deck.add(i, cardToAdd);
        }
    }
}