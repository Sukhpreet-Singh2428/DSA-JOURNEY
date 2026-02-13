//* Check if the Number is odd or not 
//! (Easy Problem)

import java.util.Scanner;
public class J3_CheckIfThe_NumberIsOddOrNot {
    public static boolean checkIfThe_NumberisOdd(int n){
        return (n&1) == 1;
        //? Dry run : 
        //? n = 7
        //? 7 -> 0111
        //? => n&1
        //?  =>  0111
        //?    & 0001
        //?      0001
        //? => Since, n&1 == 1
        //? => if (n&1)==1, means number is odd
        //? => Bcz in odd numbers, there least significant bit(LSB) i.e,
        //? => the leftmost bit is set to 1. so doing & with 1 gives result 1
        //? => if (n&1)==0, means number is even 
        //? Hence, it's return true (for n=7)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //? Check if a Numer is Odd or not
        //? Example 1: 
        //? n = 7    --> true
        //? Example 2:
        //? n = 0    --> false
        //? Example 3:
        //? n = 4    --> false
         //! => Brute force approach : 
        //!     using the modulo(%) => n%2==1
        //! => Optimal Approach : 
        //!     using Bit Manipulation :
        System.out.println(checkIfThe_NumberisOdd(n));
    }
}
