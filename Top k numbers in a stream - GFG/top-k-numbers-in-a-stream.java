//{ Driver Code Starts





import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution
{ 
    static ArrayList<Integer> kTop(int[] arr, int n, int k) 
    { 
        //code here.
        HashMap<Integer, pair> map = new HashMap<>();
        Set<pair> tSet = new TreeSet<pair>((p1, p2)->{
            if(p1.freq== p2.freq){
                return p1.val-p2.val;
            }
            else{
                return p2.freq-p1.freq;
            }
        });
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0; i<n; i++){
            if(map.containsKey(arr[i])){
                pair p = map.get(arr[i]);
                 tSet.remove(p);
                p.freq++;
                tSet.add(p);
            }
            else{
                pair p = new pair(arr[i], 1);
                map.put(arr[i], p);
                tSet.add(p);
            }
            
            Iterator<pair> itr = tSet.iterator();
            for(int count = 0; count<k && itr.hasNext(); count++){
                ans.add(itr.next().val);
            }
        }
        return ans;
        
    }
}
class pair{
    int val;
    int freq;
    pair(int val, int freq){
        this.val =val;
        this.freq = freq;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line1 = br.readLine();
		    String[] ele = line1.trim().split("\\s+");
		    int n= Integer.parseInt(ele[0]);
		    int k= Integer.parseInt(ele[1]);
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(elements[i]);
		    Solution ob=new Solution();
		    ArrayList<Integer> ans= new ArrayList<Integer>(); 
		 //   System.out.println(a[0]+" "+n+" "+k);
		    ans=ob.kTop(a,n,k);
		    for(int i=0;i<ans.size();i++)
		    {
		        System.out.print(ans.get(i)+" ");
		    }
		    System.out.println();
		}
	}
}

// } Driver Code Ends