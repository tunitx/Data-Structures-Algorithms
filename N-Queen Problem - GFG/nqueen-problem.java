//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int [][] mat = new int[n][n];
        var ans = new ArrayList<ArrayList<Integer>>();
        solveRec(0, mat, ans,n);
        return ans;
    }
     public static void solveRec(int col, int [][] mat, ArrayList<ArrayList<Integer>> ans, int n){
        if(col == n){
            var temp = new ArrayList<Integer>();
            for(int i =0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(mat[j][i]!=0){
                        temp.add(j+1);
                    }
                }
            }
            ans.add(temp);
            return;
         }

        for(int row =0; row<n; row++){
            if(isValid(row, col, mat)){
                mat[row][col] = 1;
                solveRec(col+1, mat, ans, n);
                mat[row][col] = 0;
            }
        }
    }
     public static boolean isValid(int row, int col, int [][] mat){
        int x = row;
        int y = col;
        while(x>=0 ){
            if(mat[x][col]==1){
                return false;
            }
            x--;
        }
        x= row;
        while(y>=0){
            if(mat[x][y]==1) return false;
            y--;
        }
        y = col;
        while(x>=0 && y>=0){
            if(mat[x][y] ==1) return false;
            x--;
            y--;
        }
        x= row;
        y= col;
        while(x<mat.length && y>=0){
            if(mat[x][y]==1) return false;
            x++;
            y--;
        }
        return true;
    }
}