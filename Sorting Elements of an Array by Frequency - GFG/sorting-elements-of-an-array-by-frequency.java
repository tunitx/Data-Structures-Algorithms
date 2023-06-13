//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Solution().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        var pq = new PriorityQueue<pair>((a,b)->{
          if(a.freq == b.freq){
              return a.val - b.val;
          }
          else{
              return b.freq - a.freq;
          }
        });
        var map = new HashMap<Integer, Integer>();
        for(var i =0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            
        }
       for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            var p = new pair(e.getKey(), e.getValue());
            pq.add(p);
       }
        int k =0; 
        var ans = new ArrayList<Integer>();
        while(!pq.isEmpty()){
            var p = pq.poll();
            int freq = p.freq;
            while(freq>0){
                ans.add(p.val);
                freq--;
            }
        }
        return ans;
    }
}
class pair{
    int val,  freq;
    pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
    
}