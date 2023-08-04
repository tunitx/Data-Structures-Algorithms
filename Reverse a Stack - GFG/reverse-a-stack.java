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
        //🤣🤣🤣 bruh recursive solution likhne mein gaand toh lagti hai ngl
        //date : 3 March 2023
        int [] arr = new int[s.size()];
        int i =0;
        reverseTheStack(s, arr, i);
    }
    public static int reverseTheStack(Stack<Integer>stack,int [] arr, int i){
        if(stack.isEmpty()){
            i=0;
//            System.out.println("im");
//            System.out.println(i);
            return i;
        }
        arr[i] = stack.pop();
//         System.out.println(arr[i]);
         i++;
        int k = reverseTheStack(stack, arr, i);
//         System.out.println(arr[i]);
        stack.push(arr[k]);
        //  System.out.println(stack.peek());
         return k+1;
    }
}