//* Minimum Depth in Binary Tree
//? (Minimum Height of a Tree)
//! (Medium Problem)

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

public class J6_Minimum_Depth_in_BT {

    //* Optimal : 
    public static int minDepth(Node root){
        if(root == null){
            return 0;
        }

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(l==0 || r==0){
            return 1 + Math.max(l,r);   //? return 1 + l + r
        }

        return 1 + Math.min(l,r);
    }
    //? Time Complexity : for balanced tree => O(logN)
    //?                   for skew tree => O(N)
    //? Space Complexity : O(N) [recursive stack space]
    
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
        int ans = minDepth(root);
        System.out.println(ans);
        //? Time Complexity : for balanced tree => O(logN)
        //?                   for skew tree => O(N)
        //? Space Complexity : O(N) [recursive stack space]

    }
}
