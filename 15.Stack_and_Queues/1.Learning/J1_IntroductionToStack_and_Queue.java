//* Introduction to Stack and Queue

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//? Implement Stack using Arrays 
class ImplementStackUsingArrays{
    //! This implementation can't be dynamic, so we need a fixed size
    //! to implement Stack using arrays
    private int top;
    private int capacity;
    private int[] st;

    public ImplementStackUsingArrays(int size){
        capacity = size;
        top = -1;
        st = new int[size];
    }

    public void push(int x){
        if(top == capacity-1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        st[top] = x;
    }
    //? Time Complexity : O(1)

    public int top(){
        if(top==-1){
            return -1;
        }
        return st[top];
    }
    //? Time Complexity : O(1)

    public int pop(){
        if(top==-1){
            return -1;
        }
        int temp = top;
        top--;
        return st[temp];
    }
    //? Time Complexity : O(1)
    
    public int size(){
        return top+1;
    }
    //? Time Complexity : O(1)

    public boolean isEmpty(){
        return top==-1;
    }
    //? Time Complexity : O(1)

    public void print(){
        if(top==-1){
            System.out.println("Stack is Empty");
            return;
        }
        for(int i=0; i<=top; i++){
            System.out.print(st[i] + " ");
        }
    }
    //? Time Complexity : O(top)

    //? OverAll Space Complexity : O(size) [i.e, fixed space]
    //! Drawback or problem in implement with array is we need a fix size
    //! so some times there is memory wastage and it's not dynamic.
}

//? Implement Queue using Arrays (Circular Array)
class ImplementQueueUsingArrays{
    //! This implementation can't be dynamic, so we need a fixed size
    //! to implement queue using arrays
    private int start;
    private int end;
    private int currSize;
    private int maxSize;
    private int[] qu;

    public ImplementQueueUsingArrays(int size){
        maxSize = size;
        currSize = 0;
        qu = new int[maxSize];
        start = -1;
        end = -1;
    }

    public void push(int x){    //? Standard name is enqueue
        if(currSize == maxSize){
            System.out.println("Queue is Full");
            return;
        }

        if(currSize == 0){
            start = 0;
            end = 0;
        }
        else{
            end = (end+1)%maxSize;
        }
        qu[end] = x;
        currSize++;
    }
    //? Time Complexity : O(1)

    public int pop(){     //? Standard name is dequeue
        if(currSize == 0){
            return -1;
        }
        int ans = qu[start];

        if(currSize==1){
            start = -1;
            end = -1;
        }
        else{
            start = (start+1)%maxSize;
        }

        currSize--;
        return ans;
    }
    //? Time Complexity : O(1)

    public int peek(){
        if(currSize == 0){
            return -1;
        }

        return qu[start];
    }
    //? Time Complexity : O(1)

    public boolean isEmpty(){
        return currSize==0;
    }
    //? Time Complexity : O(1)

    public int size(){
        return currSize;
    }
    //? Time Complexity : o(1)

    public void print(){
        if(currSize==0){
            System.out.println("Queue is empty");
            return;
        }

        int i = start;
        for(int count=0; count<currSize; count++){
            System.out.print(qu[i] + " ");
            i = (i+1)%maxSize;
        }
    }
    //? Time Complexity : O(currSize)

    //? Overall Space Complexity : O(maxSize) [i.e, fixed space]
    //! Drawback or problem in implement with array is we need a fix size
    //! so some times there is memory wastage and it's not dynamic.
}

//? Node class 
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }
}

//? Implement Stack Using LinkedList
class ImplementStackUsingLinkedList{
    private Node top;
    private int size;

    public ImplementStackUsingLinkedList(){
        top = null;
        size = 0;
    }

    public void push(int x){
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size++;
    }
    //? Time Complexity : O(1)

    public int pop(){
        if(size==0) return -1;
        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
    }
    //? Time Complexity : O(1)

    public int top(){
        if(size==0) return -1;
        return top.data;
    }
    //? Time Complexity : O(1)

    public int size(){
        return size;
    }
    //? Time Complexity : O(1)

    public void print(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    //? Time Complexity : O(size)

    //? Overall Space Complexity : O(size), which is dynamic [its is not consumin an fixed space]
}

//? Implemenet Queue Using LinkedList
class ImplementQueueUsingLinkedList{
    private Node start;
    private Node end;
    private int size;

    public ImplementQueueUsingLinkedList(){
        start = null;
        end = null;
        size = 0;
    }

    public void push(int x){
        Node temp = new Node(x);
        if(size==0){
            start = temp;
            end = temp;
        }
        else{
            end.next = temp;
            end = temp;
        }
        size++;
    }
    //? Time Complexity : O(1)

    public int pop(){
        if(size==0) return -1;
        Node temp = start;
        start = start.next;
        size--;

        if(size==0){
            end = null;
        }

        return temp.data;
    }
    //? Time Complexity : O(1)

    public int top(){
        if(size==0) return -1;
        return start.data;
    }
    //? Time Complexity : O(1)

    public int size(){
        return size;
    }
    //? Time Complexity : O(1)

    public void print(){
        Node temp = start;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    //? Time Complexity : O(size)

    //? Overall Space Complexity : O(size) which is dynamic [its is not consumin an fixed space]
}

//? Implement Stack Using Queue
class ImplementStackUsingQueue{
    private Queue<Integer> qu;

    public ImplementStackUsingQueue(){
        qu = new ArrayDeque<>();
    }

    public void push(int x){
        int size = qu.size();
        qu.offer(x);
        for(int i=1; i<=size; i++){
            qu.offer(qu.peek());
            qu.poll();
        }
    }
    //? Time Complexity : O(N)

    public int pop(){
        if(qu.size()==0) return -1;
        return qu.poll();
    }
    //? Time Complexity : O(1)

    public int size(){
        return qu.size();
    }
    //? Time Complexity : O(1)

    public int top(){
        if(qu.size()==0) return -1;
        return qu.peek();
    }
    //? Time Complexity : O(1)

    public void print(){
        System.out.println(qu);
    }
    //? Time Complexity : O(N)

    //? Overall Space Complexity : O(N) [which is dynamic in nature]
}

//? Implement Queue Using Stack
//! Approach - 1
//! If push <<<<< top, pop
class ImplementQueueUsingStack{
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public ImplementQueueUsingStack(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    //? push
    //? =>  1.  st1 -> st2
    //? =>  2.  x -> st1
    //? =>  3.  st2 -> st1
    public void push(int x){
        //? 1
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        //? 2
        st1.push(x);
        //? 3
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
    }
    //? Time Complexity : O(2N)

    public int top(){
        if(st1.size()==0) return -1;
        return st1.peek();
    }
    //? Time Complexity : O(1)

    public int pop(){
        if(st1.size()==0) return -1;
        return st1.pop();
    }
    //? Time Complexity : O(1)

    public int size(){
        return st1.size();
    }
    //? Time Complexity : O(1)

    public void print(){
        for(int i=st1.size()-1; i>=0; i--){
            System.out.print(st1.get(i) + " ");
        }
    }
    //? Time Complexity : O(N)

    //? Overall Space Complexity : O(2N) [which is Dynamic in nature too, not an fixed space like arrays]
    //! This Approach will be very expensive when we have a alot of push operations [as push has O(2N) Complexity]
    //! It will take alot of time when there is a bunch of push operations
}

//? Implement Queue Using Stack
//! Approach - 2
//! If push >>>>>> top, pop
class Implement_QueueUsingStack{
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public Implement_QueueUsingStack(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x){
        st1.push(x);
    }
    //? Time Complexity : O(1)

    public int pop(){
        if(!st2.isEmpty()){
            return st2.pop();
        }

        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        return st2.pop();
        
    }
    //? Time Complexity : O(N) [O(N) wll come occassionally, most of the time its O(1)]

    public int top(){
        if(!st2.isEmpty()){
            return st2.peek();
        }

        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }

        return st2.peek();
    }
    //? Time Complexity : O(N) [O(N) wll come occassionally, most of the time its O(1)]

    public int size(){
        return st1.size() + st2.size();
    }
    //? Time Complexity : O(1)

    //? Overall Space Complexity : O(2N) [which is Dynamic in nature too, not an fixed space like arrays]
}

public class J1_IntroductionToStack_and_Queue {
    public static void main(String[] args) {

        //* Stack and Queue

        //? Stack (LIFO)
        //? Queue (FIFO)

        //* => Stack follows LIFO Mechanism
        //* => LIFO means Last in First out
        //* => operations : push, pop, peek, size

        //* => Queue follows FIFO Mechanism
        //* => FIFO means First in First out
        //* => operations : offer(means push), poll(means pop), peek, size

        //? Stack
        // Stack<Integer> st = new Stack<>();
        // st.push(2);
        // st.push(3);
        // st.push(4);
        // st.push(1);
        // st.pop();  //? --> 1
        // st.peek();  //? --> 4
        // st.pop();   //? --> 4
        // st.push(5);  //? --> 2 3 5
        // st.peek();  //? -> 5
        // System.out.println(st.size());  //? --> 3
        // System.out.println(st);   //? --> 2 3 5

        //? Queue
        // Queue<Integer> qu = new ArrayDeque<>();
        // qu.offer(2);
        // qu.offer(3);
        // qu.offer(4);
        // qu.offer(1);
        // qu.poll();  //? -> 2
        // qu.peek();  //? -> 3
        // qu.poll();  //? -> 3
        // qu.offer(5);  //? -? 4 1 5
        // qu.peek();  //? -> 4
        // System.out.println(qu.size());  //? -> 3
        // System.out.println(qu);  //? -> 4 1 5

        //! Stack → Concrete Class → can instantiate directly
        //! Queue → Interface → must use implementing class
        //? Example:
        //? Stack<Integer> st = new Stack<>();
        //? Queue<Integer> qu = new ArrayDeque<>();


        //* Implement using Arrays : 

        // //? Implement Stack using Arrays 
        // ImplementStackUsingArrays st = new ImplementStackUsingArrays(10);
        // st.push(2);
        // st.push(3);
        // st.push(5);
        // st.push(7);
        // System.out.println(st.top());  //? -> 7
        // System.out.println(st.pop());   //? -> 7
        // st.push(4);
        // System.out.println(st.isEmpty());  //? -> false
        // System.out.println(st.size());   //? -> 4
        // st.print();  //? -> 2 3 5 4

        //? Implement Queue using Arrays (Circular Array)
        // ImplementQueueUsingArrays qu = new ImplementQueueUsingArrays(4);
        // qu.push(3);
        // qu.push(2);
        // qu.push(4);
        // System.out.println(qu.peek());
        // System.out.println(qu.pop());
        // System.out.println(qu.pop());
        // qu.push(2);
        // qu.push(3);
        // System.out.println(qu.isEmpty());
        // System.out.println(qu.size());
        // qu.print();

        //? Implement Stack using LinkedList
        // ImplementStackUsingLinkedList st = new ImplementStackUsingLinkedList();
        // st.push(2);
        // st.push(4);
        // st.push(6);
        // st.push(9);
        // System.out.println(st.top());
        // System.out.println(st.pop());
        // System.out.println(st.top());
        // st.push(7);
        // System.out.println(st.size());
        // st.print();

        //? Implement Queue using LinkedList
        // ImplementQueueUsingLinkedList qu = new ImplementQueueUsingLinkedList();
        // qu.push(2);
        // qu.push(4);
        // qu.push(6);
        // qu.push(9);
        // System.out.println(qu.top());
        // System.out.println(qu.pop());
        // qu.push(10);
        // System.out.println(qu.size());
        // qu.print();
        
        //? Implement Stack Using Queue
        // ImplementStackUsingQueue st = new ImplementStackUsingQueue();
        // st.push(2);
        // st.push(3);
        // st.push(4);
        // st.push(7);
        // System.out.println(st.top());
        // st.push(10);
        // System.out.println(st.pop());
        // System.out.println(st.size());
        // st.print();

        //? Implement Queue Using Stack
        //! Approach 1
        //! If push <<<<<< top, pop
        // ImplementQueueUsingStack qu = new ImplementQueueUsingStack();
        // qu.push(2);
        // qu.push(9);
        // qu.push(4);
        // System.out.println(qu.top());
        // qu.push(13);
        // System.out.println(qu.pop());
        // System.out.println(qu.pop());
        // System.out.println(qu.size());
        // qu.print();
        //! This Approach will be very expensive when we have a alot of push operations [as push has O(2N) Complexity]
        //! It will take alot of time when there is a bunch of push operations

        //? Implement Queue Using Stack
        //! Approach 2
        //! If push >>>>>> top, pop
        Implement_QueueUsingStack st = new Implement_QueueUsingStack();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st.top());
        System.out.println(st.pop());
        st.push(1);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.size());
        System.out.println(st.pop());
    }
}
