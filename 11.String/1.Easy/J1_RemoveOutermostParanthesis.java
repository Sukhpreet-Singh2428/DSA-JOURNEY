//* Remove Outermost Paranthesis
//! (Easy Problem)

//? Example 1
//? Input: s = "((()))"
//? Output: "(())"
//* Explanation:
//* The input string is a single primitive: "((()))".
//* Removing the outermost layer yields: "(())".
//? Example 2
//? Input: s = "()(()())(())"
//? Output: "()()()"
//* Explanation:
//* Primitive decomposition: "()" + "(()())" + "(())"
//* After removing outermost parentheses: "" + "()()" + "()"
//* Final result: "()()()".

import java.util.Scanner;

public class J1_RemoveOutermostParanthesis {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static String removeOutermost_Paranthesis(String str){
        StringBuilder ans = new StringBuilder();

        int balance = 0;
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c == '('){
                if(balance > 0){
                    ans.append(c);
                }
                balance++;
            }
            else{
                balance--;
                if(balance > 0){
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        //* Optimal : 
        String ans = removeOutermost_Paranthesis(str);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)
    }
}
