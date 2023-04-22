//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    int arr[] =  new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    new Solution().sortABS(arr,n, x);
		    StringBuilder sb = new StringBuilder();
		    for(int y : arr)
		        sb.append(y+ " ");
		    System.out.println(sb.toString());
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to difference with given number.
    static void sortABS(int arr[], int n,int k)
    {
        // add your code here
        // int a = 
       Integer[] sortedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr, Comparator.comparingInt(a -> Math.abs(a - k)));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }
    }
}
