//* Add 1 to a Number Represented By Linked List
//! (Medium Problem)

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

public class J9_Add1To_aNumberRepresentedByLinkedList {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Node reverse(Node head){
        Node temp = head;
        Node prev = null;
        Node next = null;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;

            temp = next;
        }
        return prev;
    }

    public static Node add_1_to_a_NumberRepresentedByLL(Node head){

        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while(temp != null){
            temp.data = temp.data + carry;
            if(temp.data < 10){
                carry = 0;
                break;
            }
            else{
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if(carry == 1){
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }

        head = reverse(head);
        return head;
    }
    //? Time Complexity : O(3N)
    //? Space Complexity : O(1)
    
    
    //* Optimal :   (backtracking and recursion)
    public static int helper(Node temp){
        if(temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data + carry;
        if(temp.data < 10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }
    public static Node Add_1_To_a_NumberRepresentedByLL(Node head){
        int carry = helper(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N) [recursion stack space]

    
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
        // head = add_1_to_a_NumberRepresentedByLL(head);
        // printLL(head);
        //? Time Complexity : O(3N)
        //? Space Complexity : O(1)

        //* Optimal : 
        head = Add_1_To_a_NumberRepresentedByLL(head);
        printLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) [recursion stack space]
    }
}
