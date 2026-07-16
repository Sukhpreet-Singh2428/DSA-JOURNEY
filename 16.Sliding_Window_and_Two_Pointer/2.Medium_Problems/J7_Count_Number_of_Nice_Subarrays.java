//* Count number of nice subarrays 
//! (Hard Problem)

//? nums = [1, 1, 2, 1, 1]  k=3

import java.util.Scanner;

public class J7_Count_Number_of_Nice_Subarrays {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static int no_ofSubarraysWhoseSumLessThanEqualToGoal(int[] arr, int goal){
        if(goal < 0) return 0;

        int n = arr.length;

        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;

        while(r < n){
            sum += arr[r]%2;   //? => for odd = 1 and for even = 0

            while(sum > goal){
                sum = sum - arr[l]%2;
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
    public static int countNumberOfNiceSubarrays(int[] arr, int k){
        //? for odd => 1
        //? for even => 0

        //? Now, problem becomes binary subarrays with sum

        return binarySubarraysWithSum(arr, k);
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
        int k = sc.nextInt();
        sc.close();

        //* Brute --> Better --> Optimal 

        //* Optimal : 
        int cnt = countNumberOfNiceSubarrays(arr, k);
        System.out.println(cnt);
        //? Time Complexity : O(2 * 2N) + O(N)
        //? Space Complexity : O(1)
    }    
}
