//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String str) {
        // code here
          Stack<Integer> stack = new Stack<>();
        int res =0;
        stack.push(-1);
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='('){
                stack.push(i);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    res = Math.max(res, i-stack.peek());
                }
                else{
                    stack.push(i);
                }
            }
        }
        return res;
    }
};