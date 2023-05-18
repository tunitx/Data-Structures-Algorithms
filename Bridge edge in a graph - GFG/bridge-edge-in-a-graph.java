//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{  static int timer = 0;
    static int ans;
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean vis [] = new boolean[V];
        int tin [] = new int [V];
        int low [ ]= new int [V];
        int parent = -1, s =0;
        ans = 0;
        for(int i =0; i<V; i++){
            if(!vis[i]){
                dfs(i, parent, adj, vis, low, tin, c, d);
            }
        }
        return ans;
    }
    static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean vis [], int [] low, int [] tin, int c, int d){
        vis[node] = true;
        low[node] = tin[node] = timer;
        timer ++;
        
        for(int child : adj.get(node)){
            if(child == parent) continue;
            
            if(!vis[child]){
                dfs(child, node , adj, vis, low, tin, c, d);
                low[node ] = Math.min(low[node], low[child]);
                if( ((child == d && node == c )||(child == c && node == d)) && low[child]>tin[node]){
                    ans = 1;
                }
            }
            else{
                low[node] = Math.min(low[node], low[child]);
            }
        }
    }
}