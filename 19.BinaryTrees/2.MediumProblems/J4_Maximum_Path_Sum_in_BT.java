//* Maximum Path Sum in Binary Tree
//! (Medium Problem)

//? Path => distance between any two nodes
//?      => node A to node B (in which a single node only appears once's)

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

public class J4_Maximum_Path_Sum_in_BT {

    //* Optimal : 
    //? (similar concept going like in the Maximum height(depth) of tree and Maxium width(diameter) of tree)
    public static int maxPath(Node root, int[] maxi){
        if(root==null){
            return 0;
        }

        int leftSum = Math.max(0, maxPath(root.left, maxi));  //? using Math.max here bcz if we get negative sum from left subtree then we ignore that negative so that we can get maximum path sum in future, so we will return 0 here
        int rightSum = Math.max(0, maxPath(root.right, maxi)); //? using Math.max here bcz if we get negative sum from right subtree then we ignore that negative so that we can get maximum path sum in future, so we will return 0 here
        maxi[0] = Math.max(maxi[0], leftSum + rightSum + root.data);

        return root.data + Math.max(leftSum, rightSum);  //? In order to decide which path/route to take by parent, that's why Math.max(leftSum, rightSum)
    }
    public static int maximum_PathSum(Node root){
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPath(root, maxi);
        return maxi[0];
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
        int ans = maximum_PathSum(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)

    }
}
