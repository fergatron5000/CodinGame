import java.util.*;
import java.io.*;
import java.math.*;

/**
 * This is my customized solution utilizing the auto-generated code provided by CodinGame.
 **/
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String COORD = in.next();
        COORD = COORD.replace(',', '.');
        double LON = Math.toRadians(Double.valueOf(COORD));
        in.nextLine();
        COORD = in.next();
        COORD = COORD.replace(',', '.');
        double LAT = Math.toRadians(Double.valueOf(COORD));
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();
        
        // Search while reading
        String closestUnitName = "UNKNOWN";
        double closestUnitDistance = 6372.0;
        for (int i = 0; i < N; i++) {
            String unit = in.nextLine();
            unit = unit.substring(unit.indexOf(';') + 1); // Remove id number
            String currentUnitName = unit.substring(0, unit.indexOf(';'));
            unit = unit.substring(unit.indexOf(';') + 1); // Remove name
            unit = unit.substring(unit.indexOf(';') + 1); // Remove address
            unit = unit.substring(unit.indexOf(';') + 1); // Remove phone
            COORD = unit.substring(0, unit.indexOf(';') - 1);
            COORD = COORD.replace(',', '.');
            double unitLon = Math.toRadians(Double.valueOf(COORD));
            unit = unit.substring(unit.indexOf(';') + 1); // Remove longitude
            COORD = unit;
            COORD = COORD.replace(',', '.');
            double unitLat = Math.toRadians(Double.valueOf(COORD));
            double distance = CalculateDistance(LAT, LON, unitLat, unitLon);
            if(distance < closestUnitDistance) {
                closestUnitName = currentUnitName;
                closestUnitDistance = distance;
            }
        }
        
        System.out.println(closestUnitName);
    }
    
    /***********************************************************************************
     * Calculates the distance between the emergency and the current defib unit.
     ***********************************************************************************/
    public static double CalculateDistance (double latitude, double longitude, double unitLat, double unitLon) {
        double X = (longitude - unitLon) * Math.cos((latitude + unitLat)/2);
        double Y = latitude - unitLat;
        double dist = (X * X) + (Y * Y);
        dist = Math.sqrt(dist) * 6371;
        return dist;
    }
}
