import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        
        String binaryMessage = ConvertToBinary(MESSAGE);
        
        String unaryMessage = ConvertToUnary(binaryMessage);
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(unaryMessage);
    }
    
    // Converts an ASCII string to a string of 1's and 0's
    private static String ConvertToBinary(String message) {
        String binaryValue = "";
        
        for(int letter = 0; letter < message.length(); letter++) {
            int asciiValue = (int) message.charAt(letter);
            // we are only doing 7-bit binary, so max base 2 considered is 64
            for(int base2 = 64; base2 > 0; base2 /= 2) {
                int binaryPlace = asciiValue / base2;
                binaryValue += binaryPlace;
                asciiValue -= (binaryPlace * base2);
            }
        }
        
        return binaryValue;
    }
    
    private static String ConvertToUnary(String BinaryMessage) {
        String unaryMessage = "";
        
        // Trick the system with an impossible starting value.
        char lastChar = '2';
        while(BinaryMessage.length() > 0) {
            // If the series changes, then print the correct first block
            if(BinaryMessage.charAt(0) != lastChar) {
                if(BinaryMessage.charAt(0) == '1') unaryMessage += " 0 ";
                else unaryMessage += " 00 ";
                lastChar = BinaryMessage.charAt(0);
            }
            
            // add a 0 to the second block, regardless of whether the series changes
            unaryMessage += "0";
            BinaryMessage = BinaryMessage.substring(1);
        }
        
        // return the message with whitespace trimmed
        return unaryMessage.trim();
    }
}
