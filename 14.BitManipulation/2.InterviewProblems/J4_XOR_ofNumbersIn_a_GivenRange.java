//* XOR of numbers in a given range
//! (Medium Problem)

//? Given two integers L and R. Find the XOR of the elements in the range [L , R].
//? Example 1
//? Input : L = 3 , R = 5
//? Output : 2
//? Explanation : answer = (3 ^ 4 ^ 5) = 2.
//? Example 2
//? Input : L = 1, R = 3
//? Output : 0
//? Explanation : answer = (1 ^ 2 ^ 3) = 0.

import java.util.Scanner;
public class J4_XOR_ofNumbersIn_a_GivenRange {
    //* Brute :
    public static int xorOfNumbersInRange(int l, int r){
        int ans = 0;
        for(int i=l; i<=r; i++){
            ans = ans ^ i;
        }
        return ans;
    }
    //? Time Complexity : O( (r-l)+1 ) -> O(N) where N is the (r-l)+1
    //? Space Complexity : O(1)

    //* Optimal : 
    public static int XORtillN(int n){
        if(n%4==1) return 1;
        else if(n%4==2) return n+1;
        else if(n%4==3) return 0;
        else return n;
    }
    public static int Xor_ofNumberInRange(int l, int r){
        //* Observe the pattern : 
        //? N=1                         1
        //? N=2    1^2                  3
        //? N=3    1^2^3                0
        //? N=4    1^2^3^4              4

        //? N=5    1^2^3^4^5            1
        //? N=6    1^2^3^4^5^6          7
        //? N=7    1^2^3^4^5^6^7        0
        //? N=8    1^2^3^4^5^6^7^8      8

        //? N=9                         1

        //? N=13                        1
        
        //*               ans
        //* N%4 == 1       1
        //* N%4 == 2      N+1
        //* N%4 == 3       0
        //* N%4 == 0       N 

        return XORtillN(l-1) ^ XORtillN(r);
    }
    //? Time Complexity : O(1)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        sc.close();

        //* Brute : 
        // System.out.println(xorOfNumbersInRange(l,r));
        //? Time Complexity : O( (r-l)+1 ) -> O(N) where N is the (r-l)+1
        //? Space Complexity : O(1)


        //* Optimal : 
        System.out.println(Xor_ofNumberInRange(l,r));
        //? Time Complexity : O(1)
        //? Space Complexity : O(1)
    }
}
