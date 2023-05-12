//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean vis [] = new boolean[V];
        for(int i =0; i<V; i++){
            if(!vis[i]) {
                dfs(i, adj, vis, stack);
            }
        }
        
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        
        for(int i =0; i<V; i++){
            transpose.add(new ArrayList<Integer>());
        }
        
        for(int i =0; i<V; i++){
            for(int j : adj.get(i)){
                transpose.get(j).add(i);
            }
        }
        int count =0;
        Arrays.fill(vis, false);
        while(!stack.isEmpty()){
            int node = stack.pop();
            
            if(!vis[node]){
                count ++;
                dfs2(node , transpose, vis);
            }
        }
        return count;
    }
    public void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean [] vis,  ArrayDeque<Integer> st){
        vis[s] = true;
        
        for(int i : adj.get(s)){
            if(!vis[i]){
                dfs(i, adj, vis, st);
            }
        }
        st.push(s);
    }
    public void dfs2(int s, ArrayList<ArrayList<Integer>> adj, boolean [] vis){
        vis[s] = true;
        
        for(int i : adj.get(s)){
            if(!vis[i]){
                dfs2(i, adj, vis);
            }
        }
    }
}
