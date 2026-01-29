//* Sort a Stack using Recursion
//! (Medium Problem)

//? Example 1
//? Input: stack = [4, 1, 3, 2]
//? Output: [4, 3, 2, 1]
//* Explanation:
//* After sorting, the largest element (4) is at the top, and the smallest (1) is at the bottom.
//? Example 2
//? Input: stack = [1]
//? Output: [1]
//* Explanation:
//* A single-element stack is already sorted.

import java.util.Stack;
public class J4_Sort_a_StackUsingRecursion {
    public static void insert(Stack<Integer> st, int temp){
        if(st.isEmpty() || st.peek() <= temp){
            st.push(temp);
            return;
        }

        int val = st.pop();
        insert(st, temp);
        
        st.push(val);
    }
    public static void sortStack(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insert(st, temp);
        }
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N) [Stack Space]

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(1);
        st.push(3);
        st.push(2);

        sortStack(st);

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N) [Stack Space]
    }
}
