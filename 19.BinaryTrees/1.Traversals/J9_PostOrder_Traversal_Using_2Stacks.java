//* PostOrder Traversal Using 2 Stacks
//! (Easy)

//? Almost similar implementation as Iterative_PostOrder_Traversal.java
//? In Iterative_PostOrder_Traversal.java we are doing => Root Right left + reverse
//? Here, we are doing similar think but instead of reverse, we are using another stack 
//? to store and then pop it which doings similar work

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class J9_PostOrder_Traversal_Using_2Stacks {

    //? PostOrder Traversal Using 2 Stacks : 
    public static void PostOrder(Node root, List<Integer> ls){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        if(root != null) st1.push(root);

        while(!st1.isEmpty()){
            Node node = st1.pop();
            st2.push(node);

            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }

        while(!st2.isEmpty()){
            ls.add(st2.pop().data);
        }
    }
    //? Time Complexity : O(N) + O(N)
    //? Space Complexity : O(N)


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        List<Integer> ls = new ArrayList<>();
        PostOrder(root, ls);
        //? Time Complexity : O(N) + O(N)
        //? Space Complexity : O(N)

        for(int x : ls){
            System.out.print(x + " ");
        }
        //? 4 8 5 2 6 9 10 7 3 1 
    }
}
