//* Bottom View of Binary Tree
//! (Medium Problem)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class pair{
    int val;
    TreeNode node;

    public pair(int val, TreeNode node){
        this.val = val;
        this.node = node;
    }
}

public class J12_Bottom_View_of_BinaryTree {
    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<pair> qu = new ArrayDeque<>();
        qu.offer(new pair(0, root));
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        while(!qu.isEmpty()){
            int lvl = qu.size();

            for(int i=0; i<lvl; i++){
                pair curr = qu.peek();

                mp.put(curr.val, curr.node.data);
                
                if(curr.node.left != null) qu.offer(new pair(curr.val-1, curr.node.left));
                if(curr.node.right != null) qu.offer(new pair(curr.val+1, curr.node.right));

                qu.poll();
            }
        }

        for(int key : mp.keySet()){
            ans.add(mp.get(key));
        }

        return ans;
    }
    //? Time Complexity : O(NlogN)
    //? Space Complexity : O(N)

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
        List<Integer> ans = bottomView(root);
        System.out.println(ans);
        //? Time Complexity : O(NlogN)
        //? Space Complexity : O(N)
    }
}
