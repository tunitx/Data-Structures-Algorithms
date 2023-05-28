//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> ans = new ArrayList<>();
        helper(0, S, ans);
        Collections.sort(ans);
        return ans;
    }
    void helper(int index, String str, ArrayList<String> ans){
        //base condtion
        if(index == str.length()){
            if(!ans.contains(str)){
                ans.add(str);
            }
            return;
        }
        
        for(int curr = index; curr<str.length(); curr++){
            str = swap(curr, index, str);
            helper(index+1, str, ans);
           str =  swap(curr, index, str);
        }
        return;
    }
    
    String swap(int i, int j, String str){
        char [] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
	   
}
