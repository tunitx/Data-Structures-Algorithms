//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String par)
    {
        // add your code here
         Deque<Character> stack = new ArrayDeque<>();
        for(int i =0; i<par.length(); i++){
            char s = par.charAt(i);
            if(s=='(' || s=='{' || s == '['){
                stack.push(s);
            }
            else{

                if(stack.isEmpty()){
                    return false;
                }

                else if((stack.peek() == '{' && s=='}') || (stack.peek()=='[' && s==']') || (stack.peek()=='('&& s==')')){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
