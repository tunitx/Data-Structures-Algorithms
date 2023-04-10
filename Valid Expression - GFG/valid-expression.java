//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String par) 
    { 
        // code here
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