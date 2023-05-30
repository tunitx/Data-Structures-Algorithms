//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] intervals = IntMatrix.input(br, n, 2);
            
            Solution obj = new Solution();
            int res = obj.overlap(n, intervals);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int overlap(int N, int[][] intervals) {
        // code here
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> a-b);
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int res =0;
        for(int [] arr : intervals){
            q.add(arr[1]);
            while(arr[0]> q.peek()){
                q.poll();
            }
            res = Math.max(res, q.size());
        }
        return res;
    }
}
class pair{
    int s, e;
    pair(int s, int e){
        this.s = s;
        this.e = e;
    }
}
        
