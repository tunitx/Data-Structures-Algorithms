//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int N, int target){
        // code here
        int sum =0;
        int start =0;
        int end = 0;
        int count = 0;
        while(end<N){
            sum += arr[end];
            if(sum==target){
                break;
            }
            end++;
        }
        if(sum<target ){
            return 0;
        }
        count++;
        for(end = end+1; end<N; end++){
           if(arr[end]==1){
               while(arr[start]==0 && start<end){
                   count++;
                   start++;
               }
               sum--;
               start++;
               count++;
               sum+=arr[end];
               
           }
           else{
               int i = start;
               while(arr[i] ==0){
                   i++;
                   count++;
               }
               count++;
           }
        }
        // end--;
          while(start<end&&arr[start]!=1){

            if(sum==target){

                count++;

            }

            start++;

        }
            // while(start<end && arr[start]!=1){
            //   if(sum==target){
            //       count++;
            //   }
            //   start++;
            // }
            return count;
    
    }
}
