//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        var rev = new StringBuilder(S).reverse().toString();
        // return 0;
        var dp = new int[S.length()+1][S.length()+1];
        for(int i =0; i<dp.length; i++){
            dp[i][0] =0;
            dp[0][i] =0;
        }
        for(int i =1; i<dp.length; i++){
            for(int j =1; j<dp.length; j++){
                if(S.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[S.length()][S.length()];
    }
}