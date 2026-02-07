//* Letter Combinations of a Phone Number
//! (Hard Problem)

//? Given a string consisting of digits from 2 to 9 (inclusive). Return all possible letter combinations that the number can represent.
//? Mapping of digits to letters is given in first example.
//? Example 1
//? Input : digits = "34"
//? Output : [ "dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi" ]
//* Explanation : The 3 is mapped with "def" and 4 is mapped with "ghi".
//* So all possible combination by replacing the digits with characters are shown in output.
//? Example 2
//? Input : digits = "3"
//? Output : [ "d", "e", "f" ]
//* Explanation : The 3 is mapped with "def".

//? eg : digits = "34"
//?     3 --> d e f
//?     4 --> g h i
//? => [dg, dh, di, eg, eh, ei, fg, fh, fi]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J12_LetterCombinationsOf_aPhoneNumber {
    public static void helper(int idx, String ans, List<String> ls, String digits, String[] combo){
        if(idx == digits.length()){
            ls.add(ans);
            return;
        }

        int number = digits.charAt(idx) - '0';
        String s = combo[number];
        for(int i=0; i<s.length(); i++){
            helper(idx+1, ans + s.charAt(i), ls, digits, combo);
        }
    }
    public static List<String> letterCombination(String digits){
        List<String> ls = new ArrayList<>();
        if(digits.length() == 0){
            return ls;
        }

        String[] combo = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
        helper(0, "", ls, digits, combo);
        return ls;
    }
    //? Time Complexity : O(4^N * N)
    //? Space Complexity : O(N)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.next();
        sc.close();

        //* Optimal : 
        List<String> ans = letterCombination(digits);
        System.out.println(ans);
        //? Time Complexity O(4^N * N), where n is the length of the input digits. 
        //?     This is because each digit can map to up to 4 letters and there are n digits.
        //? Space Complexity: O(N), where n is the length of the input digits. 
        //?     This is due to the recursion stack depth.
    }
}
