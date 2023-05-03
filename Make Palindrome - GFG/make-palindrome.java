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
        //date : 3rd may 2023
        //simple hashSet implementation
        boolean check = true;
        boolean secCheck = true;
        String checker = arr[0];
        // for(int i =1; i<arr.length ; i++){
        //     if(!(checker.equals(arr[i]))){
        //         secCheck = false;
        //     }
        // }
        
        HashSet<String> set = new HashSet<>();
        for(int i =0; i<arr.length; i++){
            String og = arr[i];
             if(!(checker.equals(arr[i]))){
                secCheck = false;
            }
            if(set.contains(og) && og.length()!=1) continue;
            else{
                StringBuilder rev = new StringBuilder();
                String revStr =  rev.append(og).reverse().toString();
                if (revStr.equals(og) && check ){
                    check = false;
                    continue;
                }
                else if (set.contains(revStr)) set.remove(revStr);     
                else set.add(og);  
            }
        }
        if(secCheck && arr.length>1){
            return true;
        }
      return set.isEmpty();
    }
    
}

        
