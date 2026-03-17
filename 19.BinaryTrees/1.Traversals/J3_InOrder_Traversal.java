//* Inorder Traversal  (Recursive)
//! (Easy)

//? Traversal Techniques (BFS/DFS)
//! BFS => Breadth First Search  (we go level by level)
//! DFS => Depth first Search  (we go in depth first)

//? 1. Inorder traversal (Left Root Right)     (DFS)

//? 2. Pre-order Traversal (Root Left Right)   (DFS)

//? 3. Post-order Traversal (Left Right Root)  (DFS)


//* Inorder Traversal : 
//?    Left        Root       Right
//?   (Travel)   (Access)    (Travel)

//? To perform the inorder traversal, we follow these steps:
//? 1. First, we check if the current node is null. If it is, we return because there is nothing to process.
//? 2. If the current node is not null, we move to the left child of the current node and repeat the process.
//? 3. Once we reach a node with no left child, we process the current node.
//? 4. After processing the current node, we move to the right child and apply the same steps.

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

public class J3_InOrder_Traversal {
    //? Inorder Traversal : (Recursive)
    public static void InOrder(Node root, List<Integer> ls){
        if(root == null){
            return;
        }

        InOrder(root.left, ls);
        ls.add(root.data);
        InOrder(root.right, ls);
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
        InOrder(root, ls);
        //? Time Complexity : O(N) , where N is the no. of nodes in the Binary Tree
        //? Space Complexity : if tree is linear, means single childs then O(N) [Stack Space]
        //?                    if tree is Balanced binary tree then O(log2N) {log2N is the height of balanced binary tree}

        for(int x : ls){
            System.out.print(x + " ");
        }
        //? 4 2 8 5 1 6 3 9 7 10
    }
}
