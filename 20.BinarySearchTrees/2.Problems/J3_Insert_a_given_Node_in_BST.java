//* Insert a given Node in BST
//! (Medium Problem)

import java.util.ArrayList;
import java.util.List;

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

public class J3_Insert_a_given_Node_in_BST {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static TreeNode insert_a_given_NodeInBST(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }

        TreeNode curr = root;
        while(true){
            if(curr.val <= val){
                if(curr.right != null){
                    curr = curr.right;
                }
                else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(curr.left != null){
                    curr = curr.left;
                }
                else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
    //? Time Complexity : O(log2N)
    //? Time Complexity : O(H) {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}
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
        TreeNode ans = insert_a_given_NodeInBST(root, 12);
        List<Integer> ls = new ArrayList<>();
        inorder(ans, ls);
        System.out.println(ls);
        //? Time Complexity : O(log2N)
        //? Time Complexity : O(H) {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}
        //? Space Complexity : O(1)
        
    }
    public static void inorder(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }

        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
}
