//* Generate Paranthesis
//! (Medium Problem)

//? Given an integer n.Generate all possible combinations of well-formed parentheses of length 2 x N.
//? Example 1
//? Input : n = 3
//? Output : [ "((()))" , "(()())" , "(())()" , "()(())" , "()()()" ]
//? Example 2
//? Input : 2
//? Output : [ "(())" , "()()" ]

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class J2_Generate_Paranthesis {
    public static void generateParanthesis(int idx, String s, int open, int close, List<String> ans, int n){
        if(open>n) return;
        if(open + close == 2*n && open == close){
            ans.add(s);
            return;
        }
        generateParanthesis(idx+1, s+'(', open+1, close, ans, n);
        if(open > close){
            generateParanthesis(idx+1, s+')', open, close+1, ans, n);
        }
    }
    //? Time Complexity : O(2^2N) i.e, O(4^n)
    //? Space Complexity : O(2N) + O(4^n)[stack space] + O(N)[string s, space]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        List<String> ans = new ArrayList<>();
        generateParanthesis(1, "", 0, 0, ans, n);
        for(int i=0; i<ans.size(); i++){
            System.out.println(ans.get(i));
        }
        //? Time Complexity : O(2^2N) i.e, O(4^n)
        //? Space Complexity : O(2N) + O(4^n)[stack space] + O(N)[string s, space]
    }
}
