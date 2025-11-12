//* Segrregate Odd and Even Nodes In Linked List 
//! (Medium Problem)

//? Input:  1 -> 2 -> 3 -> 4 -> 5
//? Output: 1 -> 3 -> 5 -> 2 -> 4

import java.util.Scanner;
import java.util.ArrayList;
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
public class J2_SegrregateOddandEvenNodesInLL {

    //* Brute --> Better --> Optimal

    //* Brute : 
    public static Node OddandEvenNodesInLL(Node head){
        ArrayList<Integer> arr = new ArrayList<>();
        
        Node temp = head;
        //? odd
        while(temp != null && temp.next != null){
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) arr.add(temp.data);   //? if we end up at tail and due to temp.next != null condition above, we will miss the last Node. So that's why this condition is added

        //? even
        temp = head.next;
        while(temp != null && temp.next != null){
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) arr.add(temp.data);

        int i = 0;
        temp = head;
        while(temp != null){
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }
    //? Time Complexity : O(2N)   [ N is the no. of Nodes in Linked List ]
    //? Space Complexity : O(N)


    //* Optimal 
    public static Node Odd_and_Even_NodesInLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        
        while(even != null && even.next != null){   //? we write condition for even bcz even is always ahead of odd, if even is not null and odd is not null too.
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
    //? Time Complexity : O(N/2 * 2)  [equal to O(N)]
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
        // head = OddandEvenNodesInLL(head);
        // printLL(head);
        //? Time Complexity : O(2N)   [ N is the no. of Nodes in Linked List ]
        //? Space Complexity : O(N)

        //* Optimal : 
        head = Odd_and_Even_NodesInLL(head);
        printLL(head);
    }
}
