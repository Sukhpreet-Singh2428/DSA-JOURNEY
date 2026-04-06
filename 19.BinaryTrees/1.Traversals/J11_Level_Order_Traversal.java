//* Level Order Traversal 
//! (Easy)

//* => BFS 

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
        left = null;
        right = null;
    }
}

public class J11_Level_Order_Traversal {

    //? Level Order Traversal : 
    public static List<List<Integer>> LevelOrder(Node root){
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
    //? Time Complexity : O(N)
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

        List<List<Integer>> ans =  LevelOrder(root);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)

        for(List<Integer> x : ans){
            System.out.println(x);
        }
        //? [1]
        //? [2, 3]
        //? [4, 5, 6, 7]
        //? [8, 9, 10]
    }
}
