/**
 * Created by Eric Park on 9/21/2017.
 */
import java.util.ArrayList;

public class BulgarianDriver
{
    public static void main(String[] args)
    {
        int[] temp = {20, 5, 1, 9, 10};
        ArrayList<Integer> board = new ArrayList<Integer>();
        for(int x : temp)
            board.add(x);

        BulgarianSolitaire game = new BulgarianSolitaire(board);
        //BulgarianSolitaire game = new BulgarianSolitaire();

        System.out.println(game);

       while(!game.gameOver())
        {
            game.move();
            System.out.println(game);
        }
    }
}