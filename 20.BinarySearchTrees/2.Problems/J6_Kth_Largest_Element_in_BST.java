//* Kth Largest Element in BST
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

public class J6_Kth_Largest_Element_in_BST {

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
    public static int kth_Largest(TreeNode root, int k){
        List<Integer> ls = new ArrayList<>();

        inorder(root, ls);

        int x = ls.size() - k;
        return ls.get(x);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N) [ls : storing elements] + O(H) [Recursive Stack Space]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}


    //* Better : 
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
        if(cnt==k){
            val = root.val;
        }
        inorder(root.right, k);
    }
    public static int traversal(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1 + traversal(root.left) + traversal(root.right);
    }
    public static int kthLargestElement(TreeNode root, int k){
        int total = traversal(root);

        cnt = 0;
        val = 0;

        int newK = total - k + 1;
        inorder(root, newK);

        return val;
    }
    //? Time Complexity : O(N) + O(N)
    //? Space Complexity : O(H)  [Recursive Stack Space used]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}


    //* Optimal :
    static int Cnt;
    static int Val;
    public static void reverseInorder(TreeNode root, int k){
        if(root==null){
            return;
        }
        if(Cnt>=k){
            return;
        }

        reverseInorder(root.right, k);
        Cnt++;
        if(Cnt==k){
            Val = root.val;
        }
        reverseInorder(root.left, k);
    }
    public static int kth_LargestElement(TreeNode root, int k){
        Cnt = 0;
        Val = 0;
        reverseInorder(root, k);

        return Val;
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
        // int ans = kth_Largest(root, 3);
        // System.out.println(ans);
        //? Time Complexity : O(N)  
        //? Space Compexity : O(N) [ls : storing elements] + O(H) [Recursive Stack Space]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}


        //* Better : 
        // int ans = kthLargestElement(root, 3);
        // System.out.println(ans);
        //? Time Complexity : O(N) + O(N)
        //? Space Complexity : O(H)  [Recursive Stack Space used]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}


        //* Optimal :
        int ans = kth_LargestElement(root, 3);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(H)  [Recursive Stack Space used]  {H is the height/depth of BST, for Balanced BST it's going to be O(logN) and for skew BST it's going to be O(N)}

        //* Optimal : 
        //! We can even optimize by using Morris Inorder Traversal, which takes O(1) in Space instead of recursive Inorder Traversal
    }
}
