//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String str)
    {
        // your code here 
        //inspired from check the paranthesis question
        //the last return line is just eh, eh, i dont understand it either, its just some mathematical computation
        // date : 3 march 2023
         Stack<Character> stack = new Stack<>();
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i)=='{'){
                stack.push(str.charAt(i));
            }
            else {
                if(!stack.isEmpty() && stack.peek() =='{'){
                    stack.pop();
                }
                else {
                    stack.push(str.charAt(i));
                }
            }
        }
        int max = 0;
        int a = 0;
        int b =0;
        while(!stack.isEmpty()){
            char ch = stack.pop();
            if(ch=='{') a++;
            else b++;
        }
        if(a>b){
            max = a-b;
        }
        else{
            max= b-a;
        }
        if(max%2==0){
            return ((a+1)/2) + ((b+1)/2);
        }
        return -1;
    }
}