//* Recursive Implementation of atoi()
//! (Medium Problem)

//? Example 1
//? Input: s = " -12345"
//? Output: -12345
//* Explanation:
//* Ignore leading whitespaces.
//* The sign '-' is encountered, indicating the number is negative.
//* Digits 12345 are read and converted to -12345.
//? Example 2
//? Input: s = "4193 with words"
//? Output: 4193
//* Explanation:
//* Read the digits 4193 and stop when encountering the first non-digit character (w).

import java.util.Scanner;
public class J1_RecursiveImplementationOf_atoi {
    public static int helper(String s, int i, long num, int sign){
        if(i>=s.length() || !Character.isDigit(s.charAt(i))){
            return (int)(num * sign);
        }

        num = num*10 + (s.charAt(i) - '0');

        if(num*sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(num*sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return helper(s, i+1, num, sign);
    }
    public static int myAtoi(String s){
        int i=0;

        //* Skip whitespaces
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }

        //* Handle Sign
        int sign = 1;
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-') ){
            if(s.charAt(i)=='-'){
                sign = -1;
            }
            else{
                sign = 1;
            }
            i++;
        }

        //* Recursive helper
        return helper(s, i, 0, sign);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N) [Stack Space]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        int ans = myAtoi(s);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) [Stack Space]
    }
}
