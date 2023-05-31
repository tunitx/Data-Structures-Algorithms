//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        //date : 31st may 2023
        //take a glance at copy to understand the below isValid functions's formula and the recursion behind it
        
       for(int i =0; i<grid.length; i++){
           for(int j =0; j<grid[0].length; j++){
               //found an empty cell, so now try filling values from 1-9 in it
               if(grid[i][j]==0){
                   //filler function
                   for(int num = 1; num<=9; num++){
                       //now check if the number (num) putting in grid is feasible or not
                       if(isValid(grid, num, i,j)){
                           //if it is, put it and then recur for next empty cell
                           grid[i][j] = num;
                           if(SolveSudoku(grid)){
                               return true;
                           }
                            //now if putting this num in this empty cell doesnt allow other empty cell in recursion
                            //to get filled, it would return false
                           else{
                               //and since the future call returns falls, we have to remove the current number 
                               // and try for nexy num+1 value and so on
                               grid[i][j] = 0;
                           }
                       }
                   }
                   //and if just in case, as said for the future call, it cant fill any number in it, it returns false to its parent caller 
                   //indicating that the parent need to change its value in its empty cell so that the child can fit a value in its empty cell
                   return false;
               }
           }
       }
       //at last if a call comes which doesnt have any empty cell left, then it return true to its parent 
       //and the parent to its parent and so on the function ends
       return true;
    }
    
    static boolean isValid(int [][] grid, int num, int row, int col){
        //checking for each column and row
        for(int i =0; i<9; i++){
        //row and col checking condtion if it is already filled by the number we want
            if(grid[row][i]==num || grid[i][col]== num) return false;
            //this condtion checks the current grid in which row and col lies
            // formula : 
            //grid row traversal : 3*(row/3) + (i/3)
            // grid col traversal : 3*(col/3) + (i % 3)
            if(grid[3*(row/3) + (i/3)][3*(col/3) + (i%3)]== num) return false;
           
        }
          return true;
       
    }
    
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i =0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}