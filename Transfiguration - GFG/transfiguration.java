//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transfigure (A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transfigure (String A, String B)
    {
    	// Your code goes here.
    
    // 	HashMap<Character, Integer> hm1 = new HashMap<>();
    // 	HashMap<Character, Integer> hm2 = new HashMap<>();
    	if(A.length()!=B.length()){
    	    return -1;
    	}
       int [] hm1 = new int [256];
       int [] hm2 = new int [256];
    	for(int i =0; i<A.length(); i++){
    	   // hm1.put(A.charAt(i), hm1.getOrDefault(A.charAt(i), 0)+1);
    	   //  hm2.put(B.charAt(i), hm2.getOrDefault(B.charAt(i), 0)+1);
    	   hm1[A.charAt(i)]++;
    	   hm2[B.charAt(i)]++;
    	}
    // for(Map.Entry<Character, Integer> e : hm1.entrySet()){
    //         if(!hm2.containsKey(e.getKey())){
    //             return -1;
    //         }
    //         else{
    //             if(hm2.get(e.getKey())!=e.getValue()){
    //                 return -1;
    //             }
    //         }
    //     }
    for(int i =0; i<hm1.length; i++){
        if(hm1[i]!=hm2[i]){
            return -1;
        }
    }
        int i = A.length()-1, j = B.length()-1, count =0;
        while(i>=0 && j>=0){
            if(A.charAt(i)==B.charAt(j)){
                i--;
                j--;
            }
            else{
                i--;
                count++;
            }
        }
        
        return count;
    
    }
}