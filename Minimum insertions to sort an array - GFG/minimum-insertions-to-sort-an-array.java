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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minInsertions(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minInsertions(int arr[], int n) 
	{ 
        //code here.
    //      var lis = new int [n];
	   //var len =1;
	   //lis[0] = arr[0];
	   
	   //for(var i = 1; i<n; i++){
	   //    if(arr[i]>=lis[len-1]){
	   //        lis[len] = arr[i];
	   //        len++;
	   //    }
	   //    else{
	   //        int ceil = findCeil(lis, 0, len-1, arr[i]);
	   //        lis[ceil] = arr[i];
	   //    }
	   //}
	   //return n-len;
	   
	   
	   
	   
	    var dp = new int [n];
        
        dp[0] = 1;
        var maxLen = 1;
        for(int i =1 ; i<n; i++){
            dp[i] = 1;
            for(int j =0; j<i; j++){
                if(arr[j]<=arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        // int res = dp[0];
        // for(int i =1 ; i<n; i++){
        //     res = Math.max(res, dp[i]);
        // }
        return n-maxLen;
	} 
		public int findCeil(int [] lis, int start, int end, int target){
	    while(start<end){
	        var mid = (start+end)/2;
	        if(lis[mid]>=target){
	            end = mid;
	        }
	        else{
	            start = mid+1;
	        }
	    }
	    return end;
	}
}
