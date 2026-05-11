//* Top View of Binary Tree
//! (Medium Problem)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

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

class pair{
    int val;
    Node node;
    public pair(int val, Node node){
        this.val = val;
        this.node = node;
    }
}

public class J11_Top_View_of_BinaryTree {
    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static List<Integer> topView(Node root) {
        List<Integer> ls = new ArrayList<>();
        if(root==null) return ls;

        Queue<pair> qu = new ArrayDeque<>();
        TreeMap<Integer, Node> tp = new TreeMap<>();
        qu.offer(new pair(0, root));

        while(!qu.isEmpty()){
            int lvl = qu.size();
            
            for(int i=0; i<lvl; i++){
                if(!tp.containsKey(qu.peek().val)){
                    tp.put(qu.peek().val, qu.peek().node);
                }

                if(qu.peek().node.left != null) qu.offer(new pair(qu.peek().val-1, qu.peek().node.left));
                if(qu.peek().node.right != null) qu.offer(new pair(qu.peek().val+1, qu.peek().node.right));

                qu.poll();
            }
        }

        for(int key : tp.keySet()){
            ls.add(tp.get(key).data);
        }

        return ls;
    }
    //? Time Complexity : O(NlogN)
    //? Space Complexity : O(N)
    
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

        //* Optimal : 
        List<Integer> ans = topView(root);
        System.out.print(ans);
        //? Time Complexity : O(NlogN)
        //? Space Complexity : O(N)
    }
}
