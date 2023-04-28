//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(st[0]);
            int K = Integer.parseInt(st[1]);
            String st1[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.toyCount(N, K, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int toyCount(int N, int K, int arr[])
    {
        // code here
        //date : 28th april 2023
        // ! seccond approach to this solution can be by implementing a priority queue(min heap)
        // we first make the PQ and then pop the topmost item as long as the item < sum and if it is,
        // then we update the sum as sum - pq.poll(). Also, we can further optimise this solution by
        // not making an external PQ and instead buliding a heap in the OG array itself just like we 
        //did in heap sort algorithm ie, creating a buildheap fn and a minHeapify fn as well.
        Arrays.sort(arr);
        int count =0;
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            if(sum+arr[i]<=K){
                count++;
                sum+=arr[i];
            }
            else{
                return count;
            }
        }
        return count;
    }
}