//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int [] temp1 = new int [n];
        int [] temp2 = new int [n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            temp1[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i =n-1; i>=0; i--){
            min = Math.min(min, arr[i]);
            temp2[i] = min;
        }
        
        for(int i =1; i<n-1; i++){
            if(temp1[i] == temp2[i]){
                return temp1[i];
            }
        }
        return -1;
    }
}