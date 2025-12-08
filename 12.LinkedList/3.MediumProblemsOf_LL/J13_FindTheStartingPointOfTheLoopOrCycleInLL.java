//* Find The Starting Point of the Loop or Cycle in Linked List
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
public class J13_FindTheStartingPointOfTheLoopOrCycleInLL {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Node startingPointOfTheLoopInLL(Node head){
        if(head == null){
            return head;
        }

        HashSet<Node> st = new HashSet<>();
        Node temp = head;
        while(temp != null){
            if(st.contains(temp)){
                return temp;
            }
            st.add(temp);
            temp = temp.next;
        }

        return null;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)
    

    //* Optimal : (Tortoise & hare)
    public static Node StartingPointOfTheLoopOrCycle_inLL(Node head){
        if(head == null) return null;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)
    //! For approach proof : go to tuf+ approach and intuition section


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
        // Node ans = startingPointOfTheLoopInLL(head);
        // if(ans == null){
        //     System.out.println("null");
        // }
        // else{
        //     System.out.println(ans.data);
        // }
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)


        //* Optimal : 
        Node ans = StartingPointOfTheLoopOrCycle_inLL(head);
        if(ans == null){
            System.out.println("null");
        }
        else{
            System.out.println(ans.data);
        }
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
