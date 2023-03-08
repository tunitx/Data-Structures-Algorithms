//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
         int sum =0;
        boolean zeroCheck = true;
        int count =0;
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            if(i<str.length()-1 && ch =='.' && str.charAt(i+1)=='.'){
                return false;
            }
            if(ch == '.'){
                zeroCheck = true;
                sum =0;
                count++;
            }
            else if(Character.isDigit(ch)){
                
                if(i<str.length()-1 && ch == '0' && zeroCheck && str.charAt(i+1)!='.'){
                    return false;
                }
               
                    zeroCheck = false;
                    sum = Character.getNumericValue(ch) + 10*sum;
 
                if(sum>255){
                    return false;
                }
            }
            else{
                return false;
            }

        }
        // if(sum>255){
        //     return false;
        // }
        if(count!=3){
            return false;
        }
        return true;
    }
}