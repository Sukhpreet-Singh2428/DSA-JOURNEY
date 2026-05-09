//* Vertical Order Traversal 
//! (Hard Problem)

//? Compute the binary tree's vertical order traversal given its root.
//? The left and right children of a node at location (row, col) will be at (row + 1, col - 1)
//?  and (row + 1, col + 1), respectively. The tree's root is located at (0, 0).
//? The vertical order traversal of a binary tree is a list of top-to-bottom orderings 
//? for each column index starting from the leftmost column and ending on the rightmost column. 
//? There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values. 
//? Return the binary tree's vertical order traversal.

//* This problem is : simple vertical order traversal + for same row, values should be sorted  

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}

class tuple {
    int row;
    int col;
    TreeNode node;

    public tuple(int row, int col, TreeNode node){
        this.row = row;
        this.col = col;
        this.node = node;
    }
}

public class J9_Vertical_Order_Traversal {
    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<tuple> qu = new ArrayDeque<>();
        qu.offer(new tuple(0, 0, root));

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> mp = new TreeMap<>();

        while(!qu.isEmpty()){
            int lvl = qu.size();

            for(int i=0; i<lvl; i++){
                tuple curr = qu.peek();

                if(!mp.containsKey(curr.col)){
                    TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
                    List<Integer> ls = new ArrayList<>();
                    ls.add(curr.node.val);
                    tm.put(curr.row, ls);
                    mp.put(curr.col, tm);
                }
                else{
                    if(!mp.get(curr.col).containsKey(curr.row)){
                        List<Integer> ls = new ArrayList<>();
                        ls.add(curr.node.val);
                        mp.get(curr.col).put(curr.row, ls);
                    }
                    else{
                        mp.get(curr.col).get(curr.row).add(curr.node.val);
                        Collections.sort(mp.get(curr.col).get(curr.row));
                    }
                }

                if(curr.node.left != null) qu.offer(new tuple(curr.row+1 ,curr.col-1, curr.node.left));
                if(curr.node.right != null) qu.offer(new tuple(curr.row+1, curr.col+1, curr.node.right));

                qu.poll();
            }
        }

        for(int key : mp.keySet()){
            List<Integer> ls = new ArrayList<>();
            for(int x : mp.get(key).keySet()){
                for(int i=0; i<mp.get(key).get(x).size(); i++){
                    ls.add(mp.get(key).get(x).get(i));
                }
            }
            ans.add(ls);
        }

        return ans;
    }
    //? Time Complexity : O(N) [traversal] * O(logN) [insertion in TreeMap] * O(klogk) [for sorting, same row and same col]
    //?                 : => O(NlogN + KlogK)
    //? Space Complexity : O(N) [for queue, using BFS] + O(N) [This space is used to return ans in specific form]
    //?                  : => O(N)

    //? We can further optimize it, by using priority queue instead of list + sorting working. so that
    //? the repeptitve sorting O(klogk) should be cut out. While everything else is optimal
    //? And in more practical based thinking, there is not an massive difference between 
    //? priority queue and list + sorting as for same row and same column, k value will not be that much
    //? high for such problem but still using priority queue instead of list + sorting, cut the 
    //? repetive Collections.sort

    //* Optimal : 
    //? Using priority queue, instead of list + sorting working 
    public static List<List<Integer>> vertical_Traversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<tuple> qu = new ArrayDeque<>();
        qu.offer(new tuple(0, 0, root));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

        while(!qu.isEmpty()){
            int lvl = qu.size();
            for(int i = 0; i < lvl; i++){
                tuple curr = qu.peek();

                if(!mp.containsKey(curr.col)){
                    TreeMap<Integer, PriorityQueue<Integer>> tm = new TreeMap<>();
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.offer(curr.node.val);
                    tm.put(curr.row, pq);
                    mp.put(curr.col, tm);
                }
                else{
                    if(!mp.get(curr.col).containsKey(curr.row)){
                        PriorityQueue<Integer> pq = new PriorityQueue<>();
                        pq.offer(curr.node.val);
                        mp.get(curr.col).put(curr.row, pq);
                    }
                    else{
                        mp.get(curr.col).get(curr.row).offer(curr.node.val);
                    }
                }

                if(curr.node.left != null) qu.offer(new tuple(curr.row + 1, curr.col - 1, curr.node.left));
                if(curr.node.right != null) qu.offer(new tuple(curr.row + 1, curr.col + 1, curr.node.right));

                qu.poll();
            }
        }

        for(int key : mp.keySet()){
            List<Integer> ls = new ArrayList<>();
            for(int x : mp.get(key).keySet()){
                while(!mp.get(key).get(x).isEmpty()){
                    ls.add(mp.get(key).get(x).poll());
                }
            }
            ans.add(ls);
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
        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans);
        //? Time Complexity : O(N) [traversal] * O(logN) [insertion in TreeMap] * O(klogk) [for sorting, same row and same col]
        //?                 : => O(NlogN + KlogK)
        //? Space Complexity : O(N) [for queue, using BFS] + O(N) [This space is used to return ans in specific form]
        //?                  : => O(N)

        //? We can further optimize it, by using priority queue instead of list + sorting working. so that
        //? the repeptitve sorting O(klogk) should be cut out. While everything else is optimal
        //? And in more practical based thinking, there is not an massive difference between 
        //? priority queue and list + sorting as for same row and same column, k value will not be that much
        //? high for such problem but still using priority queue instead of list + sorting, cut the 
        //? repetive Collections.sort

        //* Optimal : 
        //? Using priority queue, instead of list + sorting working
        // List<List<Integer>> ans = vertical_Traversal(root);
        // System.out.println(ans);
        //? Time Complexity : O(NlogN)
        //? Space Complexity : O(N)
    }
}
