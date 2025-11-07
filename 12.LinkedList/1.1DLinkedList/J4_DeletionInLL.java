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
public class J4_DeletionInLL {
    public static Node deleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteKthElement(Node head, int k){
        if(head == null) return head;
        if(k == 1){
            head = head.next;
            return head;
        }
        Node current = head;
        int cnt = 0;
        Node prev = null;
        while(current != null){
            cnt++;
            if(cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    
    public static Node deleteValue(Node head, int val){
        if(head == null) return head;
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node current = head;
        Node prev = null;
        while(current != null){
            if(current.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = current;
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
        
        //? Deletion in Linked List 
        //? --> Head, Kth element, value, last/Tail

        //? delete the head of the LL 
        // head = deleteHead(head);
        // printLL(head);

        //? delete the tail of the LL
        // head = deleteTail(head);
        // printLL(head);

        //? delete the Kth element of LL
        // head = deleteKthElement(head, 3);
        // printLL(head);

        //? delete the given value of LL 
        int val = 3;
        head = deleteValue(head, val);
        printLL(head);
    }
}
