//* Vertical Order Traversal 
//! (Medium Problem)

//? Vertical Order Traversal => Normal, column/vertical wise traversal 

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

class pair {
    int val;
    Node node;

    public pair(int val, Node node){
        this.val = val;
        this.node = node;
    }
}
public class J10_Simple_VerticalOrder_Traversal {
    //* Brute --> Better --> Optimal
    
    //* Optimal : 
    public static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<pair> qu = new ArrayDeque<>();
        qu.offer(new pair(0, root));

        TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();

        while(!qu.isEmpty()){
            int lvl = qu.size();

            for(int i=0; i<lvl; i++){
                pair curr = qu.peek();

                if(!mp.containsKey(curr.val)){
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(curr.node.data);
                    mp.put(curr.val, ls);
                }
                else{
                    mp.get(curr.val).add(curr.node.data);
                }

                if(curr.node.left != null) qu.offer(new pair(curr.val-1, curr.node.left));
                if(curr.node.right != null) qu.offer(new pair(curr.val+1, curr.node.right));

                qu.poll();
            }
        }

        for(int key : mp.keySet()){
            ArrayList<Integer> ls = new ArrayList<>();
            for(int i=0; i<mp.get(key).size(); i++){
                ls.add(mp.get(key).get(i));
            }
            ans.add(ls);
        }

        return ans;
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
        List<List<Integer>> ans = verticalOrder(root);
        System.out.print(ans);
        //? Time Complexity : O(NlogN)
        //? Space Complexity : O(N)
    }
}
