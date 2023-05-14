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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
       List<String> list = new ArrayList<>();
        String str = "";
       helper(0, s, list, str);
       Collections.sort(list);
       return list;
    }
    public void helper(int i, String s, List<String> list, String str){
       if(i==s.length()) {
            if(str.length()>0) list.add(str);
            return;
       }
           
            
        
        helper(i+1, s, list, str + s.charAt(i));
        helper(i+1, s, list, str);
    }
}