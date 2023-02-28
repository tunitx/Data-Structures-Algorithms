//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String str){
         int [] ch = new int[256];
        int low =0, i =0;
        int res = Integer.MIN_VALUE;
        while(i<str.length()){
            ch[str.charAt(i)]++;
            while(ch[str.charAt(i)]>1 && low<i){
                ch[str.charAt(low)]--;
                low++;
            }
            res = Math.max(res , i-low+1);
            i++;
        }
        return res;
    }
}