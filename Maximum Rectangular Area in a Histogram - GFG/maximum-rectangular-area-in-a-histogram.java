//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
         Deque<Integer> stack = new ArrayDeque<>();
        long ans = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            long curr = 0;
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                int popped = stack.pop();
                curr = arr[popped]*(stack.isEmpty()?i:(i-stack.peek()-1));
                ans = Math.max(ans, curr);
            }
            stack.push(i);
        }
        // long n = arr.length;
        long curr = 0;
        while(!stack.isEmpty()){
            int popped = stack.pop();
            curr = arr[popped]*(stack.isEmpty()?n:n-stack.peek()-1);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
        
}



