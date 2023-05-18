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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    int timer;
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        timer = 1;
         int tin [] = new int [V];
        int low [] = new int [V];
        int mark[] = new int [V];
        boolean vis [] = new boolean[V];
        int parent = -1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i =0; i<V; i++){
            if(!vis[i]){
                dfs(i, parent, tin, low, vis, adj, ans);
            }
        }
        if(ans.size() == 0){
            return new int [] {-1};
        }
        Collections.sort(ans);
        int res [] = new int [ans.size()];
        int j =0;
        for(int i : ans){
            res[j++] = i;
        }
        return res;
    }
    void dfs(int node, int parent, int [] tin, int [] low, boolean [] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer ++;
        int count = 0;
        for(int child : adj.get(node)){
            if(child == parent) continue;
            
            if(!vis[child]){
                dfs(child, node, tin, low, vis, adj, ans);
                low[node] = Math.min(low[node], low[child]);
                if(low[child]>=tin[node]  && parent !=-1){
                    //  System.out.println("hi");
                   if(!ans.contains(node)){
                      
                       ans.add(node);
                   }
                }
                count++;
            }
            else{
                low[node] = Math.min(low[node], tin[child]);
            }
            if(count>1 && parent ==-1){
                if(!ans.contains(node)){
                    ans.add(node);
                }
            }
        }
    }
}