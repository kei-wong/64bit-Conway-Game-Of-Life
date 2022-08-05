import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver program for Conway's Game of Life implemented in a 64-bit integer space.
 * Paste or type your coordinates, using a space to separate each point.
 * Then just press enter!
 * @author Kei Wong
 */
public class MainDriver
{
    public static void main(String[] args)
    {
        System.out.print("Enter a list of (x, y) integer coordinates, separated by spaces:\n> ");
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        String[] rawInput = sc.nextLine().replaceAll("[^\\s\\d-]+", "").split(" ");

        try
        {
            List<LongPoint> gameInput = new ArrayList<>(rawInput.length/2);
            for (int i = 0; i < rawInput.length; i += 2)
            {
                gameInput.add(new LongPoint(Long.parseLong(rawInput[i]), Long.parseLong(rawInput[i+1])));
            }

            GameofLife game = new GameofLife(gameInput);
            game.iterate(10);
        }
        catch (Exception e)
        {
            System.out.println("Invalid input :( Double check your input and try again!");
        }

    }
}
