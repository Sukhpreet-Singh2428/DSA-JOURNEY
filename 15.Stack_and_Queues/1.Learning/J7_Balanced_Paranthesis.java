//* Balanced Paranthesis
//! (Easy Problem)

//? s = ()[{}()]  --> true
//? s = ()[{}(])  --> false

import java.util.Scanner;
import java.util.Stack;
public class J7_Balanced_Paranthesis {
    public static boolean balancedParanthesis(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c=='[' || c=='{'){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if( (c==')' && top!='(') || (c==']' && top!='[') || (c=='}' && top!='{') ){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        //* Optimal : 
        boolean ans = balancedParanthesis(s);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)
    }
}
