//* Maximum Depth in Binary Tree  (or Height of a Tree)
//! (Medium Problem)

import java.util.ArrayDeque;
import java.util.Queue;

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

public class J1_Maximum_Depth_in_BT {

    //* Recursive solution : 
    //? DFS
    public static int maxDepth(Node root){
        if(root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l,r);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N) [Stack Space]


    //* Iterative Solution : (using Level Order Traversal)
    //? BFS
    public static int Max_Depth(Node root){
        if(root == null) return 0;

        Queue<Node> qu = new ArrayDeque<>();
        qu.offer(root);
        int level = 0;

        while(!qu.isEmpty()){
            int size = qu.size();

            for(int i=0; i<size; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                qu.poll();
            }

            level++;
        }

        return level;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(W), where W is the maximum width of the tree
    
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

        //* Recursive Solution : 
        int ans = maxDepth(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) [Stack Space]


        //* Iterative Solution : (using Level Order Traversal)
        // int ans = Max_Depth(root);
        // System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(W), where W is the maximum width of the tree
    }
}
