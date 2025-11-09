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
public class J2_DeletionInDLL {
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

    public static Node deleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;   //? we removed the link of that particular node completely
        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail;
        tail = tail.back;
        tail.next = null;
        prev.back = null;

        return head;
    }

    public static Node deleteKthElement(Node head, int k){
        if(head == null){
            return null;
        }
        Node temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null && front == null){  //? Means single element Doubly LinkedList
            return null;
        }
        else if(prev == null){   //? Means we are standing at head
            head = deleteHead(head);
        }
        else if(front == null){   //? Means we are standing at Tail
            head = deleteTail(head);
        }
        else{
            prev.next = front;
            front.back = prev;
            temp.next = null;
            temp.back = null;
        }
        return head;
    }

    public static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

        if(front == null){
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;
    }

    public static void printDLL(Node head){
        Node current = head;    //? name it as prev or current
        while(current != null){
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        
        int[] arr = {1, 3, 2, 4};
        Node head = convertArrToDLL(arr);
        printDLL(head);


        //? Deletion of Node :   --> head, tail, kth, given Node

        //? Delete the Head of DLL
        // head = deleteHead(head);
        // printDLL(head);

        //? Delete the tail of DLL
        // head = deleteTail(head);
        // printDLL(head);

        //? Delete the kth element of DLL
        // int k = 3;
        // head = deleteKthElement(head, k);
        // printDLL(head);

        //? Delete the Given Node of DLL  (given --> Node != head)
        deleteNode(head.next);   //* Node pass : Node != head
        printDLL(head);
    }
}
