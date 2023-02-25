//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        // int i =0, j=0;
        // boolean check = false;
        // int sLen = S.length(),tLen=T.length();
        // while(i<S.length() && j<T.length()){
        //     if(Character.isDigit(T.charAt(j))){
        //         i = i+Character.getNumericValue(T.charAt(j));
        //         j++;
        //     }
        //     if(i==sLen && j==tLen)
        // 		return 1;
        // 	if(i>=sLen|| j>=tLen)
        // 		return 0;
        //     else if(S.charAt(i)!=T.charAt(j)){
        //         return 0;
        //     }
        //     else{
        //         check = true;
        //         i++;
        //         j++;
        //     }
        // }
        // if(j!=tLen)
        // 	return 0;
        // if(i!=S.length()){
        //     return 0;
        // }
        // // if(j!=T.length()){
        // //     return 0;
        // // }
        //  return 1;
        int sLen = S.length(),tLen=T.length();
    	if(sLen==0 || T.length()==0) {
    		return 0;
    	}
    	int i=0,j=0;
        char ch2;//= T.charAt(j);
        char ch1;//=S.charAt(i);
        while(j<tLen&&i<sLen){
        	int jumpTo = 0;
        	while(j<tLen && T.charAt(j)<='9') {
        		ch2 = T.charAt(j++);
        		jumpTo= jumpTo*10 +(ch2-'0');
        	}
        	i+=jumpTo;
        	if(i==sLen && j==tLen) return 1;
        	if(i>=sLen|| j>=tLen) return 0;
        	ch1 = S.charAt(i);
        	ch2 = T.charAt(j);
        	if(ch1!=ch2) return 0;
        	i++;
        	j++;
        }
        if(i!=sLen) return 0;
         if(j!=tLen)return 0;
            
        return 1;
       
    }
}