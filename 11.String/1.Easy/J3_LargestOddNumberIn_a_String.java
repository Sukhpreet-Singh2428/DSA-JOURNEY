//* Largest Odd Number in a String
//! (Easy Problem)

//? Given a string s, representing a large integer, the task is to return 
//? the largest-valued odd integer (as a string) that is a substring of the given string s.
//! The number returned should not have leading zero's. 
//! But the given input string may have leading zero. (If no odd number is found, then return empty string.)

//? Example 1
//? Input : s = "5347"
//? Output : "5347"
//* Explanation :
//* The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
//* So the largest among all the possible odd numbers for given string is 5347.

//? Example 2
//? Input : s = "0214638"
//? Output : "21463"
//* Explanation :
//* The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463.
//* We cannot include 021463 as the number contains leading zero.
//* So largest odd number in given string is 21463.

import java.util.Scanner;
public class J3_LargestOddNumberIn_a_String {

    //* Brute --> Better --> Optimal

    //* Optimal : 
    public static String largestOddNumberIn_a_String(String str){

        int j = -1;
        int n = str.length();
        for(int i=n-1; i>=0; i--){
            char s = str.charAt(i);
            if( (s-'0')%2 == 1 ){
                j = i;
                break;
            }
        }
        if(j == -1) return "";

        int i = 0;
        while(i<n){
            char s = str.charAt(i);
            if(s != '0') break;
            i = i+1;
        }

        return str.substring(i, j+1);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        //* Optimal : 
        String ans = largestOddNumberIn_a_String(str);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
