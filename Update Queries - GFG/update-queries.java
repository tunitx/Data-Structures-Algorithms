//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int Q = Integer.parseInt(str[1]);
			int [][] U = new int[Q][3];
			int i = 0;
			while(i < Q) {
				str = br.readLine().trim().split(" ");
				U[i][0] = Integer.parseInt(str[0]);
				U[i][1] = Integer.parseInt(str[1]);
				U[i][2] = Integer.parseInt(str[2]);
				i++;
			}
			Solution obj = new Solution();
			int [] arr = obj.updateQuery(N, Q, U);
			for(int j: arr) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] updateQuery(int N, int Q, int [][]U){
        //Write your code here
        //Write your code here
        //bhenchod who tf will tell that the range l and r are 1 based indexed
        //the question isnt well explained, so the brief explanation of what all we have to perform is:
        //we are given a matrix containing 3 terms, l= left range, r = right range & x = the operand
        //we are being asked to perform Q actions on an empty array of size N(all 0s, initialyy), starting from range l and ending at range r, now the important thing is that the range 
        //is 1 based indexed, so you have to manipulate it accordingly.
        //also here we have to perform the OR (|) operation such that; a[i] = a[i]|x from l-1 to r-1 (0 based converted)
        int [] ans = new int [N];
        for (int i =0; i<Q; i++){
            int l = U[i][0];
            int r = U[i][1];
            int x = U[i][2];
            for(int j = l-1; j<r; j++){
                ans[j] = ans[j] | x;
            }
        }
        return ans;
    }
}