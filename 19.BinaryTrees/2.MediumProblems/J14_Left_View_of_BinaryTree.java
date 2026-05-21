//* Left View of Binary Tree
//! (Medium Problem)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class J14_Left_View_of_BinaryTree {
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static List<List<Integer>> levelOrder(Node root){
        Queue<Node> qu = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            List<Integer> ls = new ArrayList<>();

            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);
                ls.add(qu.poll().data);
            }

            ans.add(ls);
        }

        return ans;
    }
    public static List<Integer> leftView(Node root){
        List<Integer> ls = new ArrayList<>();
        if(root==null) return ls;

        List<List<Integer>> ds = levelOrder(root);

        for(int i=0; i<ds.size(); i++){
            ls.add(ds.get(i).get(0));
        }

        return ls;
    }
    //? Time Complexity : O(N) + O(height)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static void recursionLeft(Node root, int level, List<Integer> ls){
        if(root==null){
            return;
        }

        if(ls.size() == level){
            ls.add(root.data);
        }

        recursionLeft(root.left, level+1, ls);

        recursionLeft(root.right, level+1, ls);
    }
    public static List<Integer> Left_View(Node root){
        List<Integer> ls = new ArrayList<>();
        if(root==null) return ls;

        recursionLeft(root, 0, ls);

        return ls;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(height)  [Stack Space]  {for balanced tree => O(logN)}

    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        //* Brute --> Better --> Optimal 

        //* Brute : 
        // List<Integer> ans = leftView(root);
        // System.out.println(ans);
        //? Time Complexity : O(N) + O(height)
        //? Space Complexity : O(N)

        //* Optimal : 
        List<Integer> ans = Left_View(root);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(height) [stack space] {for balanced tree => O(logN)}
    }
}
