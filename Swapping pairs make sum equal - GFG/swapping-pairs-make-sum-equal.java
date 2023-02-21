//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        Arrays.sort(A);
        Arrays.sort(B);
        long sum1 =0, sum2 = 0, diff =0;
        for(int i =0; i<A.length; i++){
            sum1+= A[i];
        }
        for(int i =0; i<B.length; i++){
            sum2 += B[i];
        }
        if(sum1-sum2==0){
            return 1;
        }
        // if(n>m){
        //      diff = sum1-sum2;
        // }
        // else{
        //     diff = sum2-sum1;
        // }
         if ((sum1 - sum2) % 2 != 0) 
        diff =0; 
        else{
       diff = ((sum1 - sum2) / 2);
             } 
        if(diff ==0){
            return -1;
        }
        int i=0 , j =0;
        while(i<A.length && j<B.length){
            long sum = A[i] - B[j];
            if(sum== diff){
                return 1;
            }
            else if(sum<diff){
                    i++;
            }
             else{
                    j++;
                }
          
        }
        return -1;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int m =Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a,n,b,m);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends