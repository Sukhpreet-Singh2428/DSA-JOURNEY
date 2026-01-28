//* Pow(x, n)
//! (Easy Problem)

//? Example 1
//? Input : x = 2.0000 , n = 10
//? Output : 1024.0000
//* Explanation : Answer = 2^10 => 1024
//? Example 2
//? Input : x = 2.0000 , n = -2
//? Output : 0.2500
//* Explanation : Answer = 2^(-2) = 1/4 => 0.25

import java.util.Scanner;
public class J2_Pow_x_n {
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static double Pow(double x, int n){
        if(n==0 || x==1.0) return 1;

        double ans = 1;
        if(n<0){
            x = 1/x;
            n = -1*n;
        }
        for(int i=1; i<=n; i++){
            ans = ans*x;
        }
        return ans;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    //* Optimal : 

    //* (Iterative code)
    public static double pow_x_n(double x, int n){
        if(n==0 || x==1.0) return 1;

        double ans = 1;
        if(n<0){
            x = 1/x;
            n = -1*n;
        }
        while(n>0){
            if(n%2==1){
                ans = ans*x;
                n = n-1;
            }
            else{
                x = x*x;
                n = n/2;
            }
        }

        return ans;
    }
    //? Time Complexity : O(log2N)
    //? Space Complexity : O(1)


    //* (Recursive code)
    public static double pow_X_N(double x, int n){
        if(n==0) return 1.0;
        if(n==1) return x;

        if(n%2==1){
            return x * pow_X_N(x, n-1);
        }
        return pow_X_N(x*x, n/2);
    }
    //? Time Complexity : O(log2N)
    //? Space Complexity : O(log2N) [recursion stack space]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        sc.close();

        //* Brute : (InBuilt function)
        // double ans = Pow(x,n);
        // System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)


        //* Optimal : (Recursive solution)
        // double ans = pow_x_n(x, n);   //? iterative implementaion
        // System.out.println(ans);
        //? Time Complexity : O(log2N)
        //? Space Complexity : O(1)

        double ans = pow_X_N(x, n);   //? recursive implementation
        System.out.println(ans);
        //? Time Complexity : O(log2N)
        //? Space Complexity : O(log2N) [recursion stack space]
    }
}
