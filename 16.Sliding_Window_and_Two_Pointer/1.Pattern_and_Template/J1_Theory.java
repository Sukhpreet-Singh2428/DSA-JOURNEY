//* Sliding Window and Two Pointer
//! Introduction : Pattern and Templates

//* Patterns : 
//? 1. Constant Window
//? 2. Longest subarray/substring where <condition>
//? 3. No. of subarrays where <condition>  (using pattern 2)
//? 4. Shortest/Minimum window(or length) where <condition>


import java.util.Scanner;

public class J1_Theory {

    //? 1. Constant Window
    //? eg : 
    public static int constantWindow(int[] arr, int k){
        int n = arr.length;
        
        int l = 0;
        int r = k-1;
        int sum = 0;
        int maxSum = 0;
        for(int i=l; i<=r; i++){
            sum += arr[i];
        }
        maxSum = Math.max(maxSum, sum);

        while(r < n-1){
            sum = sum - arr[l];
            l++;
            r++;
            sum = sum + arr[r];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    //? 2. Longest subarray/substring where <condition>
    //? eg:
    //* Brute --> Better --> Optimal 

    //* Brute : 
    //! (Generate all subarrays)
    public static int longestSubarrayWithSumLessThanEqualToK(int[] arr, int k){
        int n = arr.length;

        int maxLen = 0;
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum = sum + arr[j];
                if(sum <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                else if(sum > k) break;
            }
        }

        return maxLen;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(1)

    //* Better : 
    //! (Two Pointer and Sliding Window)
    public static int longestSubarray_With_SumLessThanEqualTo_K(int[] arr, int k){
        int n = arr.length;

        int l=0;
        int r=0;
        int sum = 0;
        int maxLen = 0;
        while(r < n){
            sum = sum + arr[r];
            while(sum > k){
                sum = sum - arr[l];
                l = l + 1;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen, r-l+1);  //? if they ask to return the subarray, then here instead to storing maxLen, we can store the l and r
            }
            r = r + 1;
        }

        return maxLen;
    }
    //? Time Complexity : O(N + N) => O(2N)
    //? Space Complexity : O(1)

    //* Optimal : 
    //! (Two pointer and Sliding Window)
    //? Optimizing the better appraoch
    //? Only work when needed the length only, not subarray
    public static int longest_Subarray_WithSumLessThanEqual_to_k(int[] arr, int k){
        int n = arr.length;

        int l=0;
        int r=0;
        int sum = 0;
        int maxLen = 0;
        while(r < n){
            sum = sum + arr[r];
            if(sum > k){   //? we change while to if for optimization purpose, as we don't need to keep on shrinking it vaild possible sum <= k, we can just shrink it to by 1 whenever condition failed as we need to find the Maximum length so why do we go for len even less than current(till now) maxLen. so that's why replace while with if to shrink it only by 1 and NOTE this will only work for Length as we not able to find the exact subarray with this one
                sum = sum - arr[l];
                l = l + 1;
            }
            if(sum <= k){
                maxLen = Math.max(maxLen, r-l+1); 
            }
            r = r + 1;
        }

        return maxLen;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }


        //? 1. Constant Window
        //? eg: 
        //*  arr = [-1, 2, 3, 3, 4, 5, -1]   k = 4
        //*  For this particular array, need to tell the maximum possible
        //*  sum of any k consecutive elements from the given array
        // int k = sc.nextInt();
        // int sum = constantWindow(arr, k);
        // System.out.println(sum);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)


        //? 2. Longest subarray/substring where <condition>
        //? eg: 
        //*  Longest subarray with sum <= k
        //*  arr = [2, 5, 1, 7, 10]   k = 14
        // int k = sc.nextInt();

        //* Brute --> Better --> Optimal 

        //* Brute : 
        //! (Generate all subarrays)
        // int len = longestSubarrayWithSumLessThanEqualToK(arr, k);
        // System.out.println(len);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)

        //* Better : 
        //! (Two pointer and Sliding Window)
        // int len = longestSubarray_With_SumLessThanEqualTo_K(arr, k);
        // System.out.println(len);
        //? Time Complexity : O(N + N) => O(2N)
        //? Space Complexity : O(1)

        //* Optimal : 
        //! (Two pointer and Sliding Window)
        //? Optimizing the better appraoch
        //? Only work when needed the length only, not subarray
        // int len = longest_Subarray_WithSumLessThanEqual_to_k(arr, k);
        // System.out.println(len);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)


        //? 3. Number of Subarrays with sum = k  (using pattern - 2)
        //* So for this problem, we need to tell No. of subarrays with sum = k
        //* So whenever we asked to find no. of subarrays with such a constant 
        //* condition (like here sum = k, this is an pretty much constant condititon)
        //* it's hard to tell, when we expand or shrink the window
        //* so for these type of problems, we do : 

        //! x = no. of subarrays whose sum <= k
        //! y = no. of subarrays whose sum <= k-1
        //* No. of subarrays with sum equals to k = x - y 
        //! No. of subarrays with sum equals to k = (no. of subarrays whose sum <= k) - ( no. of subarrays whose sum <= k-1)


        //? 4. Shortest/Minimum window(or length) where <condition>
        //* It is pretty much identical 
        //* key idea is : 
        //* when we get an vaild window, we try to shrink the window in order to get
        //* shortest or minimum possible valid window and then store it and similarly 
        //* try for other vaild window's and shrink it till possible and maintain an 
        //* variable for shortest length/window 

        sc.close();
    }
}
