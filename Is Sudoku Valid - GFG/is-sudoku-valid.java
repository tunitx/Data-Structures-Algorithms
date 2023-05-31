//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int grid[][]){
        // code here
          // add your code here
        //date : 31st may 2023
        //take a glance at copy to understand the below isValid functions's formula and the recursion behind it
          for(int i = 0; i < 9; i++){

            for(int j = 0; j < 9; j++){

                if(grid[i][j] != 0){

                    if(!isValid(grid, i, j)) return 0;

                }

            }

        }

        return 1;
      

    }
    // static boolean SudokuSolver(int [][] grid){
    //      for(int i =0; i<grid.length; i++){
    //       for(int j =0; j<grid[0].length; j++){
    //           //found an empty cell, so now try filling values from 1-9 in it
    //           if(grid[i][j]==0){
    //               //filler function
    //               for(int num = 1; num<=9; num++){
    //                   //now check if the number (num) putting in grid is feasible or not
    //                   if(isValid(grid, num, i,j)){
    //                       //if it is, put it and then recur for next empty cell
    //                       grid[i][j] = num;
    //                       if(SudokuSolver(grid)){
    //                           return true;
    //                       }
    //                         //now if putting this num in this empty cell doesnt allow other empty cell in recursion
    //                         //to get filled, it would return false
    //                       else{
    //                           //and since the future call returns falls, we have to remove the current number 
    //                           // and try for nexy num+1 value and so on
    //                           grid[i][j] = 0;
    //                       }
    //                   }
    //               }
    //               //and if just in case, as said for the future call, it cant fill any number in it, it returns false to its parent caller 
    //               //indicating that the parent need to change its value in its empty cell so that the child can fit a value in its empty cell
    //               return false;
    //           }
    //       }
    //   }
    //   //at last if a call comes which doesnt have any empty cell left, then it return true to its parent 
    //   //and the parent to its parent and so on the function ends
    //   return true;
    // }
     static boolean isValid(int [][] grid, int row, int col){
        //checking for each column and row
        int num = grid[row][col];
        for(int i =0; i<9; i++){
        //row and col checking condtion if it is already filled by the number we want
            if(grid[row][i]==num && i!=col || grid[i][col]== num && i!=row) return false;
            //this condtion checks the current grid in which row and col lies
            // formula : 
            //grid row traversal : 3*(row/3) + (i/3)
            // grid col traversal : 3*(col/3) + (i % 3)
            int ogrow = (row/3)*3,ogcol = (col/3)*3;
            // if(grid[3*(row/3) + (i/3)][3*(col/3) + (i%3)]== num) return false;
            if(grid[ogrow+i/3][ogcol+i%3]==num && (ogrow+i/3) !=row && (ogrow+i%3) !=col) return false;
        }
        return true;
           
        }
         
       
    }
