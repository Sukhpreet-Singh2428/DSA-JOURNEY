//* Subsets - II
//! (Medium Problem)

//? Given an integer array nums, which can have duplicate entries, provide the power set.
//? Duplicate subsets cannot exist in the solution set. Return the answer in any sequence.
//? Example 1
//? Input : nums = [1, 2, 2]
//? Output : [ [ ] , [1] , [1, 2] , [1, 2, 2] , [2] , [2, 2] ]
//? Example 2
//? Input : nums = [1, 2]
//? Output : [ [ ], [1] , [2] , [1, 2] ]

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class J10_Subsets_II {
    public static void subsetII(int idx, List<List<Integer>> ans, List<Integer> ls, int[] arr, int n){
        if(idx>=n){
            ans.add(new ArrayList<>(ls));
            return;
        }

        ls.add(arr[idx]);
        subsetII(idx+1, ans, ls, arr, n);
        ls.remove(ls.size()-1);
        // int j = idx+1;
        // while(j<n && arr[j]==arr[idx]){
        //     j++;
        // }
        // subsetII(j, ans, ls, arr, n);
        //* to improve the complexity, we can eliminate this for-loop with binary search as arr is sorted [we sort it] !
        idx = upperBound(arr, idx, arr[idx], n);
        subsetII(idx, ans, ls, arr, n);
    }
    public static int upperBound(int[] arr, int idx, int target, int n){
        int low = idx;
        int high = n-1;
        int ans = n;  //? if no element is greater than arr[idx] then return n so that recursion can stop after this.
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= target){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    //? Time Complexity : O(2^N * N) + O(NlogN) [due to sorting the arr]
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
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(arr);  //? we sort the array so that we can identify the subset is unique or not !
        subsetII(0, ans, ls, arr, arr.length);
        System.out.println(ans);
        //? Time Complexity : O(2^N * N) + O(NlogN) [due to sorting the arr]
        //? Space Complexity : O(N)
    }    
}
