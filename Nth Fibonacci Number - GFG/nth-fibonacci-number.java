//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

//User function Template for Java
class Solution {
//   static long [] dp;
    static long nthFibonacci(long n){
        // code here
        // long prev1 = 0;
        // long prev2 = 1;
       
        // for(int i =2; i<=n; i++){
        //     long curr = (prev1+prev2)%1000000007;
        //     prev1 = prev2;
        //     prev2 = curr;
        // }
        // return prev2;
        var dp = new long [(int)n+1];
        Arrays.fill(dp, -1);
        return findNthFib( n, dp);
        
    }
    static long findNthFib(long n, long [] dp ){
        if(dp[(int)n] ==-1){
            long res;
            if(n==0 || n==1) res = n;
            else res = findNthFib(n-1, dp) + findNthFib(n-2, dp);
            dp[(int)n] = res%1000000007;
        }
        return dp[(int)n];
    }
}