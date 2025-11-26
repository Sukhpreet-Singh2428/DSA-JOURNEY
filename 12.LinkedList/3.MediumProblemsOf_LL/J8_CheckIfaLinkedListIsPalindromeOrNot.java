//* Check if a LinkedList is Palindrome or Not
//! (Medium Problem)

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

public class J8_CheckIfaLinkedListIsPalindromeOrNot {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static boolean CheckIfLLPalindrome(Node head){
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        while(temp != null){
            st.add(temp.data);
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            if(temp.data != st.peek()) return false;
            temp = temp.next;
            st.pop();
        }
        return true;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static Node reverse(Node temp){
        Node current = temp;
        Node prev = null;
        Node front = null;
        while(current != null){
            front = current.next;
            current.next = prev;
            prev = current;

            current = front;
        }
        return prev;
    }
    public static boolean CheckIf_LL_Palindrome(Node head){
        //? Tortoise and Hare algorithm  [slow and fast pointers]

        if(head == null || head.next == null){
            return true;
        }

        //? Here we will find the M1 or first Middle whereas in middle of LL we have to return the second Node
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        Node first = head;
        Node second = newHead;
        while(second != null){
            if(first.data != second.data){
                reverse(newHead);  //? Re-reverse means back to original 
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;   
    }
    //? Time Complexity : O(N/2 + N/2 + N/2 + N/2) = O(2N)
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
        // boolean ans = CheckIfLLPalindrome(head);
        // System.out.println(ans);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(1)
        
        //* Optimal : 
        boolean ans = CheckIf_LL_Palindrome(head);
        System.out.println(ans);
        //? Time Complexity : O(N/2 + N/2 + N/2 + N/2) = O(2N)
        //? Space Complexity : O(1)
    }
}
