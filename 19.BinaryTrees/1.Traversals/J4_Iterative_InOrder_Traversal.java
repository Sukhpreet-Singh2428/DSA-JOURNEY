//* InOrder Traversal  (Iterative)
//! (Easy)

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

public class J4_Iterative_InOrder_Traversal {

    //? Inorder Traversal :  (Iterative)
    public static void InOrder(Node root, List<Integer> ls){
        Stack<Node> st = new Stack<>();
        Node node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }

                node = st.peek();
                st.pop();
                ls.add(node.data);
                node = node.right;
            }
        }
    }
    //? Time Complexity : O(N)
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
        InOrder(root, ls);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)

        for(int x : ls){
            System.out.print(x + " ");
        }
        //? 4 2 8 5 1 6 3 9 7 10
    }
}
