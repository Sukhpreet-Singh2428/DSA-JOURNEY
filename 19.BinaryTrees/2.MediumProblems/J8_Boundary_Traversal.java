//* Boundary Traversal
//! (Medium Problem)


//?         1
//?       /   \
//?      2     3
//?    /   \   / \
//?   4     5 6   7
//?        /      / \
//?       8      9  10
//* Boundary Traversal => 1 2 4 8 6 9 10 7 3

//! Boundary Traversal : 
//? 1. Left Boundary excluding Leaf nodes
//? 2. Leaf nodes
//? 3. Right Boundary in the Reverse direction and excluding the Leaf nodes

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


public class J8_Boundary_Traversal {

    //* Optimal : 
    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    public static void addLeftBoundary(Node root, List<Integer> res){
        Node curr = root.left;
        while(curr != null){
            if(isLeaf(curr) == false) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void addRightBoundary(Node root, List<Integer> res){
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr != null){
            if(isLeaf(curr) == false) st.push(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while(!st.isEmpty()){
            res.add(st.pop());
        }
    }
    public static void addLeaves(Node root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, res);
        if(root.right != null) addLeaves(root.right, res);
    }
    public static List<Integer> BoundaryTraversal(Node root){
        List<Integer> ans = new ArrayList<>();

        if(isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
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


        //* Optimal : 
        List<Integer> ans = BoundaryTraversal(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)

    }
}
