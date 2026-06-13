//* Search in a Binary Search Tree
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

public class J2_Search_in_a_Binary_Search_Tree {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    //! Iterative
    public static TreeNode Search_inBST(TreeNode root, int val){

        while(root!=null && root.val != val){
            root = (root.val > val) ? root.left : root.right;
        }

        return root;

    }
    //? Time Complexity : O(H) [H, Height/depth of the BST] {for balanced BST, H = logN and for worst BST, H = N}
    //? Space Complexity : O(1)

    //* Optimal :
    //! Recursive  
    public static TreeNode search_in_BST(TreeNode root, int val){
        if(root==null){
            return null;
        }

        if(root.val == val) return root;

        if(val < root.val){
            return search_in_BST(root.left, val);
        }
        else {    //? val > root.val
            return search_in_BST(root.right, val);
        }
    }
    //? Time Complexity : O(logN) {for balanced BST, if there is an skew BST then worst case : O(N)}
    //? Space Complexity : O(logN) [Recursive Stack Space] {for balanced BST, if there is an skew BST then worst case : O(N)}
    //* So basically can say 
    //? Time Complexity : O(H) [H, Height/depth of the BST] {for balanced BST, H = logN and for worst BST, H = N}
    //? Space Complexity : O(H) [H, Height/depth of the BST] {for balanced BST, H = logN and for worst BST, H = N}


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

        
        //* Brute : 
        //? We can simple do it like BT by using any of these : preorder, inorder, postorder
        //? and if node with value equal to target/val then just simple return it in the any of used traversal
        //? if not exists, then simply return null.
        //? This is an simple normal approach like we do in BT. but it's not BT, it's BST so we are not going to do like this
        //? Anyways, Time Complexity : O(N)
        //?          Space Complexity : O(N) [Recursive Stack Space]
        

        //* Optimal : 
        //! Recursive 
        TreeNode node = search_in_BST(root, 6);
        System.out.println(node.val);
        //? Time Complexity : O(logN) {for balanced BST, if there is an skew BST then worst case : O(N)}
        //? Space Complexity : O(logN) [Recursive Stack Space] {for balanced BST, if there is an skew BST then worst case : O(N)}
        //* So basically can say 
        //? Time Complexity : O(H) [H, Height/depth of the BST] {for balanced BST, H = logN and for worst BST, H = N}
        //? Space Complexity : O(H) [H, Height/depth of the BST] {for balanced BST, H = logN and for worst BST, H = N}

        //* Optimal : 
        //! Iterative
        TreeNode ans = Search_inBST(root, 6);
        System.out.println(ans.val);
        //? Time Complexity : O(H) [H, Height/depth of the BST] {for balanced BST, H = logN and for worst BST, H = N}
        //? Space Complexity : O(1)
    }
}
