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
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
     int [][] mat = new int[n][n];
    solveRec(0, n, ans, mat);
    // Collections.sort(ans, (a,b)-> a.get(0)-b.get(0));
    return ans;
    }
    static void  solveRec(int col, int n,  ArrayList<ArrayList<Integer>> ans, int [][]mat){
        if(col == n){
            ArrayList< Integer> temp = new ArrayList<>();
            for(int i =0; i<n; i++){
                for(int j =0; j<n; j++){
                    if(mat[j][i] ==1){
                        temp.add(j+1);
                    }
                }
            }
            ans.add(temp);
            return ;
        }
        for(int i =0; i<n; i++){
              
            if(isSafe(i, col, mat,n)){
                mat[i][col] = 1;
                solveRec(col+1, n, ans, mat);
                mat[i][col] = 0;
                  
                }
               
            }
             return;
        }
       

    
    static boolean isSafe(int row, int col, int [][] board, int n){

    int x =row;
       int y=col;
     //row
      while(y>=0){
          if(board[x][y]==1)
          return false;
           y--;
      }
     //upper left diagonal
     x=row;
     y=col;
     while(y>=0 && x>=0){
          if(board[x][y]==1)
          return false;
           y--;
           x--;
      }
     x=row;
     y=col;
     //lower left diagonal
     while(y>=0 && x<n){
          if(board[x][y]==1)
          return false;
           y--;
           x++;
      }
      return true;

    }
}