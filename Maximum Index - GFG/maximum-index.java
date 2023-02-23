//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int arr[], int N) { 
        
        // Your code here
         int [] lMin= new int [arr.length];
        int [] rMax = new int [arr.length];
        lMin[0] = arr[0];
        for(int i =1; i<arr.length; i++){
                lMin[i] = Math.min(arr[i], lMin[i-1]);
        }
        rMax[arr.length-1] =arr[arr.length-1];
        for(int i = arr.length-2; i>=0;i--){
            rMax[i] = Math.max(arr[i],rMax[i+1] );
        }

        int i =0;
        int j =0;
        int ans = 0;
        while(i<arr.length && j<arr.length){
            if(lMin[i]>rMax[j]){
                i++;
            }
            else{
                ans = Math.max(ans, j-i);
                j++;
            }
        }
        return ans;
        
    }
}


