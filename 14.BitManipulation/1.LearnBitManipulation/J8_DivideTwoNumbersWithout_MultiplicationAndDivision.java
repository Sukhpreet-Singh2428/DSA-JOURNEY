//* Divide Two Numbers Without Multiplication and Division
//! (Medium Problem)

import java.util.Scanner;
public class J8_DivideTwoNumbersWithout_MultiplicationAndDivision {
    //* Optimal : 
    public static int Divide2Numbers_withoutMultiplicationAndDivision(int dividend, int divisor){
        if(dividend == divisor) return 1;
        boolean sign = true;  //* true -> means +ve

        if(dividend>=0 && divisor<0) sign = false;  //* -ve 
        if(dividend<0 && divisor>0) sign = false;

        long n = Math.abs(dividend);
        long d = Math.abs(divisor);

        int ans = 0;
        while(n >= d){
            int cnt = 0;
            while( n >= (d << (cnt+1)) ){   //? we are checking n >= (d * 2^(cnt+1))
                cnt++;                      //* since, d*2 = d<<1 and d/2 = d>>1
            }
            ans += (1<<cnt);  //* (1 << cnt) => 2^cnt
            n = n - (d * (1<<cnt));
        }

        if(ans >= Integer.MAX_VALUE && sign==true){
            return Integer.MAX_VALUE;
        }
        if(ans >= Integer.MAX_VALUE && sign==false){
            return Integer.MIN_VALUE;
        }

        return sign ? ans : (-1 * ans);
    }
    //? Time Complexity : O( (log2N)^2 )
    //? Space Complexity : O(1)


    //* Brute : 
    //? Works for small positive inputs
    //? gives TLE
    //? Not works for negative cases
    //? Not works for overflow edge cases
    public static int divideTwoNumbers_withoutMultiplicationAndDivision(int dividend, int divisor){
        int sum = 0;
        int cnt = 0;

        while( sum + divisor <= dividend){
            cnt++;
            sum += divisor;
        }

        return cnt;
    }
    //? Time Complexity : O(divident)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        sc.close();

        //* Brute : 
        //? Works for small positive inputs
        //? gives TLE
        //? Not works for negative cases
        //? Not works for overflow edge cases
        // System.out.println(divideTwoNumbers_withoutMultiplicationAndDivision(dividend, divisor));
        //? Time Complexity : O(divident)
        //? Space Complexity : O(1)

        //* Optimal : 
        System.out.println(Divide2Numbers_withoutMultiplicationAndDivision(dividend, divisor));
        //? Time Complexity : O( (log2N)^2 )
        //? Space Complexity : O(1)
        //! Intuition:
        //* The key idea is to repeatedly subtract the divisor from the dividend until the dividend is smaller than the divisor. 
        //* However, doing this one step at a time can be very slow, so we use a method that speeds up the process by leveraging bit manipulation.
        //* An important concept to know is that the quotient can be expressed as the sum of powers of 2.
        //? Example: Dividend = 10, Divisor = 3.
        //* Quotient = 10/3 = 3 which can be represented as 2^1 + 2^0.
        //* Now, instead of subtracting the divisor from the dividend one unit at a time, we use powers of 2 (using bit shifting) 
        //* to subtract larger multiples of the divisors in each step. This makes the process faster.
    }
}
