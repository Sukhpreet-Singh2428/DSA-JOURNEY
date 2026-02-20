//* Minimum Bit Flips to Convert Number
//! (Medium Problem)

//? Example 1
//? Input : start = 10 , goal = 7
//? Output : 3
//* Explanation : The binary representation of 10 is "1010".
//* The binary representation of 7 is "111".
//* If we flip the underlined bits in binary representation of 10 then we will obtain our goal.
//? Example 2
//? Input : start = 3 , goal = 4
//? Output : 3
//* Explanation : The binary representation of 3 is "011".
//* The binary representation of 4 is "100".
//* So if we flip all the three bits of 3 then we will reach our goal number.

import java.util.Scanner;
public class J1_MinimumBitFlipsToConvertNumber {
    public static int minimumBit_flipsToConvertNumber(int start, int goal){
        
        int ans = start ^ goal;

        int cnt = 0;
        while(ans != 0){
            cnt += ans&1;
            ans = ans>>1;
        }

        return cnt;

        //? Dry run : 
        //? start = 10    goal = 7
        //? => 10 -> 1010
        //? =>  7 -> 0111
        //? => as, ans = start ^ goal
        //? =>    1010
        //? =>    0111
        //? =>   ^
        //? =>    1101
        //? => ans = 1101
        //? => so, in ans basically the no. of set bits are the number
        //? => of flips required in start in order to get the goal 
        //? => so the count of no. of bits are required to flips is the 
        //? => no. of set bits in the ans
        //? => 1101 -> has 3 set bits
        //? => Hence, its return 3
    }
    //? Time Complexity : O(log2(start^goal))
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int goal = sc.nextInt();
        sc.close();

        //* Optimal : 
        //*  => using bit manipulation
        System.out.println(minimumBit_flipsToConvertNumber(start, goal));
        //? Time Complexity : O(log2(start^goal))
        //? Space Complexity : O(1)
    }
}
