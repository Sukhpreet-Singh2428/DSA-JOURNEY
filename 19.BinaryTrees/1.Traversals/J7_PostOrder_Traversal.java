//* PostOrder Traversal 
//! (Easy)

//* PostOrder Traversal : 
//?    Left        Right       Root
//?   (Travel)   (Travel)    (Access)

import java.util.ArrayList;
import java.util.List;

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

public class J7_PostOrder_Traversal {

    //? PostOrder Traversal :   (Recursive)
    public static void PostOrder(Node root, List<Integer> ls){
        if(root == null){
            return;
        }

        PostOrder(root.left, ls);
        PostOrder(root.right, ls);
        ls.add(root.data);
    }
    //? Time Complexity : O(N) , where N is the no. of nodes in the Binary Tree
    //? Space Complexity : if tree is linear, means single childs then O(N) [Stack Space]
    //?                    if tree is Balanced binary tree then O(log2N) {log2N is the height of balanced binary tree}

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
        //? Time Complexity : O(N) , where N is the no. of nodes in the Binary Tree
        //? Space Complexity : if tree is linear, means single childs then O(N) [Stack Space]
        //?                    if tree is Balanced binary tree then O(log2N) {log2N is the height of balanced binary tree}

        for(int x : ls){
            System.out.print(x + " ");
        }
        //? 4 8 5 2 6 9 10 7 3 1 
    }
}
