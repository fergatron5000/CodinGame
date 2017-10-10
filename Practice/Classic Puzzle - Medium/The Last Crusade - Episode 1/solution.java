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
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        int [][] tunnels = new int[H][W];
        for (int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                tunnels[i][j] = in.nextInt();
            }
            in.nextLine();
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
        in.nextLine();

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            in.nextLine();
            
            switch(tunnels[YI][XI]) {
                case 1:
                case 3:
                case 7:
                case 8:
                case 9:
                case 12:
                case 13:
                    System.out.println(XI + " " + (YI + 1));
                    break;
                case 2:
                case 6:
                    if(POS.compareTo("LEFT") == 0 )
                        System.out.println((XI + 1) + " " + YI);
                    if(POS.compareTo("RIGHT") == 0 )
                        System.out.println((XI - 1) + " " + YI);
                    break;
                case 4:
                case 10:
                    if(POS.compareTo("TOP") == 0 )
                        System.out.println((XI - 1) + " " + YI);
                    else
                        System.out.println(XI + " " + (YI + 1));
                    break;
                case 5:
                case 11:
                    if(POS.compareTo("TOP") == 0 )
                        System.out.println((XI + 1) + " " + YI);
                    else
                        System.out.println(XI + " " + (YI + 1));
                    break;
                default:
                    System.err.println("Hit Default: " + tunnels[YI][XI]);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            //System.out.println("0 0"); // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
        }
    }
}
