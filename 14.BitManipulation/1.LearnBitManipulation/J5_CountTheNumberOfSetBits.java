//* Count the number of set bits
//! (Easy Problem)

import java.util.Scanner;
public class J5_CountTheNumberOfSetBits {
     public static int count_theNumberOfSetBits(int n){
        //* Brute : 
        // int cnt = 0;
        // while(n>0){
        //     if(n%2 == 1){
        //         cnt++;
        //     }
        //     n = n/2;
        // }
        // return cnt;

        //* Bit Manipulation : 
        // int cnt = 0;
        // while(n>0){
        //     cnt += n&1;   //* ( n&1 --> check odd)
        //     n = n>>1;     //* ( n>>1 -> divide n by 2)
        // }
        // return cnt;
        //? Time Complexity : O(log2N)
        //? Space Complexity : O(1)

        //* Optimal : 
        int cnt = 0;
        while(n != 0){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
        //? Time Complexity : O(No. of set bits)
        //? Space Complexity : O(1)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //? Count the number of set bits 
        //* example 1
        //* n = 16
        //* 16 -> 10000
        //* return 1 (no. of set bits)
        //* example 2 
        //* n = 13
        //* 13 -> 1101
        //* return 3 (no. of set bits)
        System.out.println(count_theNumberOfSetBits(n));
    }
}
