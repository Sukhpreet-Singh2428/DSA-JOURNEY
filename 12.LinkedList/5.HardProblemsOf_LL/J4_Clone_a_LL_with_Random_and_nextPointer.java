//* CLone a Linked List with Random and Next Pointer
//! (Hard Problem)

import java.util.HashMap;

class ListNode{
    int val;
    ListNode next;
    ListNode random;

    public ListNode(int val){
        this.val = val;
        next = null;
        random = null;
    }
}

public class J4_Clone_a_LL_with_Random_and_nextPointer {

    //* Brute --> Better --> Optimal 


    //* Brute : 
    public static ListNode copyRandomList(ListNode head){
        if(head==null) return null;

        HashMap<ListNode, ListNode> mp = new HashMap<>();
        ListNode temp = head;

        while(temp != null){
            ListNode newNode = new ListNode(temp.val);
            mp.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;

        while(temp != null){
            ListNode copyNode = mp.get(temp);
            copyNode.next = mp.get(temp.next);
            copyNode.random = mp.get(temp.random);
            temp = temp.next;
        }

        return mp.get(head);
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(N)

    
    public static void printClonedLinkedList(ListNode head) {
    while (head != null) {
        //? Print the data of the current node
        System.out.print("Data: " + head.val);
        //? Print the data of the random pointer, if it exists
        if (head.random != null) {
            System.out.print(", Random: " + head.random.val);
        } else {
            System.out.print(", Random: null");
        }
        System.out.println();
        //? Move to the next node
        head = head.next;
    }
}
    public static void main(String[] args) {
        
        //? Example linked list: 7 -> 14 -> 21 -> 28
        ListNode head = new ListNode(7);
        head.next = new ListNode(14);
        head.next.next = new ListNode(21);
        head.next.next.next = new ListNode(28);

        //? Assigning random pointers
        head.random = head.next.next;  //? 7 -> 21
        head.next.random = head;  //? 14 -> 7
        head.next.next.random = head.next.next.next;  //? 21 -> 28
        head.next.next.next.random = head.next;  //? 28 -> 14

        //? Print the original linked list
        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);


        //* Brute --> Better --> Optimal 

        //* Brute : 
        ListNode clonedList = copyRandomList(head);
        System.out.println("Cloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)
    }
}
