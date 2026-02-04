//* Combination Sum I
//! (Medium Problem)

//? Example 1
//? Input : candidates = [2, 3, 5, 4] , target = 7
//? Output : [ [2, 2, 3] , [3, 4] , [5, 2] ]
//* Explanation :
//* 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//* 5 and 2 are candidates, and 5 + 2 = 7.
//* 3 and 4 are candidates, and 3 + 4 = 7.
//* There are total three combinations.
//? Example 2
//? Input : candidates = [2], target = 1
//? Output : []
//* Explanation : There is no way we can choose the candidates to sum up to target.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J7_CombinationSum_I {

    public static void combinationSum_I(int idx, List<List<Integer>> ans, List<Integer> ls, int[] arr, int sum, int n){
        if(sum == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(sum<0 || idx==n){
            return;
        }

        ls.add(arr[idx]);
        combinationSum_I(idx, ans, ls, arr, sum-arr[idx], n);
        ls.removeLast();
        combinationSum_I(idx+1, ans, ls, arr, sum, n);
    }
    //? Time Complexity: O(K*2N), where N is the number of elements, 
    //?     due to the exponential number of possible combinations explored 
    //?     in the worst case. For each subset, it may take up to K operations 
    //?     to process, where K is the maximum length of any subset in the result
    //? Space Complexity: O(K*N), where N is the maximum depth of recursion, 
    //?     which corresponds to the length of the combination path stored in memory.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        sc.close();

        //* Optimal 
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        combinationSum_I(0, ans, ls, arr, sum, n);
        System.out.println(ans);
        //? Time Complexity: O(K*2N), where N is the number of elements, 
        //?     due to the exponential number of possible combinations explored 
        //?     in the worst case. For each subset, it may take up to K operations 
        //?     to process, where K is the maximum length of any subset in the result
        //? Space Complexity: O(K*N), where N is the maximum depth of recursion, 
        //?     which corresponds to the length of the combination path stored in memory.
    }
}
