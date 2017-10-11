import java.util.*;
import java.io.*;
import java.math.*;

/**
 * This is my customization of the auto-generated code provided by CodinGame to solve the problem.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();
        
        // Store the art input into an array.
        String[] asciiArt = new String[H];
        
        for (int i = 0; i < H; i++) {
            asciiArt[i] = in.nextLine();
        }
        
        // Convert the text to be displayed into a "word".
        // each value in this word is an "index" to a letter in the capital alphabet
        // A = 0, B = 1, etc, ? = 26
        int[] word = new int[T.length()];
        
        for(int letterIndex = 0; letterIndex < T.length(); letterIndex++) {
            int letter = (int)(T.charAt(letterIndex));
            
            //Convert upper case letters first
            if((65 <= letter) && (letter <= 90)) letter = letter - 65;
            //else convert lower case letter
            else if((97 <= letter) && (letter <= 122)) letter = letter - 97;
            //else use ?
            else letter = 26;
            
            word[letterIndex] = letter;
        }
        
        // because the art is multiple lines, each one must be printed individually
        for (int lineOfArt = 0; lineOfArt < H; lineOfArt++) {
            // in each line, you must iterate over all the letters
            for (int letterOfWord = 0; letterOfWord < word.length; letterOfWord++) {
                // using my "word" from above, determine what subset of the ascii art to display.
                int startIndex = L * word[letterOfWord];
                int endIndex = startIndex + L;
                System.out.print(asciiArt[lineOfArt].substring(startIndex, endIndex));
            }
            
            System.out.println();
        }
    }
}
