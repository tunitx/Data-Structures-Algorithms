//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        List<String> list = new ArrayList<>();
        int i =0;
        findPermutations(S, i, list);
        Collections.sort(list);
        return list;
    }
    public static void findPermutations(String str, int i , List<String> list){
        if(i ==str.length()){
            if(!list.contains(str)){
                 list.add(str);
            }
           
            return;
        }
        for(int j =i; j<str.length(); j++){
            str = swap(str, i, j);
            findPermutations(str, i+1, list);
            str = swap(str, i, j);
        }
    }
    public static String swap(String str, int i, int j){
        char [] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}