import java.util.Scanner;
import java.util.Stack;
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
public class J4_Reverse_a_DLL {
    //? Reverse a Doubly Linked List : 

    //* Brute --> Better --> Optimal

    //* Brute : 
    public static Node reverseDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Stack<Integer> st = new Stack<>();     //? Instead of stack, we can even use array but stack is easier in this case.
        while(temp != null){
            st.push(temp.data);
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
    public static Node ReverseDLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node current = head;
        Node last = null;
        while(current != null){
            last = current.back;
            current.back = current.next;
            current.next = last;

            current = current.back;
        }
        return last.back;
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

        //* Brute : 
        // head = reverseDLL(head);
        // printDLL(head);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)


        //* Optimal : 
        head = ReverseDLL(head);
        printDLL(head);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
