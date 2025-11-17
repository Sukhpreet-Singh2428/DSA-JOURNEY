//* Reverse a LinkedList (Iterative)
//! (Easy Problem)

import java.util.Scanner;
import java.util.Stack;
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

public class J5_Reverse_a_LinkedList {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Node ReverseLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null){
            st.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            temp.data = st.peek();
            st.pop();
            temp = temp.next;
        }

        return head;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static Node Reverse_LL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node temp = head;
        Node prev = null;
        Node front = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;

            temp = front;
        }

        return prev;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)

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

        //* Brute : 
        // head = ReverseLL(head);
        // printLL(head);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)

        //* Optimal : 
        head = Reverse_LL(head);
        printLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
