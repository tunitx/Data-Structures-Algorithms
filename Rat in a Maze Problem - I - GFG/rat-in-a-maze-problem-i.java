//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        //date : 28th may 2023
        
        boolean vis [][] = new boolean[n][n];
       
        String res = "";
        ArrayList<String> ans = new ArrayList<>();
        
        rmp(0, 0, res, ans, m, n, vis);
        return ans;
    }
    static void rmp(int i , int j, String res, ArrayList<String> ans, int [][] mat, int n, boolean vis [][]){
        //base condition to check if we have reached the destination ie mat[n-1][j-1]( last cell)
       
        
        if(!checkForSafeCell(i, j, mat, vis, n)){
             if(i== n-1 && j==n-1){
            ans.add(res);
            return;
        }
            vis[i][j] = true;
            
            rmp(i-1, j, res + 'U', ans, mat, n, vis);
            rmp(i, j+1, res + 'R', ans, mat, n, vis);
            rmp(i+1, j, res + 'D', ans, mat, n, vis);
             rmp(i, j-1, res + 'L', ans, mat, n, vis);
            
            vis[i][j] = false;
        }
        return;
    }
   static boolean   checkForSafeCell(int i, int j, int [][] mat, boolean [][] vis, int n ){
        return (i<0 || j<0 || i>=n || j>=n || mat[i][j]==0 || vis[i][j] );
    }
}