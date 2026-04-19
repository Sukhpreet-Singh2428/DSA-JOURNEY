//* Asteroid Collision
//! (Medium Problem)

//? arr = [4, 7, 1, 1, 2, -3, -7, 17, 15, -16]
//? => [4, 17]

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class J7_Asteroid_Collision {

    //* Brute --> Better --> Optimal : 

    //* Optimal :
    public static List<Integer> asteroidCollision(int[] arr){
        List<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                st.push(arr[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek() < Math.abs(arr[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(arr[i])){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0){
                    st.push(arr[i]);
                }
            }
        }

        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        Collections.reverse(ls);

        return ls;
    } 
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)

    //* Optimal (eliminating Stack, using only list as Stack) : 
    public static List<Integer> asteroid_collision(int[] arr){
        List<Integer> ls = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                ls.add(arr[i]);
            }
            else{
                while(!ls.isEmpty() && ls.get(ls.size()-1)>0 && ls.get(ls.size()-1) < Math.abs(arr[i])){
                    ls.remove(ls.size()-1);
                }
                if(!ls.isEmpty() && ls.get(ls.size()-1) == Math.abs(arr[i])){
                    ls.remove(ls.size()-1);
                }
                else if(ls.isEmpty() || ls.get(ls.size()-1) < 0){
                    ls.add(arr[i]);
                }
            }
        }

        return ls;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();


        //* Optimal : 
        List<Integer> ls = asteroidCollision(arr);
        System.out.println(ls);

        //* Optimal (eliminating stack, with only using list as stack) : 
        List<Integer> res = asteroid_collision(arr);
        System.out.println(res);
    }
}
