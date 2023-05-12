//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        //date : 12th may 2023
        //different than sandeep jains algorithm as it was based on simplest implmentation
        //this is second best implementation using priority queue
        //little bit similar to prims algo, refer to this link and notes in copy while revising : 
        // link : https://youtu.be/V6H1qAeB-l4
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)-> x.wt-y.wt);
        int [] dist = new int [V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        pq.add(new pair(0,S));
        
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int node = p.node;
            for(ArrayList<Integer> temp : adj.get(node)){
               int n = temp.get(0);
               int w = temp.get(1);
               if(dist[n]> w + p.wt){
                   dist[n] = w + p.wt;
                   pq.add(new pair(dist[n], n));
               }
            }
        }
        return dist;
    }
}
class pair{
    int node, wt;
    pair(int wt, int node){
        this.wt = wt;
        this.node = node;
    }
}

