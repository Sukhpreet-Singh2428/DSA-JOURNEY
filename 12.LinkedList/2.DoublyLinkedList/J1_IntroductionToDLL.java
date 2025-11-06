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
public class J1_IntroductionToDLL {
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

    public static Node InsertBeforeHead(Node head, int val){
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
    }

    public static Node InsertBeforeTail(Node head, int val){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        Node prev = tail.back;
        Node temp = new Node(val, tail, prev);
        tail.back = temp;
        prev.next = temp;
        return head;
    }

    public static Node InsertBeforeKthElement(Node head, int k, int val){
        Node current = head;
        int cnt = 0;
        while(current != null){
            cnt++;
            if(cnt == k) break;
            current = current.next;
        }
        Node prev = current.back;
        Node front = current.next;
        if(prev == null){
            return InsertBeforeHead(head, val);
        }
        else if(front == null){
            return InsertBeforeTail(head, val);
        }
        Node temp = new Node(val, front, prev);
        prev.next = temp;
        front.back = temp;
        return head;
    }

    public static void insertBeforeGivenNode(Node temp, int val){
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
    }

    public static void printDLL(Node head){
        Node current = head;    //? name it as prev or current
        while(current != null){
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){

        //? What is DLL ? 
        //* when we can move in both the directions in Linked List.
        //* That's doubly LinkedList


        //? Representation in c++/Java
        //* Just added back pointer too, for go back in direction and that is what doubly linked list is.
        //* Similar to LL, just add back in Node class


        //? Array to DLL :
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
        // deleteNode(head.next);   //* Node pass : Node != head
        // printDLL(head);



        //? Insertion of Node :  --> before head, before tail, before Kth element, before Node

        //? Insertion before head : 
        // head = InsertBeforeHead(head, 10);
        // printDLL(head);

        //? Insertion before Tail : 
        // head = InsertBeforeTail(head, 10);
        // printDLL(head);

        //? Insertion before Kth element : 
        // head = InsertBeforeKthElement(head, 2, 10);
        // printDLL(head);

        //? Insertion before given Node :   (given --> Node != head)
        insertBeforeGivenNode(head.next, 10);
        printDLL(head);
    }
}
