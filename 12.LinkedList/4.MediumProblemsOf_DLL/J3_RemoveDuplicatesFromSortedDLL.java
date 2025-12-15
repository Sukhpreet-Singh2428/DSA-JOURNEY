//* Remove Duplicates from Sorted Doubly Linked List 
//! (Medium Problem)

import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node back;

    Node(int data, Node next, Node back){
        this.data = data;
        this.next = next;
        this.back = back;
    }
    Node(int data){
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class J3_RemoveDuplicatesFromSortedDLL {
    
    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static Node removeDuplicatesFromSortedDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node temp = head;
        while(temp != null && temp.next != null){
            Node nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null) nextNode.back = temp;
            temp = temp.next;
        }

        return head;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    //* My Approach : 
    public static Node RemoveDuplicatesFromSorted_DLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        current.next = head;
        current = head;
        Node prev = head;
        Node temp = head.next;
        while(temp != null){
            if(temp.data == prev.data){
                temp = temp.next;
            }
            else{
                current.next = temp;
                temp.back = prev;
                prev = temp;
                current = temp;
                temp = temp.next;
            }
        }
        current.next = null;

        return head;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static Node convertArrToDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node current = head;    
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i], null, current);
            current.next = temp;
            current = temp;
        }
        return head;
    }
    public static void printDLL(Node head){
        Node current = head;   
        while(current != null){
            System.out.print(current.data + "-> ");
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

        Node head = convertArrToDLL(arr);
        printDLL(head);


        //* Optimal : 
        head = removeDuplicatesFromSortedDLL(head);
        printDLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)


        //* My Approach : 
        // head = RemoveDuplicatesFromSorted_DLL(head);
        // printDLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
