//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    //Function to insert heap.
 private static PriorityQueue<Integer> g;
    private static PriorityQueue<Integer> s;
    
    public Solution(){
        g= new PriorityQueue<>();
        s = new PriorityQueue<>(Collections.reverseOrder());
    }
    public static void insertHeap(int x)
    {
        // add your code here
        if(s.isEmpty() || x<=s.peek() ){
            s.add(x);
        }
        else{
            g.add(x);
        }
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
      // add your code here
      if(s.size()> g.size()+1){
          g.add(s.poll());
      }
      else if( g.size()>s.size()){
          s.add(g.poll());
      }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(s.size() == g.size()){
            return (s.peek() + g.peek())/2.0;
        }
        else{
            return s.peek();
        }
        
        
    }
    
}
