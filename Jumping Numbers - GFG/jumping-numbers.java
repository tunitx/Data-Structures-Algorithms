//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   static long ans;
   Solution(){
       ans = -1;
   }
    static long jumpingNums(long N) {
        // code here
        for(long i =1; i<=9; i++){
            helper(i, N);
        }
        return ans;
    }
    static void helper(long num, long target){
        if(num> target){
            return;
        }
        ans = Math.max(ans, num);
        
        long add = num%10+1;
        long sub = num%10-1;
        
        if(add<10){
            helper(num*10+add, target);
        }
        if(sub>=0){
            helper(num*10+sub, target);
        }
        return;
    }
};