//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat1, String str1) {
        // code here
           int [] str= new int[256];                                                                          
   int [ ] pat = new int[256];                                                                        
   int count =0;                                                                                      
   for(int i =0; i<pat1.length(); i++){                                                               
       char ch = pat1.charAt(i);                                                                      
       pat[ch] ++;                                                                                    
   }                                                                                                  
   int low =0;                                                                                        
   for(int i =0; i<str1.length(); i++) {                                                              
       char ch = str1.charAt(i);                                                                      
       if(pat[ch]>0){                                                                                 
           str[ch]++;                                                                                 
           while(low<i && str[ch]>pat[ch]){                                                           
               str[str1.charAt(low)]--;                                                               
               low++;                                                                                 
           }                                                                                          
           if(checkForAnagram(str, pat)){                                                             
               count++;                                                                               
           }                                                                                          
       }                                                                                              
       else{                                                                                          
           Arrays.fill(str, 0);                                                                       
           low = i;                                                                                   
       }                                                                                              
   }                                                                                                  
   return count ;                                                                                     
    }
     public static boolean checkForAnagram(int [] str, int [ ] pat){                      
     for(int i =0; i<pat.length; i++){                                                
         if(pat[i]>0){                                                                
             if(pat[i]!=str[i]){                                                      
                 return false;                                                        
             }                                                                        
         }                                                                            
     }                                                                                
     return true;                                                                     
 }                                                                                    
}