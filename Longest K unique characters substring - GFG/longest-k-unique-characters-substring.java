//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String str, int k) {
        // code here
        HashMap<Character, Integer> hm = new HashMap<>();
        int low =0, i =0;
        int max = Integer.MIN_VALUE;
        while(i<str.length()) {
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (hm.size() == k) {
                max = Math.max(max, i - low + 1);
            }  while(hm.size() > k)
            {
                hm.put(str.charAt(low), hm.get(str.charAt(low))-1);
                if(hm.get(str.charAt(low)) == 0)
                {
                    hm.remove(str.charAt(low));
                }
                low++;
            }
            i++;
        }
        if(hm.size()!=k){
            return -1;
        }
        return max;
    }
}