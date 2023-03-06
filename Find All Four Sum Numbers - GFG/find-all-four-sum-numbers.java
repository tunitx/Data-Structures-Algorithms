//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // int i =0, j = arr.length-1;
        // while(i<j){
        //     int outerSum = (arr[i]+arr[j]);
        //     int k1 = i+1;
        //     int k2 = j-1;
        //     while(k1<k2){
        //         int diff =(arr[k1] - arr[k2]) ;
        //         int innerSum = (k- (diff));
        //         if(innerSum == outerSum){
        //             // System.out.println("yes");
        //             ArrayList<Integer> l = new ArrayList<>();
        //             l.add(arr[i]);
        //             l.add(arr[j]);
        //             l.add(arr[k1]);
        //             l.add(arr[k2]);
        //             Collections.sort(l);
        //             list.add(l);
        //             k1++;
        //             k2--;
        //         }
        //         else if(innerSum>outerSum){
        //         k1++;
                       
        //             }
                
        //         else{
        //             k2--;
        //         }
        //     }
        //     i++;
        //     j--;
        // }
        LinkedHashSet<ArrayList<Integer>> set = new LinkedHashSet<>();
        for(int i =0; i<arr.length-3; i++){
            for(int j = i+1; j<arr.length-2; j++){
                int left = j+1;
                int right = arr.length-1;
                while(left<right){
                    long sum = (long)arr[i]+ (long)arr[j]+ (long)arr[left] + (long)arr[right];
                    if(sum==k){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[left]);
                        list.add(arr[right]);
                        left++;
                        right--;
                        set.add(list);
                    }
                    else if(sum<k){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(set);
        return ans;
    }
}