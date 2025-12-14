//* Find Pairs with given sum in Sorted Doubly Linked List
//! (Medium Problem)

import java.util.ArrayList;
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

public class J2_FindPairsWithGivenSumInSorted_DLL {
    
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(Node head, int sum){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node temp1 = head;
        while(temp1 != null){
            Node temp2 = temp1.next;
            while(temp2 != null){
                if(temp1.data + temp2.data == sum){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(temp1.data);
                    arr.add(temp2.data);
                    ans.add(arr);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        return ans;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(1)


    //* Better : 
    public static ArrayList<ArrayList<Integer>> FindPairsWithGivenSum(Node head, int sum){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node temp1 = head;
        while(temp1 != null){
            Node temp2 = temp1.next;
            while(temp2 != null){
                if(temp1.data + temp2.data == sum && temp1.data + temp2.data <= sum){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(temp1.data);
                    arr.add(temp2.data);
                    ans.add(arr);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }

        return ans;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static ArrayList<ArrayList<Integer>> FindPairsWithGivenSumIn_DLL(Node head, int target){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node left = head;
        Node right = head;
        while(right.next != null){
            right = right.next;
        }

        while(left.data < right.data){
            int sum = left.data + right.data;
            if(sum == target){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(left.data);
                arr.add(right.data);
                ans.add(arr);
                left = left.next;
                right = right.back;
            }
            else if(sum > target){
                right = right.back;
            }
            else{
                left = left.next;
            }
        }

        return ans;
    }
    //? Time Complexity : O(2N)
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
        int sum = scanner.nextInt();
        scanner.close();

        Node head = convertArrToDLL(arr);
        printDLL(head);

        //* Brute : 
        // ArrayList<ArrayList<Integer>> ans = findPairsWithGivenSum(head, sum);
        // for(int i=0; i<ans.size(); i++){
        //     for(int j=0; j<ans.get(i).size(); j++){
        //         System.out.print(ans.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)


        //* Better : 
        // ArrayList<ArrayList<Integer>> ans = FindPairsWithGivenSum(head, sum);
        // for(int i=0; i<ans.size(); i++){
        //     for(int j=0; j<ans.get(i).size(); j++){
        //         System.out.print(ans.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)


        //* Optimal : 
        ArrayList<ArrayList<Integer>> ans = FindPairsWithGivenSumIn_DLL(head, sum);
        for(int i=0; i<ans.size(); i++){
            for(int j=0; j<ans.get(i).size(); j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        //? Time Complexity : O(2N)
        //? Space Complexity : O(1)
    }
}
