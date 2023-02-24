//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i<arr.length; i++){
            int index = arr[i]%n;
            arr[index] +=n;
        }
        for(int i =0; i<arr.length; i++){
            if(arr[i]/n>=2){
                list.add(i);
            }
            
        }
        //aah man onli 14 fcking testcases but TLE
        //accha solution hai, might come in hand in future
        //date : 24 feb 2023
        // int i=0;
        // while(i<arr.length){
        //     int correct_index = arr[i];
        //     if(arr[correct_index]!=arr[i]){
        //         int temp = arr[correct_index];
        //         arr[correct_index] = arr[i];
        //         arr[i] = temp;
        //     }
        //     else{
        //         i++;
        //     }
        // }
        // int j =0;
        // boolean emptyCheck = true;
        // while(j<arr.length){
        //     if(j!=arr[j] && !list.contains(arr[j])){
        //         emptyCheck = false;
        //         list.add(arr[j]);
        //     }
        //     j++;
        // }
        // if(emptyCheck){
        //     list.add(-1);
        //     return list;
        // }
        // Collections.sort(list);
        if(list.size()==0){
            list.add(-1);
        }
        return list;
    }
}
