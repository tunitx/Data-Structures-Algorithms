//{ Driver Code Starts
//Initial Template for Java


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
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)-> {
            if(a.freq==b.freq){
                return 1;
            }
            else{
                return a.freq-b.freq;
            }
        });
        for(int i =0; i<N; i++){
            q.add(new Node(S.charAt(i), f[i]));
        }
        while(q.size()>1){
            Node left = q.poll();
            Node right = q.poll();
            Node temp = new Node('$', left.freq+right.freq);
            temp.left = left;
            temp.right = right;
            q.add(temp);
        }
        ArrayList<String> ans = new ArrayList<>();
        addRecToList(q.peek(), ans, "");
        return ans;
    }
    
    public void addRecToList(Node root, ArrayList<String> ans, String bits){
        if(root.data!='$'){
           ans.add(bits);
            return;
        }
        addRecToList(root.left, ans, bits+"0");
        addRecToList(root.right, ans, bits+"1");
    }
}
class Node {
    char data;
    int freq;
    Node left, right;
    Node(char data, int freq){
        this.data = data;
        this.freq = freq;
    }
}