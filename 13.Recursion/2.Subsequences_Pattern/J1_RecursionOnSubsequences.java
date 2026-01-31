//* Recursion on Subsequences

//* Print all Subsequences
//! Subsequences :- a contigous/non-contigous sequences, which follows the order.
//? Example : 
//? arr --> [3, 1, 2]
//? Subsequences --> 3
//?                  1       
//?                  2
//?                 {} (empty)
//?                 3 1
//?                 1 2
//?                 3 2
//?                 3 1 2
//! 3 2 1 --> will not count as subsequences bcz it is not following the order of the array.
//!           and definition of subsequences is a contigous/non-contigous sequences, which follows the order.
//!           here, order of the array is 3 has to come before 1,2 and 1 has to come before 2    

import java.util.ArrayList;
public class J1_RecursionOnSubsequences {
    public static void f(int idx, ArrayList<Integer> ls,int[] arr, int n){
        if(idx >= n){
            for(int x : ls){
                System.out.print(x + " ");
            }
            if(ls.size()==0){
                System.out.println("null");
            }
            System.out.println();
            return;
        }
        //* take or pick the particular index into the subsequence
        ls.add(arr[idx]);
        f(idx+1, ls, arr, n);
        //* not pick, or not take condition, this element is not added to your subsequence
        ls.removeLast();
        f(idx+1, ls, arr, n);
    }
    //? Time Complexity : O(2^N * N)
    //? Space Complexity : O(N) [Stack Space]
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        ArrayList<Integer> ls = new ArrayList<>();
        f(0, ls, arr, arr.length);
        //? Time Complexity : O(2^N * N)
        //? Space Complexity : O(N) [Stack Space]
    }
}
