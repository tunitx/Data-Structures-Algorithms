//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j==ptr.get(i).size()-1)
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.  
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        boolean [] v = new boolean[V];
        
        for(int i =0; i<V; i++){
            if(!v[i]){
                dfs1(i, adj, st, v);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        
        for(int i =0; i<V; i++){
            transpose.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<V; i++){
            for(int j : adj.get(i)){
                transpose.get(j).add(i);
            }
        }
        
        Arrays.fill(v, false);
        
        while(!st.isEmpty()){
            int node = st.pop();
            
            if(!v[node]){
                ArrayList<Integer> temp = new ArrayList<>();
                dfs2(node, transpose, temp, v);
                Collections.sort(temp);
                ans.add(temp);
            }
        }
        Collections.sort(ans, (x,y)-> x.get(0)-y.get(0));
        return ans;
    }
    public static void dfs1(int s, ArrayList<ArrayList<Integer>> adj, ArrayDeque<Integer> st, boolean [] v){
        v[s]  = true;
        
        for(int i :adj.get(s)){
            if(!v[i]){
                dfs1(i, adj, st, v);
            }
        }
        st.push(s);
    }
    public static void dfs2(int s, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> temp, boolean [] v){
        v[s] = true;
         temp.add(s);
        for(int i : adj.get(s)){
            if(!v[i]){
                dfs2(i, adj, temp, v);
            }
        }
    }
}