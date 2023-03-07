//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine().trim());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int Key;
            Key = Integer.parseInt(br.readLine().trim());
            
            Solution obj = new Solution();
            boolean res = obj.Search(N, A, Key);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean Search(int N, int[] arr, int key) {
        // code here
        int pivot = findPivotBinarySearch(arr);
        int low =0;
        int high = 0;
        if(arr.length>=2 && arr[1]<arr[0]){
            pivot = 1;
        }
        if(key>=arr[pivot] && key<=arr[N-1]){
            low = pivot;
            high = arr.length-1;
        }
        else{
            low =0;
            high = pivot;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == key){
                return  true;
            }
            else if(arr[mid]>key){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
     public static int findPivotBinarySearch(int[] array) {
	
	        if (array == null || array.length == 0) {
	            return -1;
	        }
	
	         
	        if (array.length == 1 || array[0] < array[array.length - 1]) {
	            return 0;
      }
	
	        int start = 0, end = array.length - 1;
	
	        while (start <= end) {
	
	            int mid = (start + end) / 2;
	             
	            if (mid < array.length-1 && array[mid] > array[mid+1]) {
	                return (mid + 1);
	            } else if (array[start] <= array[mid]) {
	                 
	                 
	                 
	                start = mid + 1;
	            } else {
	                 
	                end = mid - 1;
	            }
	        }
	
	        return 0;
	    }
}
        
