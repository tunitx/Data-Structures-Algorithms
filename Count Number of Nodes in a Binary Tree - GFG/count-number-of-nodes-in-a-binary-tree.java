//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
            }
            Node root = new Node(v[0]);
            int cnt = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node cur = null;
            for (int i = 1; i < n; i++) {
                Node node = new Node(v[i]);
                if (cnt == 0) {
                    cur = q.peek();
                    q.poll();
                }
                if (cnt == 0) {
                    cnt++;
                    cur.left = node;

                } else {
                    cnt = 0;
                    cur.right = node;
                }
                if (v[i] >= 0) {
                    q.add(node);
                }
            }

            Solution obj = new Solution();
            int ans = obj.countNodes(root);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int countNodes(Node root) {
        // Code here
        //simple level order traversal of BT
        //date : 27th march 2023
        if(root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count =0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i =0; i<n ;i++){
                Node curr = q.poll();
                count ++;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return count;
    }
}