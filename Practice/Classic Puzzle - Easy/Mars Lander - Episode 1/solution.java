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
        int N = in.nextInt(); // the number of points used to draw the surface of Mars.
        int startFlat = 7000;
        int endFlat = 0;
        int elevationFlat = 3000;
        boolean flatFound = false;
        for (int i = 0; i < N; i++) {
            int LAND_X = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int LAND_Y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            
            if(!flatFound) {
                if(LAND_Y == elevationFlat) {
                    endFlat = LAND_X;
                    flatFound = true;
                } else {
                    startFlat = LAND_X;
                    elevationFlat = LAND_Y;
                }
            }
        }

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int HS = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int VS = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int F = in.nextInt(); // the quantity of remaining fuel in liters.
            int R = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int P = in.nextInt(); // the thrust power (0 to 4).

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            // while over the flat area, reduce horozontal speed by tilting opposite movement
            if((startFlat < X) && (X < endFlat)) {
                if (HS > 20) System.out.print("30 ");
                else if (HS < -20) System.out.print("-30 ");
                else System.out.print("0 ");
            }
            
            // This was tricky and just trial and error. This combination of waiting and the full throttle lands at exactly -40m/s
            if((Y - elevationFlat) > 2200) System.out.println("0");
            else if (VS < -39)  System.out.println("4"); // R P. R is the desired rotation angle. P is the desired thrust power.
            else System.out.println("0");
        }
    }
}
