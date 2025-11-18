//* Reverse a LinkedList (Recursive)
//! (Easy Problem)

import java.util.Scanner;
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

public class J6_Reverse_a_LL_Recursive {

    //* Recursive 
    public static Node Reverse_LL(Node head){

        if(head == null || head.next == null){
            return head;
        }
        Node newHead = Reverse_LL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)  [O(N) is recursive stack space]
    

    public static Node convertArrToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node current = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }
        return head;
    }
    public static void printLL(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Node head = convertArrToLL(arr);
        printLL(head);

        //* Recursive 
        head = Reverse_LL(head);
        printLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)  [O(N) is recursive stack space]
    }
}
