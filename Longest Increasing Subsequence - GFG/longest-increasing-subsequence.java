//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends






class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int arr[])
    {
        // code here
        //date : 11th june 2023
        //LIS question, this can be done by dp as well in n*2 time 
       var tail = new int[size];
       int len = 1;
       tail[0] = arr[0];
       for(int i =1; i<size; i++){
           if(arr[i]>tail[len-1]){
               tail[len] = arr[i];
               len++;
           }
           else{
               int ceil = findCeil(tail, 0, len-1, arr[i]);
               tail[ceil] = arr[i];
               
           }
       }
       return len;
    }
    static int findCeil(int [] arr, int left, int right, int x){
        while(left<right){
            int mid = (left +right)/2;
            if(arr[mid]>=x){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return right;
    }
} 