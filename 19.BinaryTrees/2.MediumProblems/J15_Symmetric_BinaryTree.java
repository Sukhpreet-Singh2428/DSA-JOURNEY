//* Symmetric Binary Tree
//! (Medium Problem)

//? Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//? Example 
//? Input : root = [1, 2, 2, 3, 4, 4, 3]
//? Output : true

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class J15_Symmetric_BinaryTree {
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static boolean isSame(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    public static void mirror(TreeNode root){
        Queue<TreeNode> qu = new ArrayDeque<>();
        if(root==null) return;
        qu.offer(root);

        while(!qu.isEmpty()){
            // int levelNum = qu.size();
            TreeNode leftChild = qu.peek().left;
            TreeNode rightChild = qu.peek().right;
            
            qu.peek().left = rightChild;
            qu.peek().right = leftChild;
            if(rightChild!=null) qu.offer(rightChild);
            if(leftChild!=null) qu.offer(leftChild);
            qu.poll();  
        }
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;
        
        mirror(root2);

        return isSame(root1, root2);
    }
    //? Time Complexity : O(right part of tree for mirroring) + O(N)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static boolean symmetry(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }
    public static boolean Is_Symmetric(TreeNode root){
        if(root==null){
            return true;
        }

        return symmetry(root.left, root.right);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(height) [stack space] {for balanced tree => O(logN), for skew tree => O(N)}
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        //* Brute --> Better --> Optimal 

        //* Brute : 
        // boolean ans = isSymmetric(root);
        // System.out.println(ans);
        //? Time Complexity : O(right part of tree for mirroring) + O(N)
        //? Space Complexity : O(N)

        //* Optimal : 
        boolean ans = Is_Symmetric(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(height) [stack space] {for balanced tree => O(logN), for skew tree => O(N)}
    }
}
