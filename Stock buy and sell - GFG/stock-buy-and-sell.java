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
        int start =0;
        // int end = 0;
        int i =0;
        boolean check = true;
        while(i<arr.length-1){
            while(i<arr.length-1 && arr[i+1]>arr[i]){
                i++;
            }
                if(start!=i){
                    check = false;
                    System.out.print("("+ start + " " + i +")" + " " );
                }
                start = i+1;
                i = start;
            
            // i++;
        }
        // if(start!=end){
        //     System.out.printf("("+ start + " " + i + ")"+ " ");
        // }
        if(check){
            System.out.print("No Profit");
        }
        System.out.println("");
    }
}