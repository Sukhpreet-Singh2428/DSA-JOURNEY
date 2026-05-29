//* Print Root to Leaf Path in Binary Tree
//! (Medium Problem)

import java.util.ArrayList;
import java.util.List;

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

public class J1_Print_Root_to_Leaf_Path_in_BT {
    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static void traversal(TreeNode root, List<List<Integer>> ans, List<Integer> ls){
        if(root==null){
            return;
        }

        ls.add(root.val);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(ls));
        }
        traversal(root.left, ans, ls);
        traversal(root.right, ans, ls);
        ls.remove(ls.size()-1);

    }
    public static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        traversal(root, ans, ls);
        return ans;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(height) [stack space] {for balanced tree => O(logN), for skew tree => O(N)}
    //?                    {Ignoring the space used to store the answer, as it is needed to return in data structure}
    
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

        //* Optimal : 
        List<List<Integer>> ans = allRootToLeaf(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(height) [stack space] {for balanced tree => O(logN), for skew tree => O(N)}
        //?                    {Ignoring the space used to store the answer, as it is needed to return in data structure}
    }
}
