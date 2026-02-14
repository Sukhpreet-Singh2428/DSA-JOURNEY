//* Check if Number is power of 2 or not
//! (Easy Problem)

import java.util.Scanner;
public class J4_CheckIf_NumberIsPowerOf2OrNot {
    public static boolean power_of_2(int n){
        if( (n>0) && (n & (n-1)) == 0 ){
            return true;
        }
        else{
            return false;
        }
        //? Dry run : 
        //? Dry run : 
        //? But first observation : 
        //? n = 16 -> 10000
        //? n = 15 -> 01111
        //? n = 40 -> 101000
        //? n = 39 -> 100111
        //? if we observe that if the last set bit of 16 and 40 are removed i.e, clear
        //? and all the bits to its right side are toggle or we can say that all the bits
        //? to its right side are set in 15 and 39 i.e, n - 1
        //? so if we do & between n and n-1, we are end up removing the last set bit 
        //? n = 16 -> 10000
        //? n = 15 -> 01111
        //?         & 
        //?           00000
        //? => as for n be an power of 2 there should be only 1 set bit and
        //? in n-1, the last set bit is zero and all the right side bits to it are set
        //? so & between n and n-1 i.e, n & (n-1) will give 0 for power of 2.
        //? That's why return n & (n-1)
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //? Check if the number is a power of 2 or not
        //* example 
        //* n = 16 -> true
        //* n = 13 -> true 
        //! => Brute force logic
        //!     convert number to its binary form
        //!     then start iterating from right to left
        //!     then count the no. of set bits
        //!     if the no. of set bits = 1 then its a power of 2 and
        //!     return true, else return false
        //! => Optimal Apporach : 
        //!     using Bit Manipulation
        System.out.println(power_of_2(n));
    }
}
