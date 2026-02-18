//* Set the rightmost unset bit
//! (Easy Problem)

//? Problem Statement: Given a positive integer n, set the rightmost unset (0) bit of its binary representation to 1 and return the resulting integer.
//? If all bits are already set, return the number as it is.

import java.util.Scanner;
public class J6_SetThe_Rightmost_UnsetBit {
    public static int setTheRightmostBit(int n){
        int x = n;
        int pos = 0;

        while(x != 0){
            if( (x&1) != 1 ){
                return n | 1<<pos;
            }
            x = x>>1;
            pos++;
        }

        return n;
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //! Optimal : 
        //! Using bit manipulation
        System.out.println(setTheRightmostBit(n));
    }
}
