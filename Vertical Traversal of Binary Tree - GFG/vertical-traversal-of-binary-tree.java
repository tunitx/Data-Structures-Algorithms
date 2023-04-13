//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        //date : 13th april 2023
        //complicated hai, u might want to visit the solution again while revising 
        TreeMap<Integer, ArrayList<Integer> > map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.add(new pair(root, 0));
        while(!q.isEmpty()){
            pair p = q.poll();
            Node curr = p.node;
            int prev = p.prev;
            if(map.containsKey(prev)){
                map.get(prev).add(curr.data);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.data);
                map.put(prev, temp);
            }
            if(curr.left!=null) q.add(new pair(curr.left, prev-1));
            if(curr.right!=null) q.add(new pair(curr.right, prev+1));
        }
        for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet()){
           for(int i =0; i<e.getValue().size(); i++){
               list.add(e.getValue().get(i));
           }
        }
        return list;
        
    }
}
class pair{
    Node node;
    int prev;
    pair(Node n, int p){
        node = n;
        prev = p;
    }
}