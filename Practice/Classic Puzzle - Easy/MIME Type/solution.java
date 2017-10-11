import java.util.*;
import java.io.*;
import java.math.*;

/**
 * This is my customization of the auto-generated code to solve the challenge
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        
        // Store the MIME Types and extensions into index linked arrays.
        String[] extensions = new String[N];
        String[] MIMETypes = new String[N];
        
        for (int i = 0; i < N; i++) {
            extensions[i] = in.next(); // file extension
            MIMETypes[i] = in.next(); // MIME type.
            in.nextLine();
        }
        
        // Read in each file name and print its MIME Type individually
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            boolean foundMIME = false;
            String extension = "";
            // Find the extension if one exists.
            if(FNAME.contains(".")) extension = FNAME.substring(FNAME.lastIndexOf('.') + 1);
            // print a MIME Type if one can be found
            for (int j = 0; (j < N) && !foundMIME; j++)
                if (extension.equalsIgnoreCase(extensions[j])) {
                    foundMIME = true;
                    System.out.println(MIMETypes[j]);
                }
            // base case: UNKNOWN
            if(!foundMIME) System.out.println("UNKNOWN");
        }
    }
}
