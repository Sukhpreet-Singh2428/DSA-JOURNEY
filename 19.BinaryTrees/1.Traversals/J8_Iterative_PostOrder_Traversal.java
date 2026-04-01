//* PostOrder Traversal   (Iterative)
//! (Easy)

//? Three ways to do PostOrder Traversal Iteratively : 
//?  1. Root Right Left + Reverse  (This)  (Easy)
//?  2. Using 2 Stack Method  (Easy)
//?  3. Using 1 Stack Method  (Medium-Hard)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

public class J8_Iterative_PostOrder_Traversal {

    //? PostOrder Traversal :  (Iterative)
    public static void PostOrder(Node root, List<Integer> ls){
        //! we are doing at as :  Root Right Left
        //! and at last we will reverse it 

        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node node = st.peek();
            st.pop();
            ls.add(node.data);

            if(node.left != null) st.push(node.left);
            if(node.right != null) st.push(node.right);
        }

        int i = 0;
        int j = ls.size()-1;
        while(i<j){
            int temp = ls.get(i);
            ls.set(i, ls.get(j));
            ls.set(j, temp);
            i++;
            j--;
        }
    }
    //? Time Complexity : O(N) + O(N)
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

        List<Integer> ls = new ArrayList<>();
        PostOrder(root, ls);
        //? Time Complexity : O(N) + O(N)
        //? Space Complexity : O(N)

        for(int x : ls){
            System.out.print(x + " ");
        }
        //? 4 8 5 2 6 9 10 7 3 1 
    }
}
