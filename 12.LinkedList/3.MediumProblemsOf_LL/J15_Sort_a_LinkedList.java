//* Sort a Linked List
//! (Medium Problem)

import java.util.ArrayList;
import java.util.Collections;
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

public class J15_Sort_a_LinkedList {
    
    //* Brute --> Better --> Optimal : 

    //* Brute : 
    public static Node sortLL(Node head){
        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(arr);

        temp = head;
        int i = 0;
        while(temp != null){
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }

        return head;
    }
    //? Time Complexity : O(N) + O(NlogN) + O(N)
    //? Space Complexity : O(N)


    //* Optimal :
    public static Node merge(Node left, Node right){
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        while(left != null && right != null){
            if(left.data <= right.data){
                current.next = left;
                current = left;
                left = left.next;
            }
            else{
                current.next = right;
                current = right;
                right = right.next;
            }
        }
        if(left != null){
            current.next = left;
        }
        else{
            current.next = right;
        }

        return dummyNode.next;
    }
    public static Node findMiddle(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    } 
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node middle = findMiddle(head);
        Node leftHead = head;
        Node rightHead = middle.next;
        middle.next = null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        
        return merge(leftHead, rightHead);
    }
    public static Node Sort_a_LL(Node head){
        return mergeSort(head);
    }
    //? Time Complexity : O( logN * (N + N/2) )  [ nearly O(NlogN) ]
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
        // head = sortLL(head);
        // printLL(head);


        //* Optimal : 
        head = Sort_a_LL(head);
        printLL(head);
    }
}
