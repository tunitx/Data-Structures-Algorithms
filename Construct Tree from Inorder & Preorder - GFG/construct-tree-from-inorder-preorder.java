//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
     public static int find(int[] inorder,int[] preorder,int index,int instart,int inend)
    {
        for(int i=instart;i<=inend;i++)
        {
            if(preorder[index]==inorder[i])
                return i;
        }
        return -1;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Node root=build(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
        return root;
    }
    public static Node build(int[] inorder,int instart,int inend,int[] preorder,int prestart,int preend)
    {
        if(prestart>preend || instart>inend)
            return null;
        Node root=new Node(preorder[prestart]);
        int inRoot=find(inorder,preorder,prestart,instart,inend);
        int numsleft=inRoot-instart;
        root.left=build(inorder,instart,inRoot-1,preorder,prestart+1,prestart+numsleft);
        root.right=build(inorder,inRoot+1,inend,preorder,prestart+numsleft+1,preend);
        return root;
    }
}
