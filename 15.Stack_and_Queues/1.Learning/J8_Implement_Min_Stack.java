//* Implement Min Stack 
//! (Hard Problem)

import java.util.Stack;
class MinStack{
    private Stack<int[]> st;

    public MinStack(){
        st = new Stack<>();
    }

    public void push(int value){
        if(st.isEmpty()){
            st.push(new int[]{value, value});
            return;
        }

        int mini = Math.min(st.peek()[1], value);

        st.push(new int[]{value, mini});
    }

    public void pop(){
        st.pop();
    }

    public int top(){
        return st.peek()[0];
    }

    public int getMin(){
        return st.peek()[1];
    }
}
//? Time Complexity : O(1)
//? Space Complexity : O(2*N)

class min_stack{
    Stack<Integer> st;
    int mini = Integer.MAX_VALUE;

    public min_stack(){
        st = new Stack<>();
    }

    public void push(int val){
        if(st.isEmpty()){
            mini = val;
            st.push(val);
            return;
        }

        if(val>mini){
            st.push(val);
        }
        else{
            st.push(2*val - mini);
            mini = val;
        }
    }

    public void pop(){
        if(st.isEmpty()){
            return;
        }

        int x = st.pop();
        if(x<mini){
            mini = 2*mini - x;
        }
    }

    public int top(){
        if(st.isEmpty()){
            return -1;
        }

        int x = st.peek();
        if(mini < x){
            return x;
        }
        return mini;
    }

    public int getMin(){
        return mini;
    }
}
//? Time Complexity : O(1)
//? Space Complexity : O(N)

public class J8_Implement_Min_Stack {
    public static void main(String[] args) {
        // MinStack st = new MinStack();

        // st.push(12);
        // st.push(15);
        // st.push(10);
        // System.out.println(st.getMin());
        // st.pop();
        // System.out.println(st.top());
        // System.out.println(st.getMin());

        //* Optimal : 
        min_stack st = new min_stack();
        st.push(12);
        st.push(15);
        st.push(10);
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.getMin());
    }
}
