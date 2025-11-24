//* Middle of the LinkedList
//! (Easy Problem)
//! [ Tortoise and Hare algorithm ]
//! [ concept of slow and fast pointers ]

//? return the middle node of the Linked List.
//? If the Linked List has an even number of nodes, return the second middle one.

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

public class J7_MiddleOfTheLinkedList {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int middleOfLL(Node head){
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        int midNode = (cnt/2) + 1;
        temp = head;
        while(temp != null){
            midNode--;
            if(midNode == 0){
                break;
            }
            temp = temp.next;
        }
        return temp.data;
    }
    //? Time Complexity : O(N + N/2)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static int Middle_Of_LL(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;   //? Slow pointer, end up at middle node
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
        // int ans = middleOfLL(head);
        // System.out.println(ans);
        //? Time Complexity : O(N + N/2)
        //? Space Complexity : O(1)

        //* Optimal :  [slow and fast pointers]
        int ans = Middle_Of_LL(head);
        System.out.println(ans);
        //? Time Complexity : O(N/2)
        //? Space Complexity : O(1)
    }
}
