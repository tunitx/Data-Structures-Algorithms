//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        //date : 9th june 2023
        var dp = new int[s.length()+1][t.length()+1];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(s, t, s.length(), t.length(), dp);
    }
    static int helper(String s1, String s2, int x, int y, int [][] dp){
        //base cases
       
        if(x==0) dp[x][y] = y;
        if(y==0) dp[x][y] = x;
         if(dp[x][y]!=-1) return dp[x][y];
        else{
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            dp[x][y] = 0 + helper(s1, s2, x-1, y-1, dp);
        }
        else{
            int a  = 1 + helper(s1, s2, x-1, y-1 , dp);
            int b = 1 + helper(s1, s2, x, y-1, dp);
            int c = 1 + helper(s1, s2, x-1, y, dp);
            dp[x][y] = Math.min(a, Math.min(b,c));
        }
        }
        return dp[x][y];
    }
}