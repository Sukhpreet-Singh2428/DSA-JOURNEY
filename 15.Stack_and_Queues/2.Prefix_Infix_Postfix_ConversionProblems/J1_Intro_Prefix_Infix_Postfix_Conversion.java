//* Prefix, Infix, Postfix Conversions

import java.util.Scanner;
import java.util.Stack;

public class J1_Intro_Prefix_Infix_Postfix_Conversion {

    //? Infix to Postfix
    public static int priority(char c){
        if(c=='^') return 3;
        else if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return -1;
    }
    public static String infixToPostfix(String s){
        int i=0;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = s.length();

        while(i<n){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                ans.append(c);
            }
            else if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop();
            }
            else{ 
                if(c=='^'){        //? bcz for Infix --> a^b^c, the postfix --> abc^^
                    while(!st.isEmpty() && priority(c)<priority(st.peek())){
                        ans.append(st.pop());
                    }
                }
                else{
                    while(!st.isEmpty() && priority(c)<=priority(st.peek())){
                        ans.append(st.pop());
                    }
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.toString();
    }
    //? Time Complexity : O(N) + O(N)
    //? Space Complexity : O(N)


    //? Infix to Prefix
    public static String infixToPrefix(String str){
        StringBuilder s = new StringBuilder(str);
        //? 1.
        s.reverse();
        for(int j=0; j<s.length(); j++){
            if(s.charAt(j) == '('){
                s.setCharAt(j, ')');
            }
            else if(s.charAt(j) == ')'){
                s.setCharAt(j, '(');
            }
        }

        //? 2.
        int i=0;
        int n = str.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        while(i<n){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                ans.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop();
            }
            else{
                if(c == '^'){
                    while(!st.isEmpty() && priority(c) <= priority(st.peek())){
                        ans.append(st.pop());
                    }
                }
                else{
                    while(!st.isEmpty() && priority(c) < priority(st.peek())){
                        ans.append(st.pop());
                    }
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        //? 3.
        ans.reverse();
        return ans.toString();
    }
    //? Time Complexity : O(N/2) [first reverse] + O(N/2) [second reverse] + O(2N)
    //?                   O(3N) --> O(N)
    //? Space Complexity : O(N)


    //? Postfix to Infix
    public static String postfixToInfix(String s){
        int i = 0;
        int n = s.length();
        Stack<String> st = new Stack<>();
        while(i<n){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String str = '(' + t2 + c + t1 + ')';
                st.push(str);
            }
            i++;
        }

        return st.peek();
    }
    //? Time Complexity : O(N) + O(N) [Adding strings]
    //? Space Complexity : O(N)


    //? Prefix to Infix
    public static String prefixToInfix(String s){
        int n = s.length();
        int i = n-1;
        Stack<String> st = new Stack<>();
        while(i>=0){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String str = '(' + t1 + c + t2 + ')';
                st.push(str);
            }
            i--;
        }

        return st.peek();
    }
    //? Time Complexity : O(N) + O(N) [Adding strings]
    //? Space Complexity : O(N)


    //? Postfix to Prefix
    public static String postfixToPrefix(String s){
        int n = s.length();
        int i = 0;
        Stack<String> st = new Stack<>();
        while(i<n){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String str = c + t2 + t1;
                st.push(str);
            }
            i++;
        }

        return st.peek();
    }
    //? Time Complexity : O(N) + O(N) [adding the strings]
    //? Space Complexity : O(N)


    //? Prefix to Postfix
    public static String prefixToPostfix(String s){
        int n = s.length();
        int i = n-1;
        Stack<String> st = new Stack<>();
        while(i>=0){
            char c = s.charAt(i);
            if((c>='A' && c<='Z') || (c>='a' && c<='z') || (c>='0' && c<='9')){
                st.push(Character.toString(c));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String str = t1 + t2 + c;
                st.push(str);
            }
            i--;
        }

        return st.peek();
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(N)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        //? What is an operator / operand ?
        //* operator : ^, *, /, +, -
        //* operand : A-Z, a-z, 0-9

        //? Priority of operator ?
        //*     ^    --> 3
        //*    *  /  --> 2
        //*    +  -  --> 1
        //*  anything other --> -1

        //? Infix expression : 
        //* (p+q) * (m-n)

        //? Prefix expression : 
        //*  *+ pq - mn

        //? Postfix expression : 
        //*  pq + mn -*


        //! Conversions : 

        //?  Infix to Postfix
        //* Infix   -->  a+b * (c^d-e)
        //* Postfix -->  abcd^e-*+
        //? dry run : 
        //?      i=0                  st                       ans
        //?       a                                             a
        //?       +                    +                        a
        //?       b                    +                       ab
        //?       *                    +*                      ab
        //?       (                   +*(                      ab
        //?       c                   +*(                      abc
        //?       ^                   +*(^                     abc
        //?       d                   +*(^                     abcd
        //?       -                   +*(-                     abcd^
        //?       e                   +*(-                     abcd^e
        //?       )                   +*                       abcd^e-
        //?                                                    abcd^e-*+
        // System.out.println(infixToPostfix(s));
        //? Time Complexity : O(N) + O(N)
        //? Space Complexity : O(N)


        //? Infix to Prefix
        //* Infix -->  (A + B)*C - D + F
        //* Prefix -->  +-*+ABCDF
        //! 1. Reverse the Infix
        //! 2. Infix to Postfix (under some controlled conditions)
        //! 3. Reverse that answer

        //? 1. 
        //? -->  F + D - C * ) B + A (
        //? -->  F + D - C * ( B + A )
        //? 2.
        //?    i                     st                       ans
        //?    F                                               F
        //?    +                      +                        F
        //?    D                      +                       FD
        //?    -                     +-                       FD
        //! Here comes the some controlled conditions
        //! If it is operator, and it is apart from this one ^ then,
        //! we Straight away insert the operator in the Stack. 
        //! Unlike the normal Infix to Postfix conversion, in which we 
        //! pop out the operator if next operator has smaller or equal priority to it.
        //! In this, we straight away adding the operator into the stack if its priority is equal 
        //! to the top of the stack. Here we only pop out the operator if next operator has smaller
        //! priority than top of the stack.
        //! means in normal Infix to Postfix -->  <=
        //! and over here is -->  <
        //?    C                     +-                        FDC
        //?    *                     +-*                       FDC
        //?    (                     +-*(                      FDC
        //?    B                     +-*(                      FDCB
        //?    +                     +-*(+                     FDCB
        //?    A                     +-*(+                     FDCBA
        //?    )                     +-*                       FDCBA+
        //?                                                    FDCBA+*-+
        //? 3. 
        //?  -->  +-*+ABCDF
        //? prefix --> +-*+ABCDF
        // System.out.println(infixToPrefix(s));
        //? Time Complexity : O(N/2) [first reverse] + O(N/2) [second reverse] + O(2N)
        //?                   O(3N) --> O(N)
        //? Space Complexity : O(N)


        //? Postfix to Infix
        //* Postfix --> AB-DE+F*/
        //* Infix --> (A-B)/((D+E)*F)
        //?    i                               st
        //?    A                                A
        //?    B                                AB
        //?    -                               (A-B),
        //?    D                               (A-B), D
        //?    E                               (A-B), D, E
        //?    +                               (A-B), (D+E)
        //?    F                               (A-B), (D+E), F
        //?    *                               (A-B), ((D+E)*F)
        //?    /                               (A-B)/((D+E)*F)
        // System.out.println(postfixToInfix(s));
        //? Time Complexity : O(N) + O(N) [Adding strings]
        //? Space Complexity : O(N)


        //? Prefix to Infix
        //* Prefix -->  *+PQ-MN
        //* Infix -->  ((P+Q)*(M-N))
        //! we will iterate from end
        //?    i                               st
        //?    N                               N
        //?    M                               NM
        //?    -                              (M-N)
        //?    Q                              (M-N), Q
        //?    P                              (M-N), Q, P
        //?    +                              (M-N), (P+Q)
        //?    *                              ((P+Q)*(M-N))
        // System.out.println(prefixToInfix(s));
        //? Time Complexity : O(N) + O(N) [Adding strings]
        //? Space Complexity : O(N)


        //? Postfix to Prefix
        //* Postfix -->  AB-DE+F*/
        //* Prefix -->  /-AB*+DEF
        //?    i                                  st
        //?    A                                  A
        //?    B                                  A,B
        //?    -                                  -AB
        //?    D                                  -AB,D
        //?    E                                  -AB,D,E
        //?    +                                  -AB,+DE
        //?    F                                  -AB,+DE,F
        //?    *                                  -AB,*+DEF
        //?    /                                  /-AB*+DEF
        //! or we can do this by Postifx to Infix and then Infix to Prefix
        //! but this one more easier or optimal way
        // System.out.println(postfixToPrefix(s));
        //? Time Complexity : O(N) + O(N) [adding the strings]
        //? Space Complexity : O(N)


        //? Prefix to Postfix
        //* Prefix -->  /-AB*+DEF
        //* Postfix --> AB-DE+F*/
        //?     i                                    st
        //?     F                                    F
        //?     E                                    F,E
        //?     D                                    F,E,D
        //?     +                                    F,DE+
        //?     *                                    DE+F*
        //?     B                                    DE+F*,B
        //?     A                                    DE+F*,B,A
        //?     -                                    DE+F*,AB-
        //?     /                                    AB-DE+F*/
        System.out.println(prefixToPostfix(s));
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)
    }
}
