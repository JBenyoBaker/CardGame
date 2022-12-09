/**
 * Joshua Benyo Baker
 * December 8 2022
 */

import java.util.ArrayList;

public class Player
{
    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();

    //Constructor
    public Player(String name) {
        this.name = name;
    }

    //Renames the player
    public void setName(String name) {
        this.name = name;
    }

    //returns name
    public String getName() {
        return name;
    }

    //adds card to the player's hand
    public void addCard(Card c)
    {
        hand.add(c);
    }

    //returns hand (an ArrayList of cards)
    public ArrayList<Card> getHand()
    {
        return hand;
    }

    //empties ArrayList hand
    public void clearHand()
    {
        while (hand.size() > 0)
        {
            hand.remove(0);
        }
    }

    //returns an int which corresponds to what type (ex. Royal Flush) of hand it is
    public int getHighHand()
    {
        //check for royal flush
        if (hand.get(0).getPoint() == 10 && hand.get(1).getPoint() == 11 && hand.get(2).getPoint() == 12 && hand.get(3).getPoint() == 13 && hand.get(4).getPoint() == 14)
        {
            return 24;
        }
        //check for straight flush
        if (hand.get(0).getPoint() == 6 && hand.get(1).getPoint() == 7 && hand.get(2).getPoint() == 8 && hand.get(3).getPoint() == 9 && hand.get(4).getPoint() == 10)
        {
            return 23;
        }
        //check for 4 of a kind
        boolean b = (hand.get(1).getPoint() == hand.get(2).getPoint() && hand.get(2).getPoint() == hand.get(3).getPoint());
        if ((hand.get(0).getPoint() == hand.get(1).getPoint() && b) || (hand.get(4).getPoint() == hand.get(3).getPoint() && b))
        {
            return 22;
        }
        //check for full house
        if (hand.get(0).getPoint() == 13 && hand.get(1).getPoint() == 13 && hand.get(2).getPoint() == 14 && hand.get(3).getPoint() == 14 && hand.get(4).getPoint() == 14)
        {
            return 21;
        }
        //check for flush
        if (hand.get(0).getPoint() == 5 && hand.get(1).getPoint() == 7 && hand.get(2).getPoint() == 8 && hand.get(3).getPoint() == 10 && hand.get(4).getPoint() == 13)
        {
            return 20;
        }
        //check for straight
        if (hand.get(0).getPoint() == 6 && hand.get(1).getPoint() == 7 && hand.get(2).getPoint() == 8 && hand.get(3).getPoint() == 9 && hand.get(4).getPoint() == 10)
        {
            return 19;
        }
        //check for three of a kind
        if ((hand.get(2).getPoint() == hand.get(1).getPoint() && hand.get(2).getPoint() == hand.get(0).getPoint()) || (hand.get(2).getPoint() == hand.get(3).getPoint() && hand.get(2).getPoint() == hand.get(4).getPoint()))
        {
            return 18;
        }
        //check for two pair
        if (((hand.get(0).getPoint() == hand.get(1).getPoint()) || (hand.get(1).getPoint() == hand.get(2).getPoint())) && (((hand.get(2).getPoint() == hand.get(3).getPoint()) || (hand.get(3).getPoint() == hand.get(4).getPoint()))))
        {
            return 17;
        }
        //check for pair
        for (int i = 0; i < hand.size() - 1; i++)
        {
            if (hand.get(i).getPoint() == hand.get(i + 1).getPoint())
            {
                return 16;
            }
        }
        //get high card
        int max = 0;
        for (int i = 0; i < hand.size(); i++)
        {
            if (max > hand.get(i).getPoint())
            {
                max = hand.get(i).getPoint();
            }
        }
        return max;
    }

    //prints each card on a new line
    public void printHand()
    {
        System.out.println(name + "'s hand:");
        for (int i = 0; i < hand.size(); i++)
        {
            System.out.println(hand.get(i));
        }
    }
}