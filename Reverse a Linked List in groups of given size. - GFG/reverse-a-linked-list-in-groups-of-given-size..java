//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    
    
    // dont look at the code straight in the future while revising, it is tough 
    //to understand the logic in one go, just see page number 101 in dsa ref copy
    //try understanding the logic by breaking the reversing part cuz u sucked there
    //the last time u solved this problem on 17th feb, 2023.
    public static Node reverse(Node head, int k)
    {
        //Your code here
        Node curr = head;
        Node prev_first = null;
        boolean first_check = true;
        while(curr!=null){
            Node prev = null;
            Node first = curr;
            int count =0;
            while(curr!=null && count<k){
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(first_check){
                head = prev;
                first_check = false;
            }
            else{
                prev_first.next = prev;
            }
            prev_first = first;
        }
        return head;
    }
}

