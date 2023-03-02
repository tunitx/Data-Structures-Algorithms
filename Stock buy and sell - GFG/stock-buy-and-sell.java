//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] price = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            sln.stockBuySell(price, n);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void stockBuySell(int[] arr, int n) {
        // code here
        int i =1;
        boolean check = false;
        while(i<arr.length){
            if(arr[i]>arr[i-1]){
                int last = i;
                int max = arr[i];
                while(last<n){
                    if(max>arr[last]){
                        break;
                    }
                    else{
                        max = Math.max(max,arr[last]);
                        last++;
                    }
                }
            check = true;
            System.out.print("("+ (i-1) + " " + (last-1) + ")"+ " ");
            // start = last-1;
            i = last;
            }
            else{
              
               i++;
            }
        }
        if(!check) System.out.print("No Profit");
        System.out.println("");
    }
}