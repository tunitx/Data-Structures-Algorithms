//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> list = new ArrayList<>();
        int [] pat = new int [256];
        int [] str = new int [256];
        boolean empty = true;
        boolean check = true;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            pat[ch]++;
        }
        Node low = head;
        Node curr = head;
        while(curr!=null){
            char ch = curr.data;
            if(pat[ch]!=0){
                if(check){
                    low = curr;
                    check = false;
                }
                str[ch]++;
                while(low!=curr && str[ch]>pat[ch]){
                    str[low.data]--;
                    low = low.next;
                }
                if(checkForAnagram(str, pat)){
                    empty = false;
                    list.add(low);
                    Node temp = curr.next;
                    curr.next = null;
                    curr = temp;
                    low = temp;
                    Arrays.fill(str, 0);
                }
                else{
                    curr = curr.next;
                }
            }
            else{
                Arrays.fill(str, 0);
                check = true;
                curr = curr.next;
            }
        }
        
        return list;
    }
      public static boolean checkForAnagram(int [] str, int [ ] pat){        
      for(int i =0; i<pat.length; i++){                                  
          if(pat[i]>0){                                                  
              if(pat[i]!=str[i]){                                        
                  return false;                                          
              }                                                          
          }                                                              
      }                                                                  
      return true;                                                       
  }                                                                      
}