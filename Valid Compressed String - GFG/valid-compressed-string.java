//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int sLen = S.length();
        int tLen = T.length();
        int i =0, j =0;
        boolean check = false;
        while(i<sLen && j<tLen){
            int jumpTo = 0;
            while( j<tLen && i<sLen && Character.isDigit(T.charAt(j)) ){
                int k =   Character.getNumericValue(T.charAt(j));
                jumpTo= jumpTo*10 + k;
                j++;
            }
            i+=jumpTo;
            if( i==sLen && j==tLen){
                return 1;
            }
            if(i>=sLen || j>=tLen){
                return 0;
            }
            if(S.charAt(i)==T.charAt(j)){
                // check = true;
            }
            else{
                return 0;
            }
            i++;
            j++;
        }
        return (i==sLen && j==tLen)?1:0;
    }
}