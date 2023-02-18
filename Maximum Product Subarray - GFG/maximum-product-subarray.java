//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
      
         long max_ending =1;
        long max_sofar = Integer.MIN_VALUE;
        long max_val = 1, min_val = 1;
        for(int i =0; i<arr.length; i++){
            // max_ending = max_ending*arr[i];
            if(arr[i]<0){
            //   swap(max_val, min_val);
            long temp = max_val;
            max_val =min_val;
            min_val = temp;
            }
            max_val = Math.max(arr[i], arr[i]*max_val);
            min_val = Math.min(arr[i], arr[i]*min_val);
            max_sofar = Math.max(max_sofar, max_val);
        }

        return max_sofar;
    }
    // public static void swap(long i , long j){
    //     long temp = i;
    //     i=j;
    //     j=temp;
    // }
}