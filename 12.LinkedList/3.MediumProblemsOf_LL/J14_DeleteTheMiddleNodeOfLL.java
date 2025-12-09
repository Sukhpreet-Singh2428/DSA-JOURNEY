//* Delete The Middle Node of Linked List
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

public class J14_DeleteTheMiddleNodeOfLL {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Node deleteTheMiddle(Node head){
        if(head == null || head.next == null){
            return null;
        }

        int len = 0;
        Node temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int res = len/2;
        temp = head;
        while(temp != null){
            res--;
            if(res == 0){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

        return head;
    }
    //? Time Complexity : O(N + N/2)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static Node DeleteTheMiddleNode_OfLL(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node slow = head;
        Node fast = head;
        fast = fast.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next; 

        return head;
    }
    //? Time Complexity : O(N/2)
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
        // head = deleteTheMiddle(head);
        // printLL(head);
        //? Time Complexity : O(N + N/2)
        //? Space Complexity : O(1)


        //* Optimal : 
        head = DeleteTheMiddleNode_OfLL(head);
        printLL(head);
        //? Time Complexity : O(N/2)
        //? Space Complexity : O(1)
    }
}
