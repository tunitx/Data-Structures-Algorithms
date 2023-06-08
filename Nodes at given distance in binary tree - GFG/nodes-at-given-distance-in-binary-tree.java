//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        var ans = new ArrayList<Integer>();
        kthDistanceNodes(root, target, k, ans);
        Collections.sort(ans);
        return ans;
    }
    static int kthDistanceNodes(Node root, int target, int k, ArrayList<Integer> ans){
        if(root == null) return -1;
        
        if(root.data==target){
            //fn call\
        distanceFromDownward(root, target, k, ans);
            return 1;
        }
        
        int left_dist = kthDistanceNodes(root.left, target, k, ans);
        
        if(left_dist!=-1){
            
            if(left_dist ==k){
                ans.add(root.data);
            }
            else{
                distanceFromDownward(root.right, target, k-left_dist-1, ans);
            }
            return left_dist+1;
        }
        int right_dist = kthDistanceNodes(root.right, target, k , ans);
        if(right_dist!=-1){
            
            if(right_dist ==k){
                ans.add(root.data);
            }
            else{
                distanceFromDownward(root.left, target, k-right_dist-1,ans);
            }
            return right_dist+1;
        }
        return -1;
    }
    static void distanceFromDownward(Node root, int target, int k , ArrayList<Integer> ans){
        if(root == null || k<0) return;
        
        if(k==0){
            ans.add(root.data);
            return;
        }
        distanceFromDownward(root.left, target, k-1, ans);
        distanceFromDownward(root.right, target, k-1, ans);
    }
};