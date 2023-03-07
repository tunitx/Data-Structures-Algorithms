//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int mat[][], int n, int m) {
        // code here
         int maxIdx = -1;
        int prevMax =0;
        for(int i =0; i<n; i++){
            int lastOccurence = lastOccurenceInMat(mat[i],n, m);
            if(lastOccurence ==-1){
                return i;
            }
            else{
                int currMax = m-1-lastOccurence;
                if(prevMax<currMax) {
                    prevMax = currMax;
                    maxIdx = i;
                }
            }

        }
        return maxIdx;
    }
    public static int lastOccurenceInMat(int [] mat, int n, int m){
        int low = 0;
         int high = m-1;
         int res = 0;
         boolean check = false;
        while(low<=high){
            int mid = (low+high)/2;
            if(mat[mid]==0){
                check = true;
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        if(!check){
            return -1;
        }
        return res;
    }
}