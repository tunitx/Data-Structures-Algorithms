//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] ShortestDistance(int[][] m)
    {
        // Code here
        int n = m[0].length;
         int vis [][] = new int[n][n];
         
       
        String res = "";
        // ArrayList<String> ans = new ArrayList<>();
        
       if(rmp(0, 0, res, m, n, vis)) return vis;
    //   return vis;
        return new int [][]{{-1}};
    }
     static boolean rmp(int i , int j, String res, int [][] mat, int n, int vis [][]){
        if(i== n-1 && j== n-1){
                // ans.add(res);
                vis[i][j] = 1;
                return true;
            }
        if(!checkForSafeCell(i, j, mat, vis, n)){
            //base condition to check if we have reached the destination ie mat[n-1][j-1]( last cell)
           
            
            vis[i][j] = 1;
            int d = mat[i][j];
            boolean check = false;
            for(int curr =1 ; curr<=d; curr++){
                
                if( rmp(i, j+curr, res + 'R',  mat, n, vis)) return true;
                 if( rmp(i+ curr, j, res + 'D', mat, n, vis)) return true;
                //   return;
            }
            vis[i][j] = 0;
            // rmp(i-1, j, res + 'U', ans, mat, n, vis);
           
            // rmp(i, j-1, res + 'L', ans, mat, n, vis);
           
        }
        return false;
    }
    static boolean   checkForSafeCell(int i, int j, int [][] mat, int [][] vis, int n ){
        return ( i>=n || j>=n  || mat[i][j]==0);
    }
}