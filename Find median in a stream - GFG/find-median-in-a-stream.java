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


// class Solution
// {
//     //Function to insert heap.
//   static  PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
//   static  PriorityQueue<Integer> g = new PriorityQueue<>();
//     public static void insertHeap(int x)
//     {
//         // add your code here
//         if(s.isEmpty() || x<=s.peek() ){
//             s.add(x);
//         }
//         else{
//             g.add(x);
//         }
//         balanceHeaps();
//     }
    
//     //Function to balance heaps.
//     public static void balanceHeaps()
//     {
//       // add your code here
//       if(s.size()> g.size()){
//           g.add(s.poll());
//       }
//       else{
//           s.add(g.poll());
//       }
//     }
    
//     //Function to return Median.
//     public static double getMedian()
//     {
//         // add your code here
//         if(s.size() == g.size()){
//             return (s.peek() + g.peek())/2.0;
//         }
//         return s.peek();
        
//     }
    
// }
class Solution
{
    private static PriorityQueue<Integer> min;
    private static PriorityQueue<Integer> max;
    
    public Solution(){
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public static void insertHeap(int x)
    {
        if(max.isEmpty() || max.peek() >= x){
            max.add(x);
        }else{
            min.add(x);
        }
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       if(max.size() > min.size() +1){
           min.add(max.poll());
       }
       else if(min.size() > max.size()){
            max.add(min.poll());
       }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        if(max.size() == min.size())
            return (max.peek() + min.peek())/2.0;
        else
            return max.peek();
    }
    
}