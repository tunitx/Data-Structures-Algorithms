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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        //date : 6th june 2023
        //tabulation method, bottom - up approach 
        int n = S.length();
        boolean dp [][] = new boolean[n][n];
        
        for(int i =0; i<n; i++){
            dp[i][i] = true;
        }
        int start =0;
        int end =0;
        boolean firstCheck = true;
        for(int i =0; i<n-1; i++){
            if(S.charAt(i)== S.charAt(i+1)){
                dp[i][i+1] = true;
                if(firstCheck){
                start = i;
                end = i+1;
                firstCheck = false;
            }
            }
            
        }
        for(int k =3; k<=n; k++){
            
            for(int i =0; i<n-k+1; i++){
                int j = i+k-1;
                
                if(dp[i+1][j-1] && S.charAt(i)== S.charAt(j)){
                    dp[i][j] = true;
                    
                    if(k>(end-start+1)){
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return S.substring(start, end+1);
        
    }
}