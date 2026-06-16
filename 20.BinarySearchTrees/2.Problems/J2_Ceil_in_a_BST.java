//* Ceil in a Binary Search Tree
//! (Easy Problem)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class J2_Ceil_in_a_BST {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static int ceil_in_a_BST(TreeNode root, int key){
        int ceil = -1;

        while(root!=null){
            if(root.val == key){
                ceil = root.val;
                return ceil;
            }

            if(root.val < key){
                root = root.right;
            }
            else{
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
    //? Time Complexity : O(H) {for balanced BST, H = logN and for worst BST, H = N}
    //? Space Complexity : O(1)
    

    public static void main(String[] args) {

        //? BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        
        //* Optimal : 
        int ceil = ceil_in_a_BST(root, 5);
        System.out.println(ceil);  //? 6
        //? Time Complexity : O(H) {for balanced BST, H = logN and for worst BST, H = N}
        //? Space Complexity : O(1)
        
    }
}
