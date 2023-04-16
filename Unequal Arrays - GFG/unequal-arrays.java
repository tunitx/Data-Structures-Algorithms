//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        long count = 0;
        int n =2;
    ArrayList<ArrayList<Integer> > a = 
                  new ArrayList<ArrayList<Integer> >(n);
  
       ArrayList<ArrayList<Integer> > b = 
                  new ArrayList<ArrayList<Integer> >(n);
  
         for(int i=0;i<2;i++){
           a.add(new ArrayList<>());
           b.add(new ArrayList<>());
        }
         int sum1 =0;
         int sum2 =0;
         for(int i =0; i<A.length; i++){
             sum1+=A[i];
             sum2+=B[i];
             a.get(Math.abs(A[i])%2).add(A[i]);
             b.get(Math.abs(B[i])%2).add(B[i]);
         }
         int diff = sum1 -sum2;
         if(diff!=0 || a.get(0).size()!=b.get(0).size() || a.get(1).size()!=b.get(1).size()){
             return -1;
         }
         for(int i=0; i<2; i++){
             Collections.sort(a.get(i));
             Collections.sort(b.get(i));
             for(int j =0; j<a.get(i).size(); j++){
                 count += (Math.abs(a.get(i).get(j) - b.get(i).get(j)))/2;
             }
         }
         return count/2;
    
    }
}
        
