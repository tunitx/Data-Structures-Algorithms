//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        // Your code here
        
        //jai mata di 🙏🙏
        //date: 1 mar 2023
        
        int [] R = new int[arr.length];
        int [] L = new int[arr.length];
        findPreviousSmallest(arr,L);
        findNextSmallest(arr, R);
        int [] ans = new int[arr.length];
        for(int i =0; i<arr.length; i++){
            int len = R[i]-L[i]-1;
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }
        for(int i =arr.length-2; i>=0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }
     public static void findPreviousSmallest(int [] arr, int [] ans){
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0; i<arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

    }
    public static void findNextSmallest(int [] arr, int [] ans){
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = arr.length;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

    }
}