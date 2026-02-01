//* Generate all binary strings
//! (Medium Problem)

//? Given an integer n, return all binary strings of length n that do not contain consecutive 1s. 
//? Return the result in lexicographically increasing order.
//? A binary string is a string consisting only of characters '0' and '1'.
//? Example 1:
//? Input:
//?  n = 3  
//? Output:
//?  ["000", "001", "010", "100", "101"]  
//* Explanation:
//*  All binary strings of length 3 that do not contain consecutive 1s.
//? Example 2:
//? Input:
//?  n = 2  
//? Output:
//?  ["00", "01", "10"]  
//* Explanation:
//* All binary strings of length 2 that do not contain consecutive 1s.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J3_Generate_all_BinaryStrings {
    public static void generate(List<String> ans, String s, int n){
        if(s.length()==n){
            ans.add(s);
            return;
        }
        
        generate(ans, s+"0", n);

        if(s.isEmpty() || s.charAt(s.length()-1) != '1'){
            generate(ans, s+"1", n);
        }
    }
    //? Time Complexity : O(2^n)
    //? Space Complexity : O(n) [call stack]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //* Optimal : 
        List<String> ans = new ArrayList<>();
        generate(ans, "", n);
        System.out.println(ans);
        //? Time Complexity : O(2^n)
        //? Space Complexity : O(n) [call stack]
    }
}
