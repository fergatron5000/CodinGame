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
            
            int MAX_TRAVEL_HS = 60;
            int MAX_TRAVEL_ANGLE = 20;
            
            if(X < startFlat) {
                if(HS < MAX_TRAVEL_HS) System.out.println("-" + MAX_TRAVEL_ANGLE + " 4");
                else System.out.println(MAX_TRAVEL_ANGLE + " 4");
            } else if (endFlat < X) {
                if(HS > (-1 * MAX_TRAVEL_HS)) System.out.println(MAX_TRAVEL_ANGLE + " 4");
                else System.out.println("-" + MAX_TRAVEL_ANGLE + " 4");
            } else {
                int MAX_HS = 5;
                
                if (HS > MAX_HS) System.out.print("50 ");
                else if (HS < (-1 * MAX_HS)) System.out.print("-50 ");
                else System.out.print("0 ");
                
                if ((VS < -30) || (Math.abs(HS) > MAX_HS)) System.out.println("4"); // R P. R is the desired rotation angle. P is the desired thrust power.
                else System.out.println("0");
            }
        }
    }
}
