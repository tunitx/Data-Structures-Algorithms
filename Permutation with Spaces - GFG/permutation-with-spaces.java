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
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        String curr = "";
        ArrayList<String> ans = new ArrayList<>();
       curr+= S.charAt(0);
        helper(1, curr, S, ans);
        // Collections.sort(ans);
        return ans;
    }
    void helper(int i, String curr, String str, ArrayList<String> ans){
        //base condition
        if(i==str.length()){
           
                ans.add(curr);
            
            
            return;
        }
        
       
        helper(i+1, curr+ " "+str.charAt(i), str, ans);
        helper(i+1, curr+str.charAt(i), str, ans);
    }
    
}