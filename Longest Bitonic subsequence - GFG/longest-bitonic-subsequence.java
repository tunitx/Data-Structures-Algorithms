//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        var lis = new int[nums.length];
        var max = 1;
        lis[0] = 1;
        for(int i =1; i<nums.length; i++){
            lis[i] =1;
            for(int j =0; j<i; j++){
                if(nums[j]<nums[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
            max = Math.max(max, lis[i]);
        }
        var lds = new int [nums.length];
        
        lds[nums.length-1] =1;
        for(int i =nums.length-2; i>=0; i--){
            lds[i] =1;
            for(int j =nums.length-1; j>i; j--){
                if(nums[j]<nums[i]){
                    lds[i] = Math.max(lds[i], lds[j]+1);
                }
            }
           
        }
        for(int i =0; i<nums.length; i++){
            max = Math.max(max, lis[i]+lds[i]-1);
        }
        return max ;
    }
}