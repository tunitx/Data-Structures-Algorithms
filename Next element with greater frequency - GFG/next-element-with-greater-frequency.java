//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // int arr[] = new int[10000];
        
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n; i++)
            {
                arr[i] = sc.nextInt();
            }
            
            solver x = new solver();
            int res[]=x.print_next_greater_freq(arr,n);
            StringBuffer sb=new StringBuffer("");
            for(int i : res){
                sb.append(i+" ");
            }
            System.out.println(sb);
        }
    }
}

// } Driver Code Ends


class solver
{
    static int[] print_next_greater_freq(int arr[], int n)
    {
        //date : 15th june 2023
        //NGE type solution
        var map = new HashMap<Integer, Integer>();
        for(int i =0; i<n; i++) map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        var ans = new int[n];
        var stack = new ArrayDeque<pair>();
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek().freq<=map.get(arr[i])) stack.pop();
            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek().val;
            stack.push(new pair(arr[i], map.get(arr[i])));
        }
        return ans;
    }
}
class pair{
    int val, freq;
    pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}

