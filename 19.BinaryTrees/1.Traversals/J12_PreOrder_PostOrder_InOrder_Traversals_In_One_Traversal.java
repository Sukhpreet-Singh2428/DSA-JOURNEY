//* PreOrder, InOrder, PostOrder Traversals in One Traversal
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

class Pair{
    Node node;
    int num;

    public Pair(Node node, int num){
        this.node = node;
        this.num = num;
    }
}

public class J12_PreOrder_PostOrder_InOrder_Traversals_In_One_Traversal {

    //? PreOrder, InOrder, PostOrder Traversals in One Traversal
    public static void PreOrder_InOrder_PosyOrder(Node root){
        Stack<Pair> st = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if(root == null) return;
        st.push(new Pair(root, 1));

        while(!st.isEmpty()){
            Pair it = st.pop();

            //? preorder
            if(it.num == 1){
                preOrder.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left, 1));
                }
            }

            //? inorder
            else if(it.num == 2){
                inOrder.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right, 1));
                }
            }

            //? postorder
            else{
                postOrder.add(it.node.data);
            }
        }


        System.out.println("PreOrder : " + preOrder);
        System.out.println("InOrder : " + inOrder);
        System.out.println("PostOrder : " + postOrder);
    }
    //? Time Complexity : O(3N)
    //? Space Complexity : O(4N)
    
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

        PreOrder_InOrder_PosyOrder(root);
    }
}
