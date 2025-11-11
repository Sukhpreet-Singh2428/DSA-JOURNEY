//* Add two Numbers in LL
//! (Medium Problem)
//? Given two non-empty linked lists l1 and l2 which represent two non-negative integers.
//? The digits are stored in reverse order with each node storing one digit.
//? Add two numbers and return the sum as a linked list.
//? The sum Linked List will be in reverse order as well.
//? The Two given Linked Lists represent numbers without any leading zeros, except when the number is zero itself.

//? Input: l1 = 4 -> 5 -> 6,   l2 = 1 -> 2 -> 3
//? Output: 5 -> 7 -> 9

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
public class J1_Add2NumbersInLL {

    //* Optimal : 
    public static Node Add_2_NumbersInLL(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null) sum = sum + temp1.data;
            if(temp2 != null) sum = sum + temp2.data;
            Node newNode = new Node(sum%10);
            carry = sum/10;
            current.next = newNode;
            current = newNode;
            if(temp1!=null) temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
        }
        if(carry != 0){
            Node newNode = new Node(carry);
            current.next = newNode;
        }
        return dummyNode.next;
    }
    //? Time Complexity : O(max(N1, N2))    [N1 is no. of nodes in LL1 and N2 is no. of nodes in LL2]
    //? Space Complexity : O(1)  [we are using space to return answer, not in solve the problem]
    

    //* Brute : 
    public static int LL_to_number(Node head){
        int n = 0;
        Node temp = head;
        while(temp != null){
            n = n*10 + temp.data;
            temp = temp.next;
        }
        int rev = 0;
        while(n != 0){
            rev = rev*10 + n%10;
            n = n/10;
        }
        return rev;
    }
    public static Node NumberToLL(int num){
        Node head = new Node(num%10);
        Node current = head;
        num = num/10;
        while(num != 0){
            Node temp = new Node(num%10);
            current.next = temp;
            current = temp;
            num = num/10;
        }
        return head;
    }
    public static Node AddTwoNumbersInLL(Node head1, Node head2){
        int num1 = LL_to_number(head1);
        int num2 = LL_to_number(head2);
        int sum = num1 + num2;
        Node sumNode = NumberToLL(sum);
        return sumNode;
    }

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
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0; i<n1; i++){
            arr1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0; i<n2; i++){
            arr2[i] = scanner.nextInt();
        }
        scanner.close();

        Node head1 = convertArrToLL(arr1);
        printLL(head1);
        Node head2 = convertArrToLL(arr2);
        printLL(head2);

        //* Optimal : 
        Node sumNode = Add_2_NumbersInLL(head1, head2);
        printLL(sumNode);

        //* Brute : (My Brute code : use functions --> AddTwoNumbersInLL, LL_to_number, NumberToLL)
        // Node sumNode = AddTwoNumbersInLL(head1, head2);
        // printLL(sumNode);
        //? Time Complexity : O(n1) + O(n2) + O(max(n1, n2)) + O(max(n1, n2))
        //? Space Complexity : O(1)  [using space to return the answer, not to solve the problem]
        //! It will fail for large testcases due to number conversion working
    }    
}
