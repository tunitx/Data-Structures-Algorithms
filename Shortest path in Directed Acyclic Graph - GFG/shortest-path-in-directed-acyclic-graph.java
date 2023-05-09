//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
// class Solution {

// 	public int[] shortestPath(int N,int M, int[][] edges) {
// 		//Code here
//         ArrayList<ArrayList<pair>> adj = new ArrayList<ArrayList<pair>>();
//         for(int i = 0; i < N ;i++) {
//             adj.add(new ArrayList<>());
//         }

//         for(int i = 0; i < M; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             int wt = edges[i][2];
//             adj.get(u).add(new pair(v, wt));
           
// 	}
// 	ArrayDeque<Integer> stack = new ArrayDeque<>();
// 	int V = adj.size();
// 	boolean v[] = new boolean[N];
// 	for(int i =0; i<N; i++)
// 	    if(!v[i]) dfs(i, adj, v, stack);
// 	int k =0;
// 	int [] ans = new int[V];
// 	  for(int i=0;i<N;i++){   
//             ans[i] = (int)1e9;
//         }
// 	ans[0] = 0;
// 	while(!stack.isEmpty()){
// 	   int node = stack.peek();
// 	   stack.pop();
	   
// 	   for(int i=0;i<adj.get(node).size();i++){
//                 int u = adj.get(node).get(i).v;
//                 int wt = adj.get(node).get(i).wt;
                
//                 if(ans[node]+wt<ans[u])
//                     ans[u] = ans[node]+wt;
//             }
// 	}
// 	for(int i =0; i<N; i++){
// 	    if(ans[i] == (int)1e9) 
// 	        ans[i] = -1;
// 	}
// 	return ans;	
//  }
//  static void dfs(int s, ArrayList<ArrayList<pair>> adj, boolean [] v, ArrayDeque<Integer> stack){
//      v[s] = true;
     
//      for(int i=0;i<adj.get(s).size();i++){
//             int u = adj.get(s).get(i).v;
//             if(!v[u])
//                 dfs(u, adj, v, stack);
//         }
//     stack.add(s);
//  }

// }
// class pair{
//     int v;
//     int wt;
//     pair(int v, int wt){
//         this.v = v;
//         this.wt = wt;
//     }
// }
class Pair{
    int u;
    int wt;
    
    public Pair(int u, int wt){
        this.u = u;
        this.wt = wt;
    }
}


class Solution {
    
    public void DFS(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int u = adj.get(node).get(i).u;
            if(!vis[u])
                DFS(u, adj, vis, st);
        }
        st.add(node);
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<N;i++){
            ArrayList<Pair> A = new ArrayList<Pair>();
            adj.add(A);
        }
        
        for(int i=0;i<M;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(v, wt));
        }
        
        //Toposort using DFS
        
        boolean[] vis = new boolean[N];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<N;i++){
            if(!vis[i])
                DFS(i, adj, vis, st);
        }
        
        int[] dist = new int[N];
        for(int i=0;i<N;i++){   
            dist[i] = (int)1e9;
        }
        dist[0] = 0; // as dist[0] = 0 (src(0))
        //System.out.println(st);
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            
            for(int i=0;i<adj.get(node).size();i++){
                int u = adj.get(node).get(i).u;
                int wt = adj.get(node).get(i).wt;
                
                if(dist[node]+wt<dist[u])
                    dist[u] = dist[node]+wt;
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i]==(int)1e9)
                dist[i] = -1;
        }
        return dist;
    }
}

