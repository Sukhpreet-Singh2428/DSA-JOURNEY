//* ZigZag or Spiral Traversal 
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
        left = null;
        right = null;
    }
}

public class J7_ZigZag_or_Spiral_Traversal {

    //* Brute : 
    //? In Brute force approach, we can implement level order traversal then
    //? we will reverse the list where flag is false or where Right to left traversal is needed
    //? In optimal, we don't directly reverse the list

    //* Optimal : 
    public static List<List<Integer>> zigzagLevelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> qu = new ArrayDeque<>();
        if(root==null) return ans;
        qu.offer(root);
        boolean leftToRight = true;

        while(!qu.isEmpty()){
            int levelNum = qu.size();
            List<Integer> ls = new ArrayList<>(levelNum);
            for(int i=0; i<levelNum; i++){
                ls.add(0);
            }

            for(int i=0; i<levelNum; i++){
                if(qu.peek().left != null) qu.offer(qu.peek().left);
                if(qu.peek().right != null) qu.offer(qu.peek().right);

                int idx = leftToRight ? i : levelNum-1-i;
                ls.set(idx, qu.poll().data);
            }

            leftToRight = !leftToRight;
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


        //* Brute : 
        //? In Brute force approach, we can implement level order traversal then
        //? we will reverse the list where flag is false or where Right to left traversal is needed
        //? In optimal, we don't directly reverse the list

        
        //* Optimal : 
        List<List<Integer>> ans = zigzagLevelOrder(root);
        for(List<Integer> ls : ans){
            System.out.println(ls);
        }
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)

    }
}
