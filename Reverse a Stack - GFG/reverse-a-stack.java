//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         }
         out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        // int [] arr = new int[s.size()];
        ArrayList<Integer> list = new ArrayList<>();
        int i =0,j=0;
        reverseTheStack(s, list,i ,j);
    }
    static void reverseTheStack(Stack<Integer> stack , ArrayList<Integer> list, int i, int j){
        if(stack.isEmpty()){
            // i=0;
            return;
        }
        list.add(stack.pop());
        reverseTheStack(stack, list, i++,j);
        stack.push(list.get(0));
        list.remove(0);
    
    }
}