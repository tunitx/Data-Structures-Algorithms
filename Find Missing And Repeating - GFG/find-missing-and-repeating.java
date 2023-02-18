//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        //counting sort based algorithm
        //Leetcode version of this question is a bit tricky, have to handle few 
        //Side testcases as well.
        // link to leetcode problem : 
        //https://leetcode.com/problems/first-missing-positive/
        
        int i =0;
        while(i<arr.length){
            // the correctIndex of the element arr[i]
            int correctIndex = arr[i]-1;
            if(arr[correctIndex]!=arr[i]){
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else{
                i++;
            }
        }
        int j =0;
        while(j<arr.length){
            if(j!=arr[j]-1){
                return new int [] {arr[j], j+1};
            }
            j++;
        }
        return new int [] {0,0};
    }
}