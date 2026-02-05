//* Subsets - I
//! (Medium Problem)

//? Given an array nums of n integers. Return array of sum of all subsets of the array nums.
//? Output can be returned in any order.
//? Example 
//? Input : nums = [2, 3]
//? Output : [0, 2, 3, 5]
//* Explanation :
//* When no elements is taken then Sum = 0.
//* When only 2 is taken then Sum = 2.
//* When only 3 is taken then Sum = 3.
//* When element 2 and 3 are taken then sum = 2+3 = 5.

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class J9_Subsets_I {
    public static void subsetSum(int idx, int sum, List<Integer> ans, int[] arr, int n){
        if(idx>=n){
            ans.add(sum);
            return;
        }

        sum += arr[idx];
        subsetSum(idx+1, sum, ans, arr, n);
        sum -= arr[idx];
        subsetSum(idx+1, sum, ans, arr, n);
    }
    //? Time Complexity : O(2^N)
    //? Space Complexity : O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        //* Optimal : 
        List<Integer> ans = new ArrayList<>();
        subsetSum(0, 0, ans, arr, arr.length);
        System.out.println(ans);
        //? Time Complexity : O(2^N)
        //? Space Complexity : O(N)
    }
}
