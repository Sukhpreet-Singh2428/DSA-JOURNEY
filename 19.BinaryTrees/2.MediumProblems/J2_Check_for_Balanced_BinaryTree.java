//* Check for Balanced Binary Tree
//! (Medium Problem)

//? Balanced BT => for every node, height(left subtree) - height(right subtree) <= 1

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

public class J2_Check_for_Balanced_BinaryTree {

    //* Brute : 
    public static int height(Node root){
        if(root == null) return 0;

        int l = height(root.left);
        int r = height(root.right);

        return 1 + Math.max(l,r);
    }

    public static boolean balanced_BT_orNot(Node root){
        if(root == null){
            return true;
        }

        int l = height(root.left);
        int r = height(root.right);

        if(Math.abs(r-l) > 1) return false;
        
        boolean left = balanced_BT_orNot(root.left);
        boolean right = balanced_BT_orNot(root.right);

        if(!left || !right) return false;

        return true;
    }
    //? Time Complexity : O(N) * O(N) => O(N^2)
    //? Space Complexity : O(N) [Stack Space]


    //* Optimal : 
    //? (Modified the Height of Tree or Maximum Depth of Tree code so that we can in Single Space i.e, O(N))
    public static int Balanced_BT_OrNot(Node root){
        if(root==null) return 0;

        int l = Balanced_BT_OrNot(root.left);
        if(l==-1) return -1;
        int r = Balanced_BT_OrNot(root.right);
        if(r==-1) return -1;

        if(Math.abs(l-r) > 1) return -1;

        return 1 + Math.max(l,r);
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
        // boolean ans = balanced_BT_orNot(root);
        // System.out.println(ans);
        //? Time Complexity : O(N) * O(N) => O(N^2)
        //? Space Complexity : O(N) [Stack Space]


        //* Optimal : 
        int height = Balanced_BT_OrNot(root);
        if(height==-1) System.out.println(false);
        else System.out.println(true);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) [Stack Space]

    }
}
