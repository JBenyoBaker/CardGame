/** Poker Game
 * Joshua Benyo Baker
 * December 8 2022
 */
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import java.util.Scanner;

public class Game
{
    //main method
    public static void main(String[] args)
    {
        PlayGame();
    }

    //runs the game
    public static void PlayGame()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("What is your name?");
        Player user = new Player(reader.nextLine());
        Player computer = new Player("computer");

        Deck d = createPokerDeck();

        while (d.getNumCardsLeft() < 13)
        {
            System.out.println("------------------------");
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("------------------------");
            dealHand(user, computer, d);
            drawCards(user, reader, d);
            Player winner = findWinner(user, computer);
            System.out.println();
            user.printHand();
            System.out.println();
            computer.printHand();
            System.out.println();
            System.out.println(winner.getName() + " wins the round!");
            System.out.println();
            user.clearHand();
            computer.clearHand();
        }
        System.out.println("Thank you for playing!!!");
    }

    //creates new 52 card poker deck
    public static Deck createPokerDeck()
    {
        ArrayList<Card> d = new ArrayList<Card>();
        Deck deck = new Deck(d);

        for (int i = 1; i < 13; i++) {
            String r;
            if (i < 9)
            {
                r = String.valueOf(i + 1);
            }
            else if (i == 9)
            {
                r = "Jack";
            }
            else if (i == 10)
            {
                r = "Queen";
            }
            else if (i == 11)
            {
                r = "King";
            }
            else
            {
                r = "Ace";
            }
            for (int j = 0; j < 4; j++) {
                String suit = " ";
                if (j == 0) {
                    suit = "Hearts";
                } else if (j == 1) {
                    suit = "Spades";
                } else if (j == 2) {
                    suit = "Clubs";
                } else if (j == 3) {
                    suit = "Diamonds";
                }
                Card x = new Card(suit, r, i + 1);
                d.add(x);
            }
        }
        deck.shuffle();
        return deck;
    }

    //gives both the computer and the user a new 5 card hand, also prints the users hand
    public static void dealHand(Player user, Player computer, Deck d)
    {
        for (int i = 0; i < 5; i++)
        {
            user.addCard(d.deal());
            computer.addCard(d.deal());
        }

       ArrayList<Card> hand  = user.getHand();
        for (int i = 0; i < 5; i++)
        {
            System.out.println(hand.get(i));
        }
    }

    //removes the cards the user wants to remove, then it gives the user new cards
    public static void drawCards(Player user, Scanner reader, Deck d)
    {
        System.out.println("How many cards would you like to draw? (0, 1, 2, 3)");
        int numCardsDrawn = reader.nextInt();

        for (int i = 0; i < numCardsDrawn; i++)
        {
            System.out.println("What index would you like to remove?");
            int index = reader.nextInt();
            if (index < user.getHand().size())
            {
                user.getHand().remove(index);
            }
            else
            {
                --i;
            }
        }
        while (user.getHand().size() < 5)
        {
            user.getHand().add(d.deal());
        }
    }

    //returns the player who won the round
    public static Player findWinner(Player user, Player computer)
    {
        Player winner;
        ArrayList<Card> usersHand = user.getHand();
        ArrayList<Card> computersHand = computer.getHand();
        //Sorting cards by points
        user.getHand().sort(Comparator.comparing(Card::getPoint));
        computer.getHand().sort(Comparator.comparing(Card::getPoint));
        //compare the hands
        if (user.getHighHand() > computer.getHighHand())
        {
            return user;
        }
        if (user.getHighHand() < computer.getHighHand())
        {
            return computer;
        }
        Player x = new Player("Nobody");
        return x;
    }

}