//* Lowest Common Ancestor (LCA) in Binary Tree
//! (Hard Problem)

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

public class J2_LCA_in_BT {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static boolean func(TreeNode root, TreeNode node, List<TreeNode> ls){
        if(root==null){
            return false;
        }

        ls.add(root);

        if(root == node){
            return true;
        }
        
        if( func(root.left, node, ls) || func(root.right, node, ls) ){
            return true;
        }

        ls.remove(ls.size()-1);
        return false;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q) return root;

        List<TreeNode> pathOfP = new ArrayList<>();
        func(root, p, pathOfP);

        List<TreeNode> pathOfQ = new ArrayList<>();
        func(root, q, pathOfQ);

        int i=0;
        int j=0;
        TreeNode ans = null;
        while(i<pathOfP.size() && j<pathOfQ.size()){
            if(pathOfP.get(i) != pathOfQ.get(j)){
                break;
            }
            ans = pathOfP.get(i);
            i++;
            j++;
        }

        return ans;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static TreeNode Lowest_CommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left = Lowest_CommonAncestor(root.left, p, q);
        TreeNode right = Lowest_CommonAncestor(root.right, p, q);

        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N) [auxilary stack space used] {for skew tree : O(N), for Balanced tree : O(logN)}
    

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


        //* Brute : 
        // TreeNode ans = lowestCommonAncestor(root, root.left.left, root.left.right.left);
        // System.out.println(ans.val);  //? ans = root.left => 2
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)


        //* Optimal : 
        TreeNode ans = Lowest_CommonAncestor(root, root.left.left, root.left.right.left);
        System.out.println(ans.val);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) [auxilary stack space used] {for skew tree : O(N), for Balanced tree : O(logN)}

    }
}
