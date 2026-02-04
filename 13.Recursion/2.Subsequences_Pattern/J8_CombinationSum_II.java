//* Combination Sum - II
//! (Medium Problem)

//* We have to find all unique Combinations 
//? Input : candidates = [2, 5, 2, 1, 2] , target = 5
//? Output : [ [1, 2, 2] , [5] ]
//? Explanation : The combinations sum up to target are
//? 1 + 2 + 2 => 5.
//? 5 => 5.
//* 2 + 1 + 2 => 5 also 5 but it is not unique as [1,2,2] is already taken.
//*        as if we sort these two both are [1,2,2] so it will not count as unique if we take it.
//* also, [2,1,1,1] => 5 is not allowed, as one element can only be allow to take once's. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class J8_CombinationSum_II {
    public static void combinationSum_II(int idx, List<List<Integer>> ans, List<Integer> ls, int[] arr, int sum, int n){
        if(sum == 0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(sum<0 || idx==n){
            return;
        }
        
        ls.add(arr[idx]);
        combinationSum_II(idx+1, ans, ls, arr, sum-arr[idx], n);
        ls.removeLast();
        // for(int j=idx+1; j<n; j++){
        //     if(arr[j] != arr[idx]){
        //         combinationSum_II(j, ans, ls, arr, sum, n);
        //         break;
        //     }
        // }
        //* to improve the complexity, we can eliminate this for-loop with binary search as arr is sorted [we sort it] !
        idx = upperBound(arr, idx, arr[idx]);
        combinationSum_II(idx, ans, ls, arr, sum, n);
    }
    public static int upperBound(int[] arr, int idx, int target){
        int low = idx;
        int high = arr.length-1;
        int ans = arr.length;  //? if no element is greater than arr[idx] then return n so that recursion can stop after this.
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=target){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    //? Time Complexity : O(2^N * N) + O(NlogN) [for sorting the arr]
    //? Space Complexity : O(N) 

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

        Arrays.sort(arr);  //? we sort the array so that we can identify the combination is unique or not !
        combinationSum_II(0, ans, ls, arr, sum, n);
        System.out.println(ans);
        //? Time Complexity : O(2^N * N) + O(NlogN) [for sorting the arr]
        //? Space Complexity : O(N) 
    }
}
