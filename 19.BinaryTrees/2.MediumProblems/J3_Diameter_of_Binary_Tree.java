//* Diameter of Binary Tree
//! (Easy Problem)

//? Diameter of Binary Tree => longest path between 2 nodes
//?                         => path can be or cannot be pass via root

//? To determine the diameter of a binary tree, consider each node as a potential Curving Point 
//? in the path that forms the diameter. This Curving Point represents the node at the maximum height 
//? along the diameter path, where the path transitions between ascending and descending. 
//? The diameter at a particular Curving Point is calculated by adding the height of the left subtree to the height of the right subtree. 
//? This can be expressed as:
//? Diameter = Left Subtree Height + Right Subtree Height

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

public class J3_Diameter_of_Binary_Tree {

    //* Brute : 
    public static int height(Node root){
        if(root==null) return 0;

        int l = height(root.left);
        int r = height(root.right);

        return 1 + Math.max(l,r);
    }
    public static void diameter_BT(Node root, int[] maxi){
        if(root==null) return;

        int l = height(root.left);
        int r = height(root.right);

        maxi[0] = Math.max(maxi[0], l+r);

        diameter_BT(root.left, maxi);
        diameter_BT(root.right, maxi);
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N)  [Stack Space]


    //* Optimal : 
    //? (Modified the Height of Tree or Maximum Depth of Tree code so that we can in Single Space i.e, O(N))
    public static int Height(Node root, int[] maxi){
        if(root==null){
            return 0;
        }

        int l = Height(root.left, maxi);
        int r = Height(root.right, maxi);
        maxi[0] = Math.max(maxi[0], l+r);

        return 1 + Math.max(l,r);
    }
    public static int Diameter_BT(Node root){
        int[] maxi = new int[1];
        Height(root, maxi);
        return maxi[0];
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N) [Stack Space]
    
    
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

        //* Brute : 
        // int[] maxi = new int[1];
        // diameter_BT(root, maxi);
        // System.out.println(maxi[0]);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N)  [Stack Space]


        //* Optimal : 
        int ans = Diameter_BT(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) [Stack Space]

    }
}
