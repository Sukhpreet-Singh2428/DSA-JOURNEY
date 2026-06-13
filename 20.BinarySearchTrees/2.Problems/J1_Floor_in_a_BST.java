//* Floor in a Binary Search Tree
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

public class J1_Floor_in_a_BST {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static int floor_in_a_BST(TreeNode root, int key){
        int floor = -1;

        while(root != null){
            if(root.val == key){
                floor = root.val;
                return floor;
            }

            if(key > root.val){
                floor = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }

        return floor;
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
        int floor = floor_in_a_BST(root, 5);
        System.out.println(floor);  //? 4
        //? Time Complexity : O(H) {for balanced BST, H = logN and for worst BST, H = N}
        //? Space Complexity : O(1)
        
    }
}
