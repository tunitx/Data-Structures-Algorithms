//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coin[], int N, int sum) {
        // code here.
         Arrays.sort(coin);

        long [][] mat = new long[coin.length][sum+1];
        for(int i =1; i<=sum; i++){
            if(i%coin[0]==0){
                mat[0][i]=1;
            }
            else{
                mat[0][i]= 0;
            }
        }
        mat[0][0] =1;
        for(int i =1; i<coin.length; i++){
            mat[i][0] = 1;
            for(int j =0; j<=sum; j++){
                if(coin[i]>j){
                    mat[i][j] = mat[i-1][j];
                }
                else{
                    mat[i][j] = mat[i-1][j] +mat[i][j-coin[i]];
                }
            }

        }
        return mat[coin.length-1][sum];
    }
}