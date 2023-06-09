//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        // code here
        String rev = new StringBuilder(S).reverse().toString();
        var dp = new int [S.length()+1][S.length()+1];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j]= -1;
            }
        }
        return rev.length()- helper(S, rev, S.length(), S.length(), dp);
    }
    int helper(String s1, String s2, int x, int y, int [][] dp){
        //base cases
        // if(x==0) return y;
        if(y==0 || x ==0) return 0;
        if(dp[x][y]!=-1) return dp[x][y];
        else{
        if(s1.charAt(x-1) == s2.charAt(y-1)){
            dp[x][y] = 1+ helper(s1, s2, x-1, y-1, dp);
        }
        else{
          
            dp[x][y] = Math.max( helper(s1, s2, x, y-1, dp), helper(s1, s2, x-1, y, dp));
        }
        }
        return dp[x][y];
    }
}