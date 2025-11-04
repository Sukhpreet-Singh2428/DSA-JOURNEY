import java.util.*;
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

public class J1_Introduction {
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
    public static void main(String args[]) {
        // ? What is LinedList ?
        // * ~ LinkedList is an Data Structure
        // * ~ Unlike Arrays, Linked List doesn't store elements in contigous order in
        // the memory.
        // * ~ LinkedList can increase or decrease it's size by adding or removing
        // element
        // * due to its not contigous memory location of the elements.
        // * ~ Inshort, LinkedList is dynamic in nature [add or remove elemets]
        // * ~ Like Arrays, LinkedList can be int, double, list, float, char, string
        // etc.

        // ? how elements are store in LinkedList :
        // ? element memory location
        // ? 1 m1 (1 --> head)
        // ? 3 m2
        // ? 2 m3
        // ? 5 m4 (5 --> tail)

        // * 1 3 2 5
        // * next = m2 next = m3 next = m4 next = null_ptr (null in java)

        // * haed = m1
        // * tail = m4

        // * In LinedList, elements are store with next. next is the memory location of
        // the next element in the LinedList
        // * If we know the head (head = m1) then we can easily move in the LinedList
        // * As they form an hypotheically link between the element as element store
        // with next, which gives the memory element of the next elment
        // ? To Add element in LinkedList :
        // * Add 8 at randomly in heap memory with location m5, and we
        // * iupdate the tail to m5. Change the next = m5 for elemet 5 and for element 8
        // next = null_ptr or null
        // * That's how the LinkedList size changes (increases).
        // ? Similar Thinking for remove element in LinkedList as well !

        // ? Where is it used ?
        // * Stack / Oueue
        // * Real Life use : Browser tab

        // ? Struct and Class in C++/java !!
        // * As in LinkedList, we are storing data and next together.
        // * data can be of any type int, float, double, char, etc
        // * next will the pointer(int*, float*, etc) that stores the memory location of
        // * next element (IN C++)
        // * So they together is not any data type. so in order to define data-type to
        // * LinkedList. we create our own data-type using struct or class.

        // int[] arr = {2, 5, 8, 7};
        // Node y = new Node(arr[1]);
        // System.out.println(y.data);
        // System.out.println(y.next);

        //? Types of Linked List :
        //* 1. Singly Linked Lists
        //* 2. Doubly Linked Lists
        //* 3. Circular Linked Lists:


        //? Convert an Array to Linked List : - 
        int[] arr = {1, 2, 3, 4, 5};

        Node head = arrayToLinkedList(arr);  //* convert array to LinkedList
        printLinkedList(head);   //* Print the LinkedList
        System.out.println(LengthOfLinkedList(head));  //* Print the Lenght of the Linked List

        //* Search an Elment in Linked List
        int target = 3;
        if( serachElement(head, target) ){
            System.out.println("Element " + target + " found in the linked List");
        }
        else{
            System.out.println("Element " + target + " not found in the Linked List");
        }
    }
}
