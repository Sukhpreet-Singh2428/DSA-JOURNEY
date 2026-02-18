//* Swap Two Numbers
//! (Easy Problem)

import java.util.Scanner;
public class J7_SwapTwoNumbers {
    public static void swap_TwoNumbers(int a, int b){
        System.out.println("Before : a = " + a + ", " + "b = " + b);

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("After : a = " + a + ", " + "b = " + b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        //! Brute force Approach :
        //!   using the third variable, temp
        //!   int temp = a;
        //!   a = b;
        //!   b = temp;
        //! Optimal : 
        //!     Using Bit Manipulation : 
        //!     using XOR (^)
        swap_TwoNumbers(a, b);
    }
}
