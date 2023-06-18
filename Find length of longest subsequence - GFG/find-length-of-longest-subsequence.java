//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            String X = input_line[0];
            String Y = input_line[1];
            Solution obj = new Solution();
            int ans = obj.maxSubsequenceSubstring(X, Y, N, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int maxSubsequenceSubstring(String X, String Y, int N, int M) 
    {
        // code here
        //date : 5th june 2023
        //lcs
        var dp = new int[N+1][M+1];
        int max =0;
        for(int i =1; i<dp.length; i++){
            for(int j =1; j<dp[0].length; j++){
                if(X.charAt(i-1)== Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return max;
    }
} 