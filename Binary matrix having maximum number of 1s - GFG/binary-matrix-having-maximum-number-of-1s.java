//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class GfG {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0) {
            int B = sc.nextInt();
            int arr[][] = new int[B][B];
            for(int i = 0; i < B; i++) {
                for(int j = 0; j < B; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int ans[] = obj.findMaxRow(arr, B);
            for(int i = 0; i < 2; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] findMaxRow(int mat[][], int n) {
        // code here
        int maxIdx = 0;
        int prevMax =0;
        int m = n;
        for(int i =0; i<n; i++){
            int lastOccurence = lastOccurenceInMat(mat[i],n, m);
            if(lastOccurence ==-1){
                return new int [] {i,n};
            }
            else{
                int currMax = m-1-lastOccurence;
                if(prevMax<currMax) {
                    prevMax = currMax;
                    maxIdx = i;
                }
            }
        }
        return new int[] {maxIdx, prevMax};
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
       return check?res:-1;
    }
};