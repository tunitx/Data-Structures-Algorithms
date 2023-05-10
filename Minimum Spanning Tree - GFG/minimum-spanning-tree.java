//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int e[][]){
	    // Code Here. 
	    ArrayList<ArrayList<pair>> adj = new ArrayList<ArrayList<pair>>();
	    for(int i =0; i<V; i++) {
	        adj.add(new ArrayList<pair>());
	    }
	    for(int i =0; i<e.length; i++){
	       adj.get(e[i][0]).add( new pair(e[i][1], e[i][2]));
	       adj.get(e[i][1]).add(new pair(e[i][0], e[i][2]));
	    }
	    PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y)-> x.wt-y.wt);
	    boolean vis [] = new boolean[V];
	    int res  =0;
	    pq.add(new pair(0,0));
	    while(!pq.isEmpty()){
	        pair p = pq.poll();
	        int node = p.ver;
	        int wt = p.wt;
	        if(vis[node]) continue;
	        vis[node] = true;
	        res +=wt;
	        
	        for(pair ed : adj.get(node)){
	            int n = ed.ver;
	            if(!vis[n]){
	                pq.add(ed);
	            }
	        }
	    }
	    return res;
	    
	}
}
class pair {
    int ver;
    int wt;
    pair(int ver, int wt){
        this.ver = ver;
        this.wt = wt;
    }
}