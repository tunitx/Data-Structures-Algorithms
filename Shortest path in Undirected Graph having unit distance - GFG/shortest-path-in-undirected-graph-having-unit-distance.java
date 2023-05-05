//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int V = adj.size();
          Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[V];
        int [] ans  = new int [V];
         Arrays.fill(ans, -1);
        ans[src] = 0;
        q.add(src);
        visited[src] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : adj.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    ans[i] = ans[curr]+1;
                }
            }
        }
        // System.out.println(adj.get(2).get(3));
        return ans;
        
    }
 
    
}