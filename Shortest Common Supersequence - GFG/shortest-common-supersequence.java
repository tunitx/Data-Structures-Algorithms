//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        var dp = new int[m+1][n+1];
        for(int i =0; i<m+1; i++){
            for(int j =0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        int x = lcs(X, Y, m,n, dp);
        return m-x + n-x + x;
    }
    static int lcs(String s1, String s2, int x, int y, int [][] dp) {
        if(dp[x][y] !=-1) return dp[x][y];
        if(x==0 || y==0) dp[x][y] = 0;
        else{
            if(s1.charAt(x-1)==s2.charAt(y-1)){
                dp[x][y] = 1 + lcs(s1, s2, x-1, y-1, dp);
            }
            else{
                dp[x][y] = Math.max(lcs(s1, s2, x-1, y, dp),lcs(s1, s2, x, y-1, dp));
            }
        }
        return dp[x][y];
    }
}