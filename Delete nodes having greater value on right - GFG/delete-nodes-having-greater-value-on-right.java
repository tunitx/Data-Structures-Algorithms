//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        // Node curr = head;
        // Node prev = null;
        // boolean headCheck = true;
        // while(curr.next!=null){
        //     if(curr.next.data>curr.data){
        //         if(headCheck){
        //             curr = curr.next;
        //             head = curr;
        //         }
        //         else{
        //             headCheck = false;
        //             curr= curr.next;
        //              prev.next = curr;
        //         }
        //     }
        //     else{
        //         headCheck = false;
        //         prev = curr;
        //         curr= curr.next;
        //     }
        // }
       
        Node newHead = reverse(head);
        Node currMax = newHead;
       Node  curr = newHead;
        while( curr!=null){
            if(curr.data<currMax.data){
                currMax.next = curr.next;
                curr = curr.next;
            }
            else if(curr.data>currMax.data){
                currMax = curr;
                curr = curr.next;
            }
            else{
                currMax = curr;
                curr = curr.next;
            }
        }
        return reverse(newHead);
        // return newHead;
        // return head;
    }
    Node reverse(Node head){
         Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
  