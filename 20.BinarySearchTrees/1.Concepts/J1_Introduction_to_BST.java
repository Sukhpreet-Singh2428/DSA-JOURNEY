//* Introduction to Binary Search Tree

//! In BST : 
//* L < N < R
//? also it's 
//* left subtree --> BST
//* right subtree --> BST

//?  =>  Inorder traversal in BST gives nodes (or it's values) in sort order/increasing order/ascending order
//?  => Generally, duplicates are not allowed in BST, as condition is L < N < R
//?  => The height/depth of the Balanced BST = O(log2N) and worst BST = O(N) {skew BST}

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

public class J1_Introduction_to_BST {
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

        //? This is an Binary Search tree
        //? As root is 8 and it's left is smaller than it i.e, 3 and it's right is greater than it i.e, 10
        //* so it is satisfying the L < N < R
        //! NOTE : For whole tree to be called as Binary Search Tree, it's lef subtree should be BST as well
        //! and it's right subtree should be BST as well then the whole tree is said to be BST
        //? Everything to the left is smaller and everything to the right is greater 
        //? As for example : let's take for root i.e, 8 everything to its left is smaller than 8 and eveything to its right is greater than 8
        //* So here, Search is going to be easy as we don't need to traverse the whole tree we just need
        //* to either go left or go right [or just need to return root or subtree root if its equal to target]
        //* It is similiar to binary search, that's why it is named as Binary Search Tree

    }
}
