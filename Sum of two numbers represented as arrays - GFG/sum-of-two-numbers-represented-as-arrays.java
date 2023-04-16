//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[] a = new int[n], b = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().findSum(a, b);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    ArrayList<Integer> findSum(int a[], int b[]) {
        // code here
        boolean check = true;
        ArrayList<Integer> list = new ArrayList<>();
        int len = Math.abs(a.length-b.length);
        // int j = b.length-1;
        int carry =0;
        int max = Math.max(a.length, b.length);
        int j = Math.min(a.length, b.length)-1;
        
       if(a.length == b.length){
           for(int i =a.length-1; i>=0; i--){
               int sum = a[i] + b[i] + carry;
               carry = sum/10;
               int nd = sum%10;
               list.add(nd);
           }
       }
        if(a.length>b.length){
            check = false;
             for(int i = max-1; i>=len; i--){
            int sum = a[i]+b[j] + carry;
            carry  = sum/10;
            int nd = sum%10;
            list.add(nd);
            j--;
        }
            for(int i =len-1; i>=0; i-- ){
                int sum = a[i] + carry;
                list.add(sum%10);
                carry = sum/10;
            }
        }
         if(b.length>a.length){
            check = false;
             for(int i = max-1; i>=len; i--){
            int sum = a[j]+b[i] + carry;
            carry  = sum/10;
            int nd = sum%10;
            list.add(nd);
            j--;
        }
            for(int i =len-1; i>=0; i-- ){
                int sum = b[i] + carry;
                list.add(sum%10);
                carry = sum/10;
            }
        }
       if(carry!=0){
             list.add(carry);
       }
       
        Collections.reverse(list);
        return list;
    }
}