//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        //date : 30 april 2023
        //faadu question ekdum
        //choose a element or go to next element 
        //if you choose it then decrease the target by the chosen element ie target-arr[i]
        // and if you dont chose the element just increase the curr index by 1 ie index+1
        
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int index = 0;
        
        //to remove all the duplicates from the arrayList 
        //this is to avoid duplocate combinations in the ans 
        // we could have done it by adding (if(ans.contains(ds))) in base condition as well
        // but it takes extra time and thus increases the time complexity
         Set<Integer> set = new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        helper(index , B, A, ans, new ArrayList<Integer>() );
        return ans;
    }
    static void helper(int index, int target, ArrayList<Integer> arr , ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds){
        if(index == arr.size()){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        //either choose the element
        if(arr.get(index) <=target){
            ds.add(arr.get(index));
            
            helper(index, target-arr.get(index), arr, ans, ds);
            
            ds.remove(ds.size()-1);
        }
        //or move to next index
        helper(index+1, target, arr, ans, ds);
        if(target>arr.get(index)){
            return;
        }
        
    }
}