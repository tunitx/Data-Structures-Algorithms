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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	   var dp = new int[str1.length()+1][str2.length()+1];
	   for(int i =0; i<str1.length()+1; i++){
	       for(int j =0; j<str2.length()+1; j++){
	           dp[i][j] = -1;
	       }
	   }
	   int n = lcs(str1.length(), str2.length(), str1, str2, dp);
	   return (str1.length()-n) + (str2.length()- n);
 	} 
	int lcs(int x, int y, String s1, String s2, int [][] dp){
	    if(dp[x][y] != -1) return dp[x][y];
	    if(x==0 || y==0) dp[x][y] = 0;
	    else{
	        if(s1.charAt(x-1)==s2.charAt(y-1)){
	            dp[x][y] = 1+ lcs(x-1, y-1, s1, s2, dp);
	        }
	        else{
	            dp[x][y] = Math.max(lcs(x-1, y, s1, s2 , dp), lcs(x, y-1,s1, s2, dp));
	        }
	    }
	    return dp[x][y];
	}
}