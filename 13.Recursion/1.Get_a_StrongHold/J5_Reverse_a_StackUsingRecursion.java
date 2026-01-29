//* Reverse a Stack using Recursion
//! (Easy Problem)

import java.util.Stack;
public class J5_Reverse_a_StackUsingRecursion {
    public static void insert(Stack<Integer> st, int temp){
        if(st.isEmpty()){
            st.push(temp);
            return;
        }

        int val = st.pop();
        insert(st, temp);
        st.push(val);
    }
    public static void reverse_a_stack_usingRecursion(Stack<Integer> st){
        if(st.isEmpty()) return;
        int temp = st.pop();
        reverse_a_stack_usingRecursion(st);
        insert(st, temp);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        reverse_a_stack_usingRecursion(st);
        
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
}
