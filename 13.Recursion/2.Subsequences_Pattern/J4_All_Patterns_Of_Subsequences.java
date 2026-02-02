//* Learn All Patterns of Subsequences

//? Printing Subsequences whose sum is k
//! before this, firstly we know that how to print all subsequences with
//! technique take/not-take

//? Print any subsequence whose sum is k
//* (Technique to print one answer)
//! Important 
//! Technique : 
//! f() {
//!     base case : 
//!        if condition -> satisfied
//!         return true
//!        else -> condition not satisfied
//!         return false
//!     
//!     if( f() == true ){
//!         return true
//!     }
//!     
//!     return false
//! }

//? Count the Subsequences whose sum is k
//! Technique : 
//! f() {
//!     base case : 
//!        if condition -> satisfied
//!         return 1
//!        else -> condition not satisfied
//!         return 0
//!     
//!     l = f()
//!     r = f()
//!     
//!     return l + r;
//! }

//* All these problems following the take/not-take technique, but they are smartly modify
//* according to their problem statment so that we can get the answer by reducing
//* recursion call [done in print any subsequence] or we can get the answer in more 
//* effective manner [done in count subsequence, by eliminating ls data structure] 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J4_All_Patterns_Of_Subsequences {
    //? Printing Subsequences whose sum is k
    public static void Subsequences_withSumK(int idx, List<Integer> ls, int sum, int k, int[] arr, int n){
        if(idx==n){
            if(sum==k){
                System.out.println(ls);
            }
            return;
        }
        ls.add(arr[idx]);
        sum += arr[idx];
        Subsequences_withSumK(idx+1, ls, sum, k, arr, n);
        ls.remove(ls.size()-1);
        sum -= arr[idx];
        Subsequences_withSumK(idx+1, ls, sum, k, arr, n);
    }

    //? Print any subsequence whose sum is k
    public static boolean PrintAnyOne_Subsequence_withSumK(int idx, List<Integer> ls, int sum, int k, int[] arr, int n){
        if(idx==n){
            //* condition satisfied
            if(sum==k){
                System.out.println(ls);
                return true;
            }
            //* condition not satisfied
            else return false;
        }

        ls.add(arr[idx]);
        sum += arr[idx];

        if(PrintAnyOne_Subsequence_withSumK(idx+1, ls, sum, k, arr, n) == true){
            return true;
        }

        sum -= arr[idx];
        ls.removeLast();  //? or ls.remove(ls.size()-1)

        if(PrintAnyOne_Subsequence_withSumK(idx+1, ls, sum, k, arr, n) == true){
            return true;
        }

        return false;
    }

    //? Count the Subsequences whose sum is k
    public static int Count_Subsequences_withSumK(int idx, int sum, int k, int[] arr, int n){
        if(idx == n){
            //* Condition satisfied
            if(sum == k){
                return 1;
            }
            //* condition not satisfied
            else return 0;
        }

        sum += arr[idx];

        int l = Count_Subsequences_withSumK(idx+1, sum, k, arr, n);

        sum -= arr[idx];

        int r = Count_Subsequences_withSumK(idx+1, sum, k, arr, n);

        return l+r;
    }
    //? Time Complexity : O(2^n)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        //? Printing Subsequences whose sum is k 
        // List<Integer> ls = new ArrayList<>();
        // Subsequences_withSumK(0, ls, 0, k, arr, n);

        //? Print any one subsequence whose sum is k
        //* (Technique to print one answer)
        //! Important 
        //! Technique : 
        //! f() {
        //!     base case : 
        //!        if condition -> satisfied
        //!         return true
        //!        else -> condition not satisfied
        //!         return false
        //!     
        //!     if( f() == true ){
        //!         return true
        //!     }
        //!     
        //!     return false
        //! }
        List<Integer> ls = new ArrayList<>();
        PrintAnyOne_Subsequence_withSumK(0, ls, 0, k, arr, n);

        //? Count the Subsequence whose sum is k
        //! Technique : 
        //! f() {
        //!     base case : 
        //!        if condition -> satisfied
        //!         return 1
        //!        else -> condition not satisfied
        //!         return 0
        //!     
        //!     l = f()
        //!     r = f()
        //!     
        //!     return l + r;
        //! }
        System.out.println(Count_Subsequences_withSumK(0, 0, k, arr, n));
    }
}
