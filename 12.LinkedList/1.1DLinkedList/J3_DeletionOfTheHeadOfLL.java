// import java.util.*;
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
public class J3_DeletionOfTheHeadOfLL {
    public static Node deleteHead(Node head){
        if(head == null){
            return null;
        }

        head = head.next;
        return head;
    }
    public static Node insertAtHead(Node head, int data){
        Node newNode = new Node(data, head);
        head = newNode;
        return head;
    }
    public static void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        Node head = null;
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        System.out.println("original List : ");
        printList(head);

        head = deleteHead(head);   //? Deletion of the Head of LL
        printList(head);
    }
}
