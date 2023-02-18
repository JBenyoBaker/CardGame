import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardGameView extends JFrame
{
    Game game;

    Image CARD_BACK = new ImageIcon("Resources/back.png").getImage();
    int WINDOW_WIDTH = 1440;
    int WINDOW_HEIGHT = 815;

    //constructor
    public CardGameView(Game game)
    {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Poker");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    //prints out the original hand of the user into the window
    public void paintNew(Graphics g, Player user, Player computer)
    {
        ArrayList<Card> usersHand = user.getHand();
        for (int i = 0; i < 5; i++)
        {
            Image pic = usersHand.get(i).getPicture();
            g.drawImage(pic, 485 + i * 100, 600, 75, 150, this);
            g.drawImage(CARD_BACK, 485 + i * 100, 115, 75, 150, this);
            g.drawString(Integer.toString(i), 520 + i * 100, 775);
        }
        g.drawString(user.getName(), 700, 575);
        g.drawString("Computer", 700, 75);
        g.setColor(Color.GREEN);
        g.fillRect(660, 400, 300, 100);
        g.setColor(Color.BLACK);
    }

    //prints out both of the final hands of the player, and user into the window, along with who won the round
    public void revealWinner(Graphics g, Player user, Player computer, Player winner)
    {
        ArrayList<Card> usersHand = user.getHand();
        ArrayList<Card> computersHand = computer.getHand();
        for (int i = 0; i < 5; i++)
        {
            Image pic = computersHand.get(i).getPicture();
            g.drawImage(pic, 485 + i * 100, 115, 75, 150, this);
            pic = usersHand.get(i).getPicture();
            g.drawImage(pic, 485 + i * 100, 600, 75, 150, this);
        }
        g.drawString("The winner is " + winner.getName() + "!", 660, 450);
    }

    //creates the window with a green background, and puts the "deck" of cards on the left side of the window, and prints the instructions onto the board
    public void paint(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.black);
        g.drawImage(CARD_BACK, 50, 350, 75, 150, this);
        drawInstructions(g, "After you start the game the program will print out your hand. Once this happens you will have the option to remove 0, 1, 2, or  3  cards from your hand. If you choose to remove cards from your hand you will specify which card via the index of the card, labeled under the cards in the window. Then the program will reveal to you the randomly generated hand of the computer, as well as tell you who wins the round. Next, you will have the option to play another round, either type y, or n into the terminal to specify your choice. The game will go on for up to 3 rounds. Good luck!");
    }

    //prints the instructions out on the right side of the window recursively
    public int drawInstructions(Graphics g, String str)
    {
        if (str.length() < 50)
        {
            g.drawString(str, 1100, 500);
            return 500;
        }
        int y = drawInstructions(g, str.substring(50)) - 15;
        g.drawString(str.substring(0, 50), 1100, y);
        return y;
    }
}