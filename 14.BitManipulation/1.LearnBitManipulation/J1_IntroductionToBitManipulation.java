//* Introduction to bit Manipulation [Theory]

//? Binary Number Conversion (1's & 2's complement)
//? Operators (AND, OR, XOR, NOT SHIFT)
//? Swap 2 numbers
//? Check if the ith bit is set or not
//? extract the ith bit
//? set the ith bit
//? clear the ith bit
//? Toggle the ith bit
//? remove the last set bit
//? check if the number is the power of 2 or not
//? count the number of set bits

import java.util.Scanner;
public class J1_IntroductionToBitManipulation {

    public static String convert2Binary(int n){
        StringBuilder res = new StringBuilder("");
        while(n > 0){
            if(n%2 == 1) res.append('1');
            else res.append('0');
            n = n/2;
        }
        res.reverse();
        return res.toString();
    }
    //? Time Complexity : O(log2N)
    //? Space Complexity : O(log2N)

    public static int convert2Decimal(String s){
        // int res = 0;
        // int converter = 1;
        // for(int i=s.length()-1; i>=0; i--){
        //     res += (s.charAt(i) - '0')*converter;
        //     converter *= 2;
        // }
        // return res;

        int res = 0;
        int val = 1;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                res += val;
            }
            val *= 2;
        }
        return res;
    }
    //? Time Complexity : O(len)
    //? Space Complexity : O(1)

    public static String One_s_Complement(String s){
        StringBuilder res = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                res.setCharAt(i, '0');
            }
            else{
                res.setCharAt(i, '1');
            }
        }
        return res.toString();
    }

    public static String Two_s_Complement(String s){
        //? 1's Complement
        String x = One_s_Complement(s);
        StringBuilder ans = new StringBuilder(x);
        ans.reverse();
        int i = 0;
        int carry = 1;
        while(i<ans.length()){
            int sum = ans.charAt(i) - '0';
            sum += carry;
            ans.setCharAt(i, (char)(sum%2 + '0'));
            // if(sum%2 == 0){
            //     ans.setCharAt(i, '0');
            // }
            // else{
            //     ans.setCharAt(i, '1');
            // }
            carry = sum/2;
            i++;
        }
        //? If the addition produces an overflow carry beyond the leftmost bit : We discard the extra
        //? example (4-bit system):
        //?         s = 0101
        //?  1’s comp = 1010
        //?        +1   ----
        //?             1111   ← result
        //?          1111 + 1 = 1 0000  [2's complement]
        //?      Result = 0000   (still 4 bits)
        ans.reverse();
        return ans.toString();
    }

    public static void swapTwoNumber(int a, int b){
        System.out.println("a = " + a + ", " + "b = " + b);
        
        a = a ^ b;
        b = a ^ b;  //? [ b = a ^ b] -> [ b = (a ^ b) ^ b ] -> [ b = a ]
        a = a ^ b;  //? [ a = a ^ b ] -> [ a = (a ^ b) ^ (a) ] -> [ a = b ]

        System.out.println("a = " + a + ", " + "b = " + b);
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1), No extra space or No third variable is used.

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

    public static int setThe_ithBit(int n, int i){
        return n | (1<<i);
        //? Dry run :
        //? n = 9   i = 2
        //? 9 -> 1001
        //? => 1 << 2 => ...00001 << 2 => 0100
        //? => n | (1<<i)
        //?   1001
        //? | 0100
        //?   1101 (which is 13)
        //? it's return 13
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

    public static int clearThe_ithBit(int n, int i){
        return n & ~(1<<i);
        //? Dry run : 
        //? n=13   i=2
        //? 13 -> 1101
        //? => 1<<i => 1<<2 => 100
        //? => ~(1<<i) => 011
        //? n & ~(1<<i) : 
        //?       1101
        //? & 1...1011
        //?       1001 (which is 9)
        //? it's return 9
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

    public static int toggleThe_ithBit(int n, int i){
        return n ^ (1<<i);
        //? Dry run : 
        //? n=13   i=2
        //? 13 -> 1101
        //? => 1<<i => 1<<2 => 100
        //? n ^ (1<<i) : 
        //?    1101
        //?  ^ 0100
        //?    1001 (which is 9)
        //? it's return 9
        //? another example : 
        //? n=12   i=3
        //? 12 -> 1100
        //? => 1<<i => 1<<3 => 1000
        //?     1100
        //?  ^  1000
        //?     0100 (which is 4)
        //? it's return 4
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

    public static int removeThe_lastSetBit(int n){
        return n & (n-1);
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
        //? n = 40 -> 101000
        //? n = 39 -> 100111
        //?         & 
        //?           100000
        //? Hence, the last set bit is removed 
        //? and its return 32
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

    public static boolean power_of_2(int n){
        if( (n>0) && (n & (n-1)) == 0 ){
            return true;
        }
        else{
            return false;
        }
        //? Dry run : 
        //? explained in above method i.e, remove_ThelastSetBit
        //? as for n be an power of 2 there should be only 1 set bit and
        //? in n-1, the last set bit is zero and all the right side bits to it are set
        //? so & between n and n-1 i.e, n & (n-1) will give 0 for power of 2
        //? That's why return n & (n-1)
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

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
        // int i = sc.nextInt();
        // String s = sc.next();
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        sc.close();

        //* Converting Decimal to Binary 
        // System.out.println(convert2Binary(n));
        //? Time Complexity : O(log2N)
        //? Space Complexity : O(log2N)

        //* Converting Binary to Decimal
        // System.out.println(convert2Decimal(s));
        //? Time Complexity : O(len)
        //? Space Complexity : O(1)

        //* 1's Complement : The one's complement of a binary number is obtained by flipping all the bits.
        // System.out.println(One_s_Complement(s));

        //* 2's Complement : The two's complement is obtained by taking the one's complement of a number and then adding 1.
        // System.out.println(Two_s_Complement(s));


        //* Operators (AND, OR, XOR, NOT SHIFT) :

        //* AND :  -> all true -> true
        //*        -> any false -> false
        //? The AND operator is denoted by & and performs a bitwise AND operation. If both corresponding bits are 1, the resulting bit is 1; otherwise, the resulting bit is 0.
        //? Example: 13 & 7 is:
        //?    13: 1101
        //?     7: 0111
        //?   & -------
        //?    5: 0101

        //* OR :  -> 1 true -> true
        //*       -> all false -> false
        //? The OR operator is denoted by | and performs a bitwise OR operation. If either corresponding bit is 1, the resulting bit is 1; otherwise, the resulting bit is 0.
        //? Example: 13 | 7 is:
        //?    13: 1101
        //?    7: 0111
        //?    | --------
        //?    15: 1111

        //* XOR :  no. of 1's -> odd -> 1
        //*        no. of 1's -> even -> 0
        //? The XOR operator is denoted by ^ and performs a bitwise XOR operation. If the number of 1s in corresponding bit positions is odd, the resulting bit is 1; if even, the resulting bit is 0.
        //? Example: 13 ^ 7 is:
        //?    13: 1101
        //?    7: 0111
        //?    ^ --------
        //?    10: 1010

        //* SHIFT : 
        //* 1. Right Shift >>
        //? Right Shift (>>): Shifts the bits to the right, discarding the bits that fall off and filling the leftmost bits with zeros.
        //? Example:    13 >> 1 = 1101 >> 1 = 0110 (binary of 6)
        //? Example :   13 >> 2
        //?             1101 >> 2
        //?             0011 (binary of 3)
        //? Example :   13 >> 4
        //?             1101 >> 4
        //?             0000 (binary of 0)
        //!         --> n >> k =  n/2^k
        //* 2. Left Shift << 
        //? Left Shift (<<): Shifts the bits to the left, discarding the bits that fall off and filling the rightmost bits with zeros.
        //? Example:    13 << 1 = 1101 << 1 = 11010 (binary of 26)
        //!         --> num << k = num * 2^k
        //? (2^31 -1) << 1 --> overflow

        //* NOT(~) :  flips all the bits in the number
        //?  x = ~ (5)
        //? 1. flip
        //? 2. check -ve  : -> (yes) -> 2's
        //?                 -> (No) -> stop
        //! [NOTE : Bitwise NOT (~) performs only bit flipping.
        //!         Two’s complement is used only to interpret the resulting signed value,
        //!         not as part of the NOT operation.
        //! ]
        //? The NOT operator is denoted by ~ and flips all the bits in the number.
        //? Example: ~5 is:
        //?    5: 0000 0101
        //?   ~5: 1111 1010 [computer return result]

        //* We (humans) interpret the result
        //* Since MSB = 1 → negative number  [Leftmost bit → MSB]
        //* To find its decimal value, take 2's complement
        //*     1111 1010 (it is -ve, as it's sign bit[which is the last leftmost bit])
        //?     (2. check -ve -> yes -> doing 2's)
        //?     0000 0101  (1's)
        //?     0000 0101
        //?    +        1
        //?     0000 0110 (2's)
        //?     0000 0110 (which is -6)

        //? Example : x = ~ (-6)
        //? -6 =>  Computer stores it as 2's complememt of 6
        //?        6 -> 0000 0110
        //?             1111 1001 (1's)
        //?             1111 1001
        //?            +        1
        //?             1111 1010 (2's)
        //?   -6 => 1111 1010
        //?   ~(-6) => 0000 0101
        //* Interpret result(to see its decimal value of ~(-6))
        //* leftMost bit -> 0 -> +ve
        //* 0000 0101 (which is +5)
        //* decimal value is +5   


        //? Swap 2 numbers
        // swapTwoNumber(a,b);

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
        // System.out.println(check_ith_bitSetOrNot(n, i));

        //? Set the ith bit 
        //* example
        //*  N=9    i=2
        //*  1001
        //* Set the ith bit -> set the 2nd bit from right to left
        //* 1001 => 1101 (which is 13)
        //! => Brute force logic
        //!     convert number to its binary form
        //!     then start iterating from right to left
        //!     then set the ith bit 
        //!     then after the set of ith bit
        //!     return that number in its decimal form
        //! => Optimal Apporach : 
        //!     using Bit Manipulation
        // System.out.println(setThe_ithBit(n, i));

        //? Clear the ith bit 
        //* example
        //*  N=13   i=2
        //*  13 -> 1101
        //* clear the ith bit -> clear the 2nd bit from right to left
        //* 1101 => 1001 (which is 9)
        //! => Brute force logic
        //!     convert number to its binary form
        //!     then start iterating from right to left
        //!     then clear the ith bit 
        //!     then after the clear of ith bit
        //!     return that number in its decimal form
        //! => Optimal Apporach : 
        //!     using Bit Manipulation
        // System.out.println(clearThe_ithBit(n, i));

        //? Toggle the ith bit
        //* example 
        //*  N=13    i=2
        //*  13 -> 1101
        //* toggle the ith bit -> toggle the 2nd bit from right to left
        //* 1101 => 1001 (which is 9)
        //! => Brute force logic
        //!     convert number to its binary form
        //!     then start iterating from right to left
        //!     then toggle the ith bit 
        //!     then after the toggle of ith bit
        //!     return that number in its decimal form
        //! => Optimal Apporach : 
        //!     using Bit Manipulation
        // System.out.println(toggleThe_ithBit(n,i));

        //? Remove the Last Set Bit (rightmost)
        //* example 1 
        //* N = 12
        //* 12 -> 1100
        //* remove the last set bit
        //* => 1000 (which is 8)
        //* example 2
        //* N = 13
        //* 13 -> 1101
        //* remove the last set bit
        //* => 1100 (which is 12)
        //* example 3
        //* N = 16
        //* 16 -> 10000
        //* remove the last set bit
        //* => 00000 (which is 0)
        //! => Brute force logic
        //!     convert number to its binary form
        //!     then start iterating from right to left
        //!     then remove the last set bit comes
        //!     then after removed the last set bit
        //!     return that number in its decimal form
        //! => Optimal Apporach : 
        //!     using Bit Manipulation
        // System.out.println(removeThe_lastSetBit(n));

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
        // System.out.println(power_of_2(n));

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
