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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] nums, int n) {
        // code here
        // int n = nums.length;
        //date : 2nd june 2023
        //not done by myself
        List<Integer> counts = new ArrayList<>();
        int[] smallerCounts = new int[n];
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }

        mergeSort(pairs, smallerCounts);

        // for (int count : smallerCounts) {
        //     counts.add(count);
        // }

        return smallerCounts;
    }
    private static void mergeSort(Pair[] pairs, int[] smallerCounts) {
        if (pairs.length <= 1) {
            return;
        }

        int mid = pairs.length / 2;
        Pair[] left = new Pair[mid];
        Pair[] right = new Pair[pairs.length - mid];

        System.arraycopy(pairs, 0, left, 0, mid);
        System.arraycopy(pairs, mid, right, 0, pairs.length - mid);

        mergeSort(left, smallerCounts);
        mergeSort(right, smallerCounts);

        merge(left, right, pairs, smallerCounts);
    }
     private static void merge(Pair[] left, Pair[] right, Pair[] merged, int[] smallerCounts) {
        int i = 0, j = 0, k = 0;
        int count = 0;

        while (i < left.length && j < right.length) {
            if (left[i].value <= right[j].value) {
                smallerCounts[left[i].index] += count;
                merged[k++] = left[i++];
            } else {
                count++;
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            smallerCounts[left[i].index] += count;
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }
    }

}
class Pair{
    int index, value;
     Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
}