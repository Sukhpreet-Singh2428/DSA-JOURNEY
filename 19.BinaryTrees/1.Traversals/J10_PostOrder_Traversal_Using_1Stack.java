//* PostOrder Traversal Using 1 Stack
//! (Medium)

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

public class J10_PostOrder_Traversal_Using_1Stack {

    //? PostOrder Traversal Using 1 Stack : 
    public static void PostOrder(Node root, List<Integer> ls){
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while(curr!=null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.peek();
                    st.pop();
                    ls.add(temp.data);
                    while(!st.isEmpty() && temp==st.peek().right){   //? coming back up
                        temp = st.peek();
                        st.pop();
                        ls.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }

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

        List<Integer> ls = new ArrayList<>();
        PostOrder(root, ls);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)

        for(int x : ls){
            System.out.print(x + " ");
        }
        //? 4 8 5 2 6 9 10 7 3 1 
    }
}
