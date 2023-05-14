//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        
        for(int i =0; i<n; i++){
            inorderMap.put(in[i], i);
        }
        
        int is =0, ps =0;
        int ie=n-1, pe = n-1;
        
       return helper(in, is, ie, post, ps, pe, inorderMap, n);
    }
    Node helper(int [] in, int is, int ie, int [] post, int ps, int pe, HashMap<Integer, Integer> inMap, int n  ){
        // base condition
        if(is>ie || ps>pe){
            return null;
        }
        
        Node root =  new Node(post[pe]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot -is;
        
        root.left = helper(in, is, inRoot-1, post, ps, ps+ numsLeft-1, inMap, n);
        root.right = helper(in, inRoot+1, ie, post, ps + numsLeft, pe-1, inMap, n);
        return root;
    }
}
