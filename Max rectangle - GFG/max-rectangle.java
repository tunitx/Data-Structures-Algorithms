//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int mat[][], int n, int m) {
        // add code here.
         for(int i =1; i<mat.length; i++){
            for(int j = 0; j<mat[i].length; j++){
                if(mat[i][j]!=0){
                    mat[i][j] +=mat[i-1][j];
                }
            }


        }
        int col = mat[0].length;
        int res = 0;
        for(int i =0; i<mat.length; i++){
            res  = Math.max(res, largestRectangularAreaInAHistogram(mat[i],col));
            // System.out.println(res);
        }
        return res;
    }
    public static int largestRectangularAreaInAHistogram(int [] mat , int col){
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for(int j =0; j<mat.length; j++){
            while(!stack.isEmpty() && mat[stack.peek()]>=mat[j]){
                int top = stack.pop();
               int curr = mat[top]*(stack.isEmpty()?j:j-stack.peek()-1);
                res = Math.max(res,curr);
            }
            stack.push(j);
        }
    
        while(!stack.isEmpty()){
            int top = stack.pop();
           int curr = mat[top]*(stack.isEmpty()?col:col-stack.peek()-1);
            res = Math.max(res,curr);
        }
        return res;
    }
}