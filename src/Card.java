/**
 * Joshua Benyo Baker
 * December 8 2022
 */
public class Card
{
    private String suit;
    private String rank;
    private int point;

    //returns the suit of the card
    public String getSuit() {
        return suit;
    }

    //changes the suit of the card
    public void setSuit(String suit) {
        this.suit = suit;
    }

    //constructor
    public Card(String suit, String rank, int point) {
        this.suit = suit;
        this.rank = rank;
        this.point = point;
    }

    //returns the rank of the card
    public String getRank() {
        return rank;
    }

    //changes the rank of the card
    public void setRank(String rank) {
        this.rank = rank;
    }

    //returns the point value of the card
    public int getPoint() {
        return point;
    }

    //changes the point value of the card
    public void setPoint(int point) {
        this.point = point;
    }

    //returns string in format rank of suit
    public String toString()
    {
        return rank + " of " + suit;
    }
}