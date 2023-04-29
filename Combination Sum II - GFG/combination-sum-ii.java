//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String s[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			int a[] = new int[n];
			s = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(s[i]);
			List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
			for(List<Integer> list : ans){
				for(int x : list)
					ot.print(x + " ");
				ot.println();
			}
			if(ans.size() == 0)
			    ot.println();
		}
        ot.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	public List<List<Integer>> CombinationSum2(int a[], int n, int k){
		// Code Here.
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(a);
		helper(0,k, a, ans, new ArrayList<Integer>());
		return ans;
	}
	static void helper(int index, int target, int [] arr, List<List<Integer>> ans, ArrayList<Integer> ds ){
	    if(target == 0){
	        ans.add(new ArrayList<Integer>(ds));
	        return;
	    }
	    
	    for(int i = index; i<arr.length; i++){
	        if(i>index && arr[i] == arr[i-1]){
	            continue;
	        }
	        if(arr[i]>target){
	            break;
	        }
	        ds.add(arr[i]);
	        helper(i+1, target-arr[i], arr, ans, ds);
	        ds.remove(ds.size()-1);
	    }
	}
}

