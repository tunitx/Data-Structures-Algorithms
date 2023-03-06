//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)throws IOException
    {
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int[] arr = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(s[i]);

    		out.println (new Solution().closestToZero (arr, n));
        }
        out.close();
        
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
       int sum, res = 999999;
       Arrays.sort(arr);
       int i =0, j = n-1;
       while(i<j){
             sum = arr[i]+arr[j];
            
           if(Math.abs(sum)<Math.abs(res)){
               res = sum;
           }
           else if (Math.abs(sum) == Math.abs(res))
    		{
    		    res = Math.max(res,sum);
    		}
           if(sum<0){
               i++;
           }
           else{
               j--;
           }
       }
       return res;
    }
}