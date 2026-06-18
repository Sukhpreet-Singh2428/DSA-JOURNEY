//* Delete a Node in Binary Search Tree
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

public class J4_Delete_a_Node_in_BST {

    //* Brute --> Better --> Optimal 


    //* Optimal : 
    //? To delete Node, we will connect the link with its left and then in left's right side we go the last right node and then connect its to the right child of delete Node. [All this satisfy BST property]
    public static TreeNode findLastRight(TreeNode root){
        if(root.right==null){
            return root;
        }
        return findLastRight(root.right);
    }
    public static TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right==null){
            return root.left;
        }

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }
    public static TreeNode deleteNode(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;

        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }

        return dummy;
    }
    //? Time Complexity : O(H)  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}
    //? Space Complexity : O(1)  [only findLastRight function uses Recursion Stack Space and that to for some k elements which are nodes comes in between till the last right node, if we write this part iterative as well then it's purely O(1)]

    
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
        root = deleteNode(root, 3);
        //? Time Complexity : O(H)  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}
        //? Space Complexity : O(1)  [only findLastRight function uses Recursion Stack Space and that to for some k elements which are nodes comes in between till the last right node, if we write this part iterative as well then it's purely O(1)]

        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);
        System.out.println(ls);
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
