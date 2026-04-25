//* Check if Two Trees are identical or not
//! (Medium Problem)

//? Same Tree or Not => Perform any traversal and check if both traversal are same or not, simple ! 

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

public class J5_Check_If_Two_Trees_Are_IdenticalOrNot {

    //* Optimal : 
    //? (doing with PreOrder Traversal)
    public static boolean isSameTree(Node root1, Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)  [recursive stack space]
    
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.left.right.left = new Node(8);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        root1.right.right.left = new Node(9);
        root1.right.right.right = new Node(10);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.left.right.left = new Node(8);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(9);
        root2.right.right.right = new Node(10);


        //* Optimal : 
        boolean ans = isSameTree(root1, root2);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)  [recursive stack space]

    }
}
