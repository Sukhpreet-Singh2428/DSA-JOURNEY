//* Detect a Loop or Cycle in Linked List
//! (Medium Problem)

import java.util.HashSet;

class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class J11_Detect_a_LoopOrCycleInLL {

    //* Brute --> Better --> Optimal : 
    
    //* Brute : 
    public static boolean detectLoopOrCycleinLL(Node head){
        HashSet<Node> st = new HashSet<>();

        Node temp = head;
        while(temp != null){
            if(st.contains(temp)){
                return true;
            }
            st.add(temp);
            temp = temp.next;
        }

        return false;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static Boolean Detect_LoopOrCycleinLL(Node head){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        
        // Linear chain
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        
        // Create cycle: 9 -> 3
        node9.next = node3;

        //* Brute : 
        // Boolean ans = detectLoopOrCycleinLL(head);
        // System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)


        //* Optimal : 
        Boolean ans = Detect_LoopOrCycleinLL(head);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)

    }
}
