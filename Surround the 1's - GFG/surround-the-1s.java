//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] mat)
    {
        // code here
        //date : 21 aug 2023
        //O(n) time with constant extra space
        var ans = 0;
        int row[] = {-1, -1, 0, 1, 1, 1, 0, -1 };
        int col [] = {0, 1, 1, 1, 0, -1, -1 ,-1};
        for(var i =0; i<mat.length; i++){
            
            for(var j =0; j<mat[0].length; j++){
                if(mat[i][j] ==1){
                    var count =0;
                for(int k =0; k<8; k++){
                   int nr = i+ row[k];
                   int nc = j+ col[k];
                   if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && mat[nr][nc] ==0 ) count ++;
                }
               
                if(count!=0 && count %2==0) ans++;
                }
            }
            
            
        }
        return ans;
    }   
}