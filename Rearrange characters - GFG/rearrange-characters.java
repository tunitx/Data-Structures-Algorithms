//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends




class Solution
{   static int j;
	public static String rearrangeCharacters(String str) {
	
		//code here
		j=0;
		int n = str.length();
        // var pq = new PriorityQueue<pair>((a,b)-> {
        //     if(a.freq == b.freq) return 1;
        //     else return b.freq - a.freq;
        // });
        // pair prev = new pair('#', -1);
        int max = Integer.MIN_VALUE;
        var map = new HashMap<Character, Integer>();
        for(int i =0; i<str.length(); i++){
           
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }
            else{
                map.put(str.charAt(i), 1);
            }
            max = Math.max(map.get(str.charAt(i)),max);
            if (max > (str.length() + 1) / 2) return "-1";
        }
        int i =0;
         char[] ans = new char[str.length()];
        //we cant sort map so using a priority queue
        PriorityQueue < Character > pq = new PriorityQueue < > ((n1, n2)-> map.get(n2) - map.get(n1));
        map.forEach((key,val)->pq.add(key));
        //keep filling the character in alternate position
        //here we start filling ele with max freq
        while (!pq.isEmpty()) {
           Character t = pq.remove();
            fill(t, map.get(t), ans);
        }
        return String.valueOf(ans);

	}
	 static void fill(char c, int freq, char[] ans) {
        while (freq > 0) {
            ans[j] = c;
            j += 2;
            //if hit the end,again start with 1
            if (j > ans.length - 1) j= 1;
            freq--;
        }
    }
}
class pair{
    char val;
    int freq;
    pair(char val, int freq){
        this.val = val;
        this.freq = freq;
    }
}