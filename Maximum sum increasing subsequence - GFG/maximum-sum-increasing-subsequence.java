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
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    var mis = new int[n];
	    int max = arr[0];
	    for(int i =0; i<n; i++){
	        mis[i] = arr[i];
	        for(int j=0; j<i; j++){
	            if(arr[i]>arr[j]){
	                mis[i] = Math.max(mis[i], mis[j] + arr[i]);
	            }
	        }
	        max = Math.max(max , mis[i]);
	    }
	    return max;
	    
	}  
}