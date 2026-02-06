//* Combination Sum III
//! (Medium Problem)

//? Determine all possible set of k numbers that can be added together to equal n while meeting the following requirements:
//? There is only use of numerals 1 through 9.
//? A single use is made of each number.
//? Return list of every feasible combination that is allowed. The combinations can be returned in any order, but the list cannot have the same combination twice.
//? Example 1
//? Input : k = 3 , n = 7
//? Output : [ [1, 2, 4] ]
//* Explanation :
//* 1 + 2 + 4 = 7
//* There are no other valid combinations.
//? Example 2
//? Input : k = 3, n = 9
//? Output : [[1, 2, 6],[1, 3, 5],[2, 3, 4]]
//* Explanation :
//* 1 + 2 + 6 = 9
//* 1 + 3 + 5 = 9
//* 2 + 3 + 4 = 9
//* There are no other valid combinations.
//! keyPoints : unique sets of size k allowed and each number occurs only one time

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J11_CombinationSum_III {
    public static void combinationSumIII(int sum, int last, List<Integer> ls, int k, List<List<Integer>> ans){
        if(sum == 0 && ls.size()==k){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(sum <= 0 || ls.size() > k) return;

        for(int i=last; i<=9; i++){
            if(i<=sum){
                ls.add(i);
                combinationSumIII(sum-i, i+1, ls, k, ans);
                ls.remove(ls.size()-1);
            }
            else{
                break;
            }
        }
    }
    //? Time Complexity: O(2^9 * K), This complexity arises because 
    //?     the algorithm explores all possible combinations of elements 
    //?     from the set {1, 2, ..., 9}. Each number can either be included 
    //?     or excluded during the recursive exploration, leading to 2⁹ possible subsets in total. 
    //?     For each subset, forming and validating the current combination requires up to O(K) operations.
    //? Space Complexity: O(K), due to the maximum depth of the recursion stack, which is K.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        //* Optimal : 
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        combinationSumIII(n, 1, ls, k, ans);
        System.out.println(ans);
        //? Time Complexity: O(2^9 * K), This complexity arises because 
        //?     the algorithm explores all possible combinations of elements 
        //?     from the set {1, 2, ..., 9}. Each number can either be included 
        //?     or excluded during the recursive exploration, leading to 2⁹ possible subsets in total. 
        //?     For each subset, forming and validating the current combination requires up to O(K) operations.
        //? Space Complexity: O(K), due to the maximum depth of the recursion stack, which is K.

        //* another solution / Brute : 
        // int[] nums = new int[9];
        // for(int i=0; i<9; i++){
        //     nums[i] = i+1;
        // }
        // List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> ls = new ArrayList<>();
        // subset(0, 0, ans, ls, k, n, nums, nums.length);
        // System.out.println(ans);
    }

    public static void subset(int idx, int sum, List<List<Integer>> ans, List<Integer> ls, int len, int totalSum, int[] nums, int n){
        if(sum == totalSum && ls.size()==len){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(idx==n){
            return;
        }
        if(ls.size()>len){
            return;
        }

        ls.add(nums[idx]);
        sum += nums[idx];
        subset(idx+1, sum, ans, ls, len, totalSum, nums, n);
        ls.remove(ls.size()-1);
        sum -= nums[idx];
        subset(idx+1, sum, ans, ls, len, totalSum, nums, n);
    }
}
