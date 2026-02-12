//* Check if the ith bit is set or not 
//! (Easy Problem)

import java.util.Scanner;
public class J2_CheckIfThe_ithBitIsSetOrNot {
    public static boolean check_ith_bitSetOrNot(int n, int i){
        //? 1. left shift (<<)
        // if( (n & (1 << i)) != 0){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        //? dry run for << :
        //* 13 -> 1101 (binary)
        //* 1 << i => 1 << 2 => 100
        //* ->      1101
        //* ->       100
        //* ->    &
        //* ->      0100
        //* every bit will be zero for 1101 & 100, except for that shift bit
        //* if & of that shift bit is 1 so that means whole number is greater than 0 that means that ith bit is 1 i.e, set
        //* That's why it give true

        //? 2. Right Shift (>>)
        if( ((n>>i) & 1) == 1 ){
            return true;
        }
        else{
            return false;
        }
        //? Dry run for >> : 
        //* 13 -> 1101 (binary)
        //* n>>i => 1101>>2 => 0011
        //*   0011
        //* &    1
        //*   0001 (which is 1)   
        //* If it's gives 1 that means ith bit is set (1) and if it gives 0 that means ith bit is not set (0)
        //* That's why it give true for n=13 and i=2
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        sc.close();

        //? Check if the ith bit is set or not
        //* example-1 : 
        //* N = 13    i=2
        //* 13 -> (binary) -> 1101
        //* set means 1
        //* not set means 0
        //* we have to check the ith bit from right to left
        //* it's 1 -> it's set -> true
        //* example-2 : 
        //* N = 13   i=1
        //* -> false
        //* example-3 : 
        //* N = 13   i=10
        //* 13 -> (binary) -> 1101
        //* -> 0....0000 1101
        //*-> false
        //! => Brute force approach : 
        //!     convert number to its binary form
        //!     then start iterating from right to left
        //!     then check if that ith bit is set or not
        //! => Optimal Approach : 
        //!     using Bit Manipulation :
        //!     1. <<
        //!     2. >>
        System.out.println(check_ith_bitSetOrNot(n, i));
    }
}
