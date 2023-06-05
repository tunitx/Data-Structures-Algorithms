//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        var dp = new int[str.length()+1][str.length()+1];
        for(int i =0; i<dp.length; i++){
           for(int j =0; j<dp.length; j++){
               dp[i][j] = -1;
           }
        }
        return lcs(str, str.length(), str.length(), dp);
    }
    public int lcs(String str, int x, int y, int [][] dp){
        if(dp[x][y]!=-1) return dp[x][y];
        if(x==0 || y==0) dp[x][y] =0;
        else{
            if(str.charAt(x-1) == str.charAt(y-1) && x!=y){
                dp[x][y] = 1 + lcs(str, x-1, y-1, dp);
            }
            else{
                dp[x][y] = Math.max(lcs(str, x-1, y , dp), lcs(str, x, y-1, dp));
            }
        }
        return dp[x][y];
    }
}