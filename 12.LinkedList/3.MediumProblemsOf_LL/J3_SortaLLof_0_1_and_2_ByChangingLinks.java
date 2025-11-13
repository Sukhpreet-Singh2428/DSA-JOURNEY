//* Sort a LL of 0's 1's and 2's by changing links
//! (Medium Problem)

//? Input: 1 -> 0 -> 2 -> 0 -> 1
//? Output: 0 -> 0 -> 1 -> 1 -> 2

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
public class J3_SortaLLof_0_1_and_2_ByChangingLinks {
    
    //* Brute : 
    public static Node sortaLLOf_0_1_and2(Node head){
        if(head == null || head.next == null) return head;

        Node temp = head;
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        while(temp != null){
            if(temp.data == 0) cnt0++;
            else if(temp.data == 1) cnt1++;
            else if(temp.data == 2) cnt2++;
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(cnt0 != 0){
                temp.data = 0;
                cnt0--;
            }
            else if(cnt1 != 0){
                temp.data = 1;
                cnt1--;
            }
            else if(cnt2 != 0){
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }

        return head;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static Node Sort_a_LL_Of_0_1_and_2(Node head){
        if(head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }
            
            temp = temp.next;
        }

        if(oneHead.next != null) zero.next = oneHead.next;
        else zero.next = twoHead.next;

        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }
    //? Time Complexity : O(N)
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
        // head = sortaLLOf_0_1_and2(head);
        // printLL(head);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(1)

        //* Optimal : 
        head = Sort_a_LL_Of_0_1_and_2(head);
        printLL(head);
    }
}
