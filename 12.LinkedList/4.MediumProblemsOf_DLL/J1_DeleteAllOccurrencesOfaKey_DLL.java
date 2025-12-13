//* Delete All Occurrences of a key in Doubly Linked List
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

public class J1_DeleteAllOccurrencesOfaKey_DLL {
    
    //* Brute --> Better --> Optimal 

    //* Optimal :
    public static Node DeleteAllOccurrencesOfKey(Node head, int key){
        if(head == null) return null;
        if(head.next == null && head.data == key) return null;

        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                if(temp == head){
                    head = head.next;
                    head.back = null;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.back;
                if(nextNode != null) nextNode.back = prevNode;
                if(prevNode != null) prevNode.next = nextNode;

                temp = nextNode;
            }
            else{
                temp = temp.next;
            }
        }

        return head;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)

    //* My Approach : 
    public static Node deleteAllOccurrencesOfKey(Node head, int key){
        if(head == null) return null;
        if(head.next == null && head.data == key) return null;

        Node temp = head;
        Node prev = null;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        while(temp != null){
            if(temp.data == key){
                temp = temp.next;
            }
            else{
                current.next = temp;
                temp.back = prev;
                current = temp;
                prev = temp;
                temp = temp.next;
            }
        }
        current.next = null;

        return dummyNode.next;
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
        int key = scanner.nextInt();
        scanner.close();

        Node head = convertArrToDLL(arr);
        printDLL(head);

        //* Optimal : 
        head = DeleteAllOccurrencesOfKey(head, key);
        printDLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)

        //* My Approach : 
        // head = deleteAllOccurrencesOfKey(head, key);
        // printDLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
