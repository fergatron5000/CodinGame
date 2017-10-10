import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int closestEnemyDistance = Integer.MAX_VALUE;
            String closestEnemyName = "";
            
            int count = in.nextInt(); // The number of current enemy ships within range
            in.nextLine();
            for (int i = 0; i < count; i++) {
                String enemy = in.next(); // The name of this enemy
                int dist = in.nextInt(); // The distance to your cannon of this enemy
                
                if (dist < closestEnemyDistance) {
                    closestEnemyDistance = dist;
                    closestEnemyName = enemy;
                }
                
                in.nextLine();
            }

            System.out.println(closestEnemyName);
        }
    }
}
