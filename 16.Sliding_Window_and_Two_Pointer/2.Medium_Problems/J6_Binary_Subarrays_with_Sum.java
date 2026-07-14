//* Binary Subarrays with sum
//! (Hard Problem)

//?  arr = [1, 0, 1, 0, 1]    goal = 2

import java.util.Scanner;

public class J6_Binary_Subarrays_with_Sum {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    //? (we will do with the help of, no. of subarrays whose sum <= goal)
    public static int no_ofSubarraysWhoseSumLessThanEqualToGoal(int[] arr, int goal){
        if(goal < 0) return 0;

        int n = arr.length;

        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;

        while(r < n){
            sum += arr[r];

            while(sum > goal){
                sum = sum - arr[l];
                l++;
            }

            cnt = cnt + (r-l+1);

            r++;
        }

        return cnt;
    }
    public static int binarySubarraysWithSum(int[] arr, int goal){
        return no_ofSubarraysWhoseSumLessThanEqualToGoal(arr, goal) - no_ofSubarraysWhoseSumLessThanEqualToGoal(arr, goal-1);
    }
    //? Time Complexity : O(2 * 2N)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        sc.close();

        //* Brute --> Better --> Optimal : 

        //* Optimal : 
        int cnt = binarySubarraysWithSum(arr, goal);
        System.out.println(cnt);
        //? Time Complexity : O(2 * 2N)
        //? Space Complexity : O(1)
    }
}
