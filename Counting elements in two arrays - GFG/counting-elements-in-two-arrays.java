//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       // add your code here
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr2);
        for(int i =0; i<arr1.length; i++ ){
            int res = countTheElementsInArr2(arr1[i], arr2);
            list.add(res);
        }
        return list;
    }
     public static int countTheElementsInArr2(int x, int [] arr){
        int low =0;
        int high = arr.length-1;
        int res = 0;
        boolean check = true;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<=x){
                res = mid;
                low = mid+1;
                check = false;
            }
            else{
                high = mid-1;
            }
        }
        if(check){
            return 0;
        }
        return res+1;
    }
    
}
    