//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        //okay so this aint my approach but this is the gelchod tushars approach 
        //but anyway i liked the idea he implmented so yeah cuz thats what good coders do
        //you wont be able to understand the logic immeadiately, just give it time 
        //and try implementing the solution by using stack next time slayyy
    //     long ans[] = new long [arr.length];
    //     long max [] = new long [arr.length];
    //     long maxE =Integer.MIN_VALUE;
    //   for(int i =n-1; i>=0; i--){
    //     //   maxE = Math.max(max, arr[i]);
    //     if(arr[i]>maxE){
    //         maxE = arr[i];
    //     }
    //       max[i] = maxE;
    //   }
    //   int i=0,j =0;
    //   while(i<arr.length && j<arr.length){
    //       if(arr[i] ==max[i]){
    //           ans[i] = -1;
    //           i++;
    //           j++;
    //       }
    //       else if(arr[i]<arr[j]){
    //           ans[i] = arr[j];
    //           i++;
    //           j= i;
    //       }
    //       else{
    //           j++;
    //       }
    //   }
    
    //   return ans;
     Deque<Integer> stack = new ArrayDeque<>();
        long [] ans = new long[arr.length];
        ans[arr.length-1] = -1;
        stack.push(arr.length-1);
        for(int  i =arr.length-2; i>=0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
    } 
}