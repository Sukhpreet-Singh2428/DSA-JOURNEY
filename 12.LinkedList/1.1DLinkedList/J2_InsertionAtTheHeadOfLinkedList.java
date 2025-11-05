class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        next = null;
    }
}
//! Insertion At the Head of Linked List 
public class J2_InsertionAtTheHeadOfLinkedList {

    public static Node insertHead(Node head, int val){
        Node temp = new Node(val, head);
        return temp;
    }

    public static Node arrayToLinkedList(int[] arr){
        int size = arr.length;
        if(size == 0) return null;

        //? create head of the linked list
        Node head = new Node(arr[0]);
        Node current = head;           //* (here, head and current both refer to the same Node object)

        //? Iterate through the array and create linked list nodes
        for(int i=1; i<size; i++){
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = current.next;    //? current = temp 
        }

        return head;
    }
    public static void printLinkedList(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static int LengthOfLinkedList(Node head){
        int length = 0;
        Node current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }
    public static boolean serachElement(Node head, int target){
        Node current = head;

        while(current != null){
            if(current.data == target){
                return true;
            }
            current = current.next;
        }

        return false;
    }
    public static void main(String args[]){
        int[] arr = {1, 2, 3, 4, 5};

        Node head = arrayToLinkedList(arr);  //* convert array to LinkedList
        printLinkedList(head);   //* Print the LinkedList
        head = insertHead(head, 100);  //? Insertion At the Head of LL
        printLinkedList(head);   //* Print the LinkedList



        // printLinkedList(head);   //* Print the LinkedList
        // System.out.println(LengthOfLinkedList(head));  //* Print the Lenght of the Linked List

        //* Search an Elment in Linked List
        // int target = 3;
        // if( serachElement(head, target) ){
        //     System.out.println("Element " + target + " found in the linked List");
        // }
        // else{
        //     System.out.println("Element " + target + " not found in the Linked List");
        // }
    }
}
