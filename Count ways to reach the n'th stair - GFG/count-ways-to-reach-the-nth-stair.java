//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        
        // your code here
        // sat sri akal ji mein ek bruh moment report karna chauna aan
        //date : 8 march 2023
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        long low = 1;
        long high =2;
        int i =3;
         long mod = 1000000007;
        while(i<=n){
            long temp = (high%mod);
            high = (low+high)%mod;
            low = temp;
            i++;
        }
        return  (int)(high%mod);
    }
}

