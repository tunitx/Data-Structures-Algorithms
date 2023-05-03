//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        HashSet<String> set = new HashSet<>();
        
        for(int i =0; i<arr.length; i++){
            String og = arr[i];
            if(set.contains(og)){
                //  System.out.println("s");
                continue;
            }
            else{
                StringBuilder rev = new StringBuilder();
                rev.append(og);
                rev.reverse();
                String revStr = rev.toString();
                if(revStr.equals(og)){
                    // System.out.println(revStr);
                    continue;
                }
               else if(set.contains(revStr)){
                //   System.out.println("t");
                    set.remove(revStr);
                }else{
                    // System.out.println(og);
                    set.add(og);
                }
            }
        }
        if(!set.isEmpty()){
            return false;
        }
        return true;
    }
}
        
