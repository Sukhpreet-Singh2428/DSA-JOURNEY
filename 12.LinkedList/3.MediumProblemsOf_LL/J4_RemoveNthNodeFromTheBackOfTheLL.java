//* Remove Nth Node From the Back of the Linked List 
//! (Medium Problem)

//? Input: 1 -> 2 -> 3 -> 4 -> 5, n = 2
//? Output: 1 -> 2 -> 3 -> 5

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

public class J4_RemoveNthNodeFromTheBackOfTheLL {
    
    //* Brute : 
    public static Node RemoveNthNodeFromTheEndInLL(Node head, int n){

        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        if(cnt == n){
            Node newHead = head.next;
            return newHead;
        }

        int res = cnt - n;
        temp = head;
        while(temp != null){
            res--;
            if(res == 0) break;
            temp = temp.next;
        }
        // Node deleteNode = temp.next;
        temp.next = temp.next.next;
        return head;
    }
    //? Time Complexity : O(len) + O(len - N)  [In worst case, nearly O(2 * len)]
    //? Space Complexity : O(1)


    //* Optimal : 
    public static Node RemoveNthNodeFromTheEnd(Node head, int n){

        Node fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;
        Node slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // Node deleteNode = slow.next;
        slow.next = slow.next.next;
        return head;
    }
    //? Time Complexity : O(len)
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
        int NthNode = scanner.nextInt();
        scanner.close();

        Node head = convertArrToLL(arr);
        printLL(head);

        //* Brute : 
        // head = RemoveNthNodeFromTheEndInLL(head, NthNode);
        // printLL(head);
        //? Time Complexity : O(len) + O(len - N)  [In worst case, nearly O(2 * len)]
        //? Space Complexity : O(1)


        //* Optimal : 
        head = RemoveNthNodeFromTheEnd(head, NthNode);
        printLL(head);
    }
}
