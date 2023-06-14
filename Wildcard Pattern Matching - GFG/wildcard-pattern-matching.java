//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        var dp = new int[pattern.length()+1][str.length()+1];
        for(int i =0; i<dp.length; i++){
            for(int j =0; j<dp[0].length; j++)
            dp[i][j] = -1;
        }
    
      int ans =  helper(pattern.length(), str.length(), pattern, str, dp);
      if(ans == -1 || ans ==0) return 0;
      return 1;
       
    }
    int helper(int x, int y, String pattern, String str, int [][] dp){
        //base condtions
        if(x==0 && y==0) return 1;
        if(x==0 ) return 0;
        if(y==0){
            while(x>0){
                if(pattern.charAt(x-1)!='*') return 0;
                x--;
            }
            return 1;
        }
        if(dp[x][y]==-1) {
        
        if(pattern.charAt(x-1) ==str.charAt(y-1 ) || pattern.charAt(x-1) == '?'){
            dp[x][y] = helper(x-1, y-1, pattern, str, dp);
        }
        else{
            if(pattern.charAt(x-1) == '*'){
               dp[x][y] = Math.max(helper(x-1, y, pattern, str, dp), helper(x, y-1, pattern, str, dp));
            }
            else{
                dp[x][y] =0;
            }
        }
        
        }
        return dp[x][y];
    }
    
}
