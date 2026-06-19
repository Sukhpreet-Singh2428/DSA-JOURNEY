//* Kth Smallest Element in BST 
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

public class J5_Kth_Smallest_Element_in_BST {

    //* Brute --> Better --> Optimal 


    //* Brute : 
    public static void inorder(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }

        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
    public static int kth_Smallest(TreeNode root, int k){
        if(root==null) return -1;

        List<Integer> ls = new ArrayList<>();

        inorder(root, ls);

        return ls.get(k-1);
    }
    //? Time Complexity : O(N)  
    //? Space Compexity : O(N) [ls : storing elements] + O(H) [Recursive Stack Space]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}


    //* Optimal : 
    static int cnt;
    static int val;
    public static void inorder(TreeNode root, int k){
        if(root==null){
            return;
        }
        if(cnt>=k){
            return;
        }

        inorder(root.left, k);
        cnt++;
        if(cnt == k){
            val = root.val;
        }
        inorder(root.right, k);
    }
    public static int kthSmallestElement(TreeNode root, int k){
        if(root==null){
            return -1;
        }

        //? Either we can create 1 size array for cnt or we can use as class variable cnt. Here, Using Class variable/global variable
        cnt = 0;
        val = 0;

        inorder(root, k);

        return val;
    }
    //? Time Complexity : O(N)  
    //? Space Complexity : O(H)  [Recursive Stack Space used]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}

    //* Optimal : 
    //! We can even optimize by using Morris Inorder Traversal, which takes O(1) in Space instead of recursive Inorder Traversal

    
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
        // int ans = kth_Smallest(root, 3);
        // System.out.println(ans);
        //? Time Complexity : O(N)  
        //? Space Compexity : O(N) [ls : storing elements] + O(H) [Recursive Stack Space]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}


        //* Optimal : 
        int ans = kthSmallestElement(root, 3);
        System.out.println(ans);
        //? Time Complexity : O(N)  
        //? Space Complexity : O(H)  [Recursive Stack Space used]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}

        //* Optimal : 
        //! We can even optimize by using Morris Inorder Traversal, which takes O(1) in Space instead of recursive Inorder Traversal
    }
}
