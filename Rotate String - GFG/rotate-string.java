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
            String inp[] = read.readLine().split(" ");
            int N = Integer.parseInt(inp[0]);
            int Q = Integer.parseInt(inp[1]);
            String S = read.readLine();
            int Q1[] = new int[Q];
            int Q2[] = new int[Q];
            for (int i = 0; i < Q; i++) {
                String s[] = read.readLine().split(" ");
                Q1[i] = Integer.parseInt(s[0]);
                Q2[i] = Integer.parseInt(s[1]);
            }
            Solution ob = new Solution();
            ArrayList<Character> ans = ob.StringQuery(N, Q, S, Q1, Q2);
            for (char u : ans) System.out.println(u);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Character> StringQuery(int N, int Q, String S, int Q1[],
                                            int Q2[]) {
        // code here
        //lodu panti gfg ki
        // sahi solution hai bc gaand marao
        ArrayList<Character> list = new ArrayList<>();
        // for(int i =0; i<Q; i++){
        //     if(Q1[i]==1){
        //         int idx = (S.length()-Q2[i])%N;
        //         if(idx<=0){
        //             idx = Math.abs(S.length()+idx)%N;
        //         }
        //         S = S.substring(idx, S.length()) + S.substring(0, idx);
        //     }
        //     else{
        //         list.add(S.charAt(Q2[i]));
        //     }
        // }
        int countRotated = 0;
        
        
        for(int i = 0; i < Q; i++){
            if(Q1[i] == 1){
                Q2[i] %= N;
                countRotated += Q2[i];
            }else{
                int index = (N - (countRotated%N) + Q2[i]) % N;
                list.add(S.charAt(index));
            }
        }
        return list;
    }
}