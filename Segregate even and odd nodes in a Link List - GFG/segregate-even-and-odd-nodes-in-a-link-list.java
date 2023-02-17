//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

//try maintaining two subsequent lists, one of even nodes and one of odd ones
// maintain 4 nodes, evenStart, evenEnd, oddStart and oddEnd.
//change them appropriately and then join EE and OS.
class Solution{
    Node divide(int N, Node head){
        // code here
        Node os = null, oe = null, es = null, ee = null;
        Node curr = head;
        while(curr!=null){
            if(curr.data %2==0){
                if(es==null){
                    es= curr;
                    ee = curr;
                }
                else{
                    ee.next = curr;
                    ee = curr;
                }
            }
            else{
                if(os == null){
                    os = curr;
                    oe = curr;
                    
                }
                else{
                    oe.next = curr;
                    oe = curr;
                }
            }
            curr = curr.next;
        }
        if(os==null || es == null){
            return head;
        }
        ee.next = os;
        oe.next = null;
        return es;
    }
}