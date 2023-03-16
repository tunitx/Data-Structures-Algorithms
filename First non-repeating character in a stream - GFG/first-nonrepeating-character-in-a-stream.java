//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String str)
    {
        // code here
        //  int [] ch = new int[256];
        //  //lol doesnt work cuz tle
        //  //date : 1 mar 2023
        // String ans = "";
        // char lastRep = ' ';
        // for(int i =0; i<str.length(); i++ ){
        //     ch[str.charAt(i)]++;
        //     boolean check = true;
        //     if(ch[lastRep]==1){
        //         ans+=lastRep;
        //         check = false;
        //     }
        //     else{
        //         for(int j = 0; j<str.length(); j++){
        //             if(ch[str.charAt(j)]==1){
        //                 ans+=str.charAt(j);
        //                 lastRep = str.charAt(j);
        //                 check = false;
        //                 break;
        //             }
        //         }
        //     }

        //     if (check){
        //         ans+='#';
        //     }
        // }
        // return ans;
  Queue<Character> q = new ArrayDeque<>();
        String ans ="";
        int [] ch = new int[256];
        q.add(str.charAt(0));
        ch[str.charAt(0)]++;
        ans += str.charAt(0);
        for(int i =1; i<str.length(); i++ ) {
          char c = str.charAt(i);
          ch[c]++;
          if(ch[c]==1){
              if(q.isEmpty()){
                  
                  ans+=c;
              }
            else{
                ans+=q.peek();
            }
              q.add(c);
             
          }
          else{
               q.remove(c);
              if(q.isEmpty()){
                  ans+='#';
              }
              else{
                  ans+=q.peek();
              }
          }


        }
        return ans;

    }
}