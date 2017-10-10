import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        
        int targetLowerBound = H - 1;
        int targetUpperBound = 0;
        int targetRightBound = W - 1;
        int targetLeftBound = 0;
        
        int BatX = X0;
        int BatY = Y0;
        
        // game loop
        while (true) {
            String BOMB_DIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            
            // For each direction provided as input, adjust the known bounds of the bomb's location.
            // Then plan my jump in that direction.
            // Note that I handle up/down and left/right separately during the planning phase, but use the composite as my actual move.
            if (BOMB_DIR.contains("U")) {
                targetLowerBound = BatY - 1;
                BatY = BatY - ((BatY - targetUpperBound + 1) / 2);
            }
            if (BOMB_DIR.contains("D")) {
                targetUpperBound = BatY + 1;
                BatY = BatY + ((targetLowerBound - BatY + 1) / 2);
            }
            if (BOMB_DIR.contains("L")) {
                targetRightBound = BatX - 1;
                BatX = BatX - ((BatX - targetLeftBound + 1) / 2);
            }
            if (BOMB_DIR.contains("R")) {
                targetLeftBound = BatX + 1;
                BatX = BatX + ((targetRightBound - BatX + 1) / 2);
            }
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(BatX + " " + BatY); // the location of the next window Batman should jump to.
        }
    }
}
