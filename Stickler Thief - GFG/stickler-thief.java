//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        // boolean alt = true;
        // int prevSum =0;
        // int currSum = 0;
        // int max =Integer.MIN_VALUE;
        // for(int i =0; i<n; i++){
        //     if(alt){
        //         currSum+=arr[i];
        //         // alt = !alt;
        //     }
        //     else{
        //         prevSum +=arr[i];
               
        //     }
        //     max = Math.max(prevSum, currSum);
        //      alt = !alt;
        // }
        // return max;
        int exl = 0, inc =arr[0];
        for(int i =1; i<n; i++){
            int exl_new = Math.max(exl, inc);
            inc = exl + arr[i];
            exl = exl_new;
        }
        return Math.max(exl, inc);
        
    }
}