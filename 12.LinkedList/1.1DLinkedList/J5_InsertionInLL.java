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
public class J5_InsertionInLL {

    public static Node insertHead(Node head, int val){
        if(head == null){
            return new Node(val);
        }
        Node temp = new Node(val, head);
        return temp;
    }

    public static Node insertTail(Node head, int val){
        if(head == null){
            return new Node(val);
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        Node temp = new Node(val, null);
        current.next = temp;
        return head;
    }

    public static Node insertkthElement(Node head, int val, int k){
        if(head==null){
            if(k==1) return new Node(val);
            else return null;
        }
        if(k==1){
            return insertHead(head, val);
        }
        Node current = head;
        int cnt = 0;
        while(current != null){
            cnt++;
            if(cnt == k-1){
                Node temp = new Node(val, current.next);
                current.next = temp;
                break;
            }
            current = current.next;
        }
        return head;
    }

    public static Node insertGivenNode(Node head, int el, int val){
        if(head==null){
            return null;
        }
        if(head.data == val){
            return new Node(el, head);
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == val){
                Node temp = new Node(el, current.next);
                current.next = temp;
                break;
            }
            current = current.next;
        }
        return head;
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
            System.out.print(current.data + "-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrToLL(arr);
        printLL(head);
        
        //? Insertion in Linked List 
        //? --> Head, Kth element, value, last/Tail

        //? Insert at Head
        // head = insertHead(head, 5);
        // printLL(head);

        //? Insert at the last/Tail
        // head = insertTail(head, 37);
        // printLL(head);

        //? Insert at the Kth element/place   (1 <= k <= N)
        // head = insertkthElement(head, 29, 2);
        // printLL(head);

        //? Insert Value before the value x  (insert before the given Node)
        insertGivenNode(head, 10, 3);
        printLL(head);
    }
}
