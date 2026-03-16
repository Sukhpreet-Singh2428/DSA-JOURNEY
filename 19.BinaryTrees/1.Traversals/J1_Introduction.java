//* Introduction to Binary Tree

//! Refer J1_Introduction_Notes.md

//? Binary Tree Representation in Java 
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

public class J1_Introduction {
    public static void main(String[] args) {
        
        //? 1. What is Binary Tree ? 
        //* Node can have a maximum of 2 childern.  (Definition of binary tree)
        //! Refer J1_Introduction_Notes.md

        //? 2. Root, nodes, children, parent, ancestors, leaf node, subtree
        //! Refer J1_Introduction_Notes.md

        //? 3. Types of Binary Tree : 
        //* Full Binary Tree => all nodes must have 2 or 0 children

        //* Complete Binary Tree => 1. all levels must be completely filled except the last level
        //*                         2. the last level has all nodes in left as possible

        //* Perfect Binary Tree => 1. all leaf nodes are at the same level.
        //*                        2. all non leaf nodes must have 2 childern.
        //*                        or if every level is completely filled, then it is called as perfect binary tree

        //* Balance Binary Tree => height difference between left and right subtree at 
        //*                        any node must be at max. 1

        //* Degenerate Binary Tree => Every node has a single child
        //! Refer J1_Introduction_Notes.md


        //? Binary Tree Representation in Java 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        //*                     1
        //*                   /   \
        //*                  2     3
        //*                 /
        //*                4
    }
}
