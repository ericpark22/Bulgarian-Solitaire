/*
This program simulates the game Bulgarian Solitaire. It randomly generates card piles out of 45 cards and plays the game
out. One card is removed from the top of each pile and then those cards are added at the end to create a new pile. This
goes on until the cards are arranged in order from 1 to 9 cards in each pile.
 */
import java.util.*; // imports the "util" class used for ArrayLists and Random

public class BulgarianSolitaire
{
    private ArrayList<Integer> board;

    /**
     * Creates the randomly generated card piles and initial state
     */
    public BulgarianSolitaire()
    {
        board = new ArrayList<Integer>();

        Random random =  new Random();
        int currentCards = 45; // current amount of cards needed to be distributed into piles

        while(currentCards > 0)// while there are cards left to distribute
        {
            int pile = random.nextInt(currentCards) + 1; // random number within the range of the current amount of cards
            board.add(pile);// that random number is separated and creates a pile
            currentCards = currentCards - pile; // the new pile is subtracted from the cards remaining to continue the process
        }
    }

    /**
     * Assigns and creates values for the board based on the user's inputs
     * @param board a random amount of card piles that sum up to 45
     */
    public BulgarianSolitaire(ArrayList<Integer> board)
    {
        this.board = board;
    }

    /**
     * Removes a card from each pile and adds those cards to create a new pile at the end
     */
    public void move()
    {
        int count = 0; // cards removed from the piles

            for(int i = board.size() - 1; i >= 0; i--)
            {
                board.set(i, board.get(i) - 1); // sets the current card pile to be 1 less than before
                count++; // the card taken from the pile above is "added" to the total amount of cards removed from the piles

                if(board.get(i) == 0) // if there are no cards left
                    board.remove(i); // deletes the 0 from the ArrayList
            }

            board.add(count); // adds the removed cards from the piles to the end of the board
    }

    /**
     * Checks to see if the game is done and in the correct order (card piles from 1 to 9)
     * @return true if the game is finished or false if the game is not finished
     */
    public boolean gameOver()
    {
        boolean check = true; // initial state is true

        for(int i = 0; i < board.size() - 1; i++)
        {
            if(board.get(i) != ((board.get((i+1)) - 1))) // if the current number is not equal to the next number minus 1
                return false; // game is not done and returns false
        }
        return check; // if false did not occur, the game is finished returns true
    }

    /**
     * Prints out the board for BulgarianSolitaire
     * @return the values of BulgarianSolitarie
     */
    public String toString()
    {
        return "BulgarianSolitaire: " + board;
    }
}