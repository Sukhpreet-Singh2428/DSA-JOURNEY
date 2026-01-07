//* Check whether one String is a Rotation Of Another
//! (Easy Problem)

//? Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
//? A shift on s consists of moving the leftmost character of s to the rightmost position.

//? For example, if s = "abcde", then it will be "bcdea" after one shift.
//? Example 1
//? Input : s = "abcde" , goal = "cdeab"
//? Output : true
//* Explanation :
//* After performing 2 shifts we can achieve the goal string from string s.
//* After first shift the string s is => bcdea
//* After second shift the string s is => cdeab.

//? Example 2
//? Input : s = "abcde" , goal = "adeac"
//? Output : false
//* Explanation :
//* Any number of shift operations cannot convert string s to string goal.

import java.util.Scanner;
public class J6_CheckWhetherOneStringIs_a_RotationOfAnother {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Boolean checkWhetherOneString_isRotationOfAnother(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }
        int n = s.length();

        for(int i=0; i<n; i++){
            String rotated = s.substring(i) + s.substring(0, i);

            if(rotated.equals(goal)){
                return true;
            }
        }

        return false;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static Boolean CheckWhether_oneStringIsRotatedOfAnother(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }

        String rotated = s + s;
        return rotated.contains(goal);
    }
    //? Time Complexity : O(N) [for adding two string] + O(2N) [for contains]
    //? Space Complexity : O(2N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String goal = sc.next();
        sc.close();
        
        //* Brute : 
        // Boolean ans = checkWhetherOneString_isRotationOfAnother(s, goal);
        // System.out.println(ans);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N)

        //* Optimal : 
        Boolean ans = CheckWhether_oneStringIsRotatedOfAnother(s, goal);
        System.out.println(ans);
        //? Time Complexity : O(N) [for adding two string] + O(2N) [for contains]
        //? Space Complexity : O(N)
    }
}
