//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
         for(int i =0; i<arr.length; i++ ){
           if(arr[i]>0){
               stack.push(arr[i]);
           }
           else{
               
          
            while (!stack.isEmpty() && arr[i]<0 && stack.peek()>0 && stack.peek()<Math.abs(arr[i]) ){
               stack.pop();
            }
            if(stack.isEmpty() || stack.peek()<0){
                stack.push(arr[i]);
            }
            else if (arr[i]+stack.peek() ==0){
                stack.pop();
            }
           }
           
            
        }
        
        int n = stack.size();
        int [] ans = new int [n];
        for(int i=n-1; i>=0; i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
