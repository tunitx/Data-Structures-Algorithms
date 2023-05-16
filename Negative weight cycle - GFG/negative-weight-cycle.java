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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        //date : 16th may 2023
        //bellman ford algo to find negative cycle in the graph
        //TC : O(V*E)
        int [] dist = new int[n];
        Arrays.fill(dist, (int)1e8);
        dist[0] = 0;
        //doing n-1 traversals to find the shortest path of each node from root 0
        for(int i =0; i<n-1; i++){
            for( int [] temp : edges){
                int u = temp[0];
                int v = temp[1];
                int wt = temp[2];
                if( dist[u]!= 1e8 && dist[v]>dist[u] + wt){
                    dist[v] = dist[u] + wt;
                }
                
            }
        }
        //then doing the nth traversal to check for a negative cycle
        //pls note that dist[u]!=1e8 condition isnt being used in this iteration as in n-1 traversals
        //each vertex has been assigned with its shortest path already and this nth iteration checks for 
        //negative cycle in the graph
       for( int [] temp : edges){
                int u = temp[0];
                int v = temp[1];
                int wt = temp[2];
                if(  dist[v]>dist[u] + wt){
                    return 1;
                }
            }
        return 0;
        
    }
}