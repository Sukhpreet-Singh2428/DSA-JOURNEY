//* Power Set using Bit Manipulation
//! (Medium Problem)

//? Given an array of integers nums of unique elements. 
//? Return all possible subsets (power set) of the array.
//? Do not include the duplicates in the answer.
//? Example 1
//? Input : nums = [1, 2, 3]
//? Output : [ [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]
//? Example 2
//? Input : nums = [1, 2]
//? Output : [ [ ] , [1] , [2] , [1, 2] ]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J3_PowerSet_usingBitManipulation {
    public static List<List<Integer>> powerSet(int[] arr){
        int n = arr.length;

        List<List<Integer>> ans = new ArrayList<>();
        int subsets = (1 << n);  //* subsets -> 2^n
        for(int val = 0; val<subsets; val++){
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<n; i++){
                if( (val & (1<<i)) != 0 ){
                    ls.add(arr[i]);
                }
            }
            ans.add(ls);
        } 

        return ans;

        //? Dry run : 
        //? arr[] = {1, 2, 3}
        //? => subsets = 2^n = 2^3 = 8
        //? => subsets = 1 << n = 8
        //?    arr = {1, 2, 3}
        //?           0  1  2
        //? 
        //?         2  1  0
        //?   0 ->  0  0  0  ->  []
        //?   1 ->  0  0  1  ->  [1]
        //?   2 ->  0  1  0  ->  [2]
        //?   3 ->  0  1  1  ->  [1,2]
        //?   4 ->  1  0  0  ->  [3]
        //?   5 ->  1  0  1  ->  [1,3]
        //?   6 ->  1  1  0  ->  [2,3]
        //?   7 ->  1  1  1  ->  [1,2,3]
    }
    //? Time Complexity : O(2^N * N)
    //? Space Complexity : O(2^N * N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        //* Optimal : 
        //* using Bit Manipulation 
        List<List<Integer>> ans = powerSet(arr);
        System.out.println(ans);
        //? Time Complexity : O(2^N * N)
        //? Space Complexity : O(2^N * N)
    }
}
