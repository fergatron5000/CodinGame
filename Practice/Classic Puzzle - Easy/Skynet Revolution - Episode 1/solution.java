import java.util.*;
import java.io.*;
import java.math.*;

/**
 * This is my customized solution based on the auto-generated code provided by CodinGame.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        
        ArrayList[] map = (ArrayList[])new ArrayList[N];
        
        // Store the Map into memory
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            
            if (map[N1] == null) map[N1] = new ArrayList();
            if (map[N2] == null) map[N2] = new ArrayList();
            map[N1].add(N2);
            map[N2].add(N1);
        }
        
        // Store the exit list into memory
        ArrayList exits = new ArrayList();
        for (int i = 0; i < E; i++) {
            exits.add(in.nextInt()); // the index of a gateway node
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            
            // Assume which link should be removed (exit[0] and map[exit[0]][0])
            int RN1 = (int)exits.get(0);
            int RN2 = (int)map[RN1].get(0);
            
            // check to see if skynet is next to an exit, if so, remove that link instead
            for (int ENI = 0; ENI < exits.size(); ENI++)
                if(map[(int)exits.get(ENI)].contains(SI)) {
                    RN1 = (int)exits.get(ENI);
                    RN2 = SI;
                }
            
            // Remove the selected link
            System.out.println(RN1 + " " + RN2);
            
            // remove the selected link from my map
            map[RN1].remove(map[RN1].indexOf(RN2));
            map[RN2].remove(map[RN2].indexOf(RN1));
            
            // if the exit has been completely cut off, remove it from my list.
            if(map[RN1].isEmpty()) exits.remove(exits.indexOf(RN1));
        }
    }
}
