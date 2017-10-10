import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        
        int[] values = new int[n];
        int topVal = 0;
        int topIndex = -1;
        int lowVal = Integer.MAX_VALUE;
        int lowIndex = -1;
        
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
            
            if(values[i] > topVal) {
                topVal = values[i];
                topIndex = i;
            }
            
            if(values[i] < lowVal) {
                lowVal = values[i];
                lowIndex = i;
            }
        }
        
        System.err.println("n: " + n);
        System.err.println("lowIndex: " + lowIndex);
        System.err.println("lowVal: " + lowVal);
        System.err.println("topIndex: " + topIndex);
        System.err.println("topVal: " + topVal);
        
        if(topIndex < lowIndex) System.out.println(lowVal - topVal);
        else {
            int lowSideAnswer = 0;
            if (lowIndex > 0) {
                int lowSideValue = 0;
                for (int search = lowIndex - 1; search > 0; search--)
                    if(values[search] > lowSideValue)
                        lowSideValue = values[search];
                lowSideAnswer = lowVal - lowSideValue;
                
                System.err.println("lowSideVal: " + lowSideValue);
                System.err.println("lowSideAnswer: " + lowSideAnswer);
            }
            
            int highSideAnswer = 0;
            if (topIndex < (n - 1)) {
                int highSideVal = Integer.MAX_VALUE;
                for (int search = topIndex + 1; search < n; search++)
                    if(values[search] < highSideVal)
                        highSideVal = values[search];
                highSideAnswer = highSideVal - topVal;
                
                System.err.println("highSideVal: " + highSideVal);
                System.err.println("HighSideAnswer: " + highSideAnswer);
            }
            
            System.out.println(Integer.min(lowSideAnswer, highSideAnswer));
        }
    }
}
