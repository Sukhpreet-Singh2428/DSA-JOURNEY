//* Find the Intersection point of Y Linked List
//! (Medium Problem)

//? intersectVal = 4, skipA = 3, skipB = 2, listA: head -> 1 -> 2 -> 3 -> 4 -> 5, listB: head -> 7 -> 8 -> 4 -> 5
//? return --> 4 [return, Y intersection Node or otherwise null]

import java.util.HashMap;
import java.util.Map;
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

public class J10_FindTheIntersectionPointofY_LL {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Node findTheIntersctionPointYinLL(Node head1, Node head2){
        Map<Node, Integer> mpp = new HashMap<>();

        Node temp = head1;
        while(temp != null){
            mpp.put(temp, 1);
            temp = temp.next;
        }

        temp = head2;
        while(temp != null){
            if(mpp.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }

        return null;

    }
    //? Time Complexity : O(N1 + N2)
    //? Space Complexity : O(N1)


    //* Better : 
    public static Node collisionPoint(Node smaller_LL, Node longer_LL, int d){
        while(d > 0){
            d--;
            longer_LL = longer_LL.next;
        }

        while(smaller_LL != longer_LL){
            smaller_LL = smaller_LL.next;
            longer_LL = longer_LL.next;
        }

        return smaller_LL;
    }
    public static Node FindTheIntersction_PointY_inLL(Node head1, Node head2){
        
        Node temp1 = head1;
        int len1 = 0;
        while(temp1 != null){
            len1++;
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        int len2 = 0;
        while(temp2 != null){
            len2++;
            temp2 = temp2.next;
        }

        if(len1 < len2){
            return collisionPoint(head1, head2, len2-len1);      //? collisionPoint(smaller, longer, d)
        }
        else{
            return collisionPoint(head2, head1, len1-len2);      //? collisionPoint(smaller, longer, d)
        }
    }
    //? Time Complexity : O(N1) + O(N2) + O(N2 - N1) + O(N1)
    //?                   O(N1 + 2N2)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static Node FindThe_IntersctionPointY_inLL(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return null;
        }

        Node temp1 = head1;
        Node temp2 = head2;
        
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1 == temp2) return temp1;

            if(temp1 == null) temp1 = head2;
            if(temp2 == null) temp2 = head1;
        }
        return temp1;
    }
    //? Time Complexity : O(N1 + N2)
    //? Space Complexity : O(1)


    public static void main(String[] args) {

        //? Creating the shared part of the list
        Node intersection = new Node(4);
        intersection.next = new Node(6);
        intersection.next.next = new Node(2);

        //? Building first list
        Node head1 = new Node(3);
        head1.next = new Node(1);
        head1.next.next = intersection;  //? attaching the intersection part

        //? Building second list
        Node head2 = new Node(1);
        Node temp2 = head2;
        temp2.next = new Node(2);
        temp2 = temp2.next;
        temp2.next = new Node(4);
        temp2 = temp2.next;
        temp2.next = new Node(5);
        temp2 = temp2.next;
        temp2.next = intersection;  //? attaching the same intersection part


        //* Brute : 
        // Node ans = findTheIntersctionPointYinLL(head1, head2);
        // if(ans == null) System.out.println("null");
        // else System.out.println(ans.data);
        //? Time Complexity : O(N1 + N2)
        //? Space Complexity : O(N1)


        //* Better : 
        // Node ans = FindTheIntersction_PointY_inLL(head1, head2);
        // if(ans == null) System.out.println("null");
        // else System.out.println(ans.data);
        //? Time Complexity : O(N1) + O(N2) + O(N2 - N1) + O(N1)
        //?                   O(N1 + 2N2)
        //? Space Complexity : O(1)


        //* Optimal : 
        Node ans = FindThe_IntersctionPointY_inLL(head1, head2);
        if(ans == null) System.out.println("null");
        else System.out.println(ans.data);
    }
}
