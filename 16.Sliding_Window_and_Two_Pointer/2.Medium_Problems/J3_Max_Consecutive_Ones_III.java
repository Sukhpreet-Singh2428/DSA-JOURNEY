//* Max Consecutive Ones - III
//! (Medium Problem)

//? Max Consecutive Ones III --> Longest subarray with at most k zero's

import java.util.Scanner;

public class J3_Max_Consecutive_Ones_III {

    //* Brute --> Better --> Optimal

    //* Brute : 
    public static int maxConsecutiveIII(int[] arr, int k){
        int n = arr.length;

        int maxLen = 0;

        for(int i=0; i<n; i++){
            int zeros = 0;
            for(int j=i; j<n; j++){
                if(arr[j] == 0){
                    zeros++;
                }
                if(zeros <= k){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                }
                else{
                    break;
                }
            }
        }

        return maxLen;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(1)


    //* Better : 
    //! (Sliding window and Two pointers)
    public static int max_consecutiveIII(int[] arr, int k){
        int n = arr.length;

        int maxLen = 0;
        int l = 0;
        int r = 0;
        int zeros = 0;

        while(r < n){
            if(arr[r] == 0){
                zeros++;
            }

            while(zeros > k){
                if(arr[l] == 0) zeros--;
                l++;
            }

            if(zeros <= k){
                int len = r-l+1;
                maxLen = Math.max(maxLen, len);
            }

            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O(N) + O(N) = O(2N)
    //? Space Complexity : O(1)


    //* Optimal :
    //! (Sliding Window and Two pointers)
    public static int Max_ConsecutiveOnes_III(int[] arr, int k){
        int n = arr.length;

        int l = 0;
        int r = 0;
        int zeros = 0;
        int maxLen = 0;

        while(r < n){
            if(arr[r] == 0){
                zeros++;
            }

            if(zeros > k){
                if(arr[l] == 0){
                    zeros--;
                }
                l++;
            }

            if(zeros <= k){
                int len = r-l+1;
                maxLen = Math.max(maxLen, len);
            }

            r++;
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
        int k = sc.nextInt();
        sc.close();

        //* Brute --> Better --> Optimal

        //* Brute : 
        // int len = maxConsecutiveIII(arr, k);
        // System.out.println(len);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)

        //* Better : 
        //! (Sliding window and Two pointers)
        // int len = max_consecutiveIII(arr, k);
        // System.out.println(len);
        //? Time Complexity : O(N) + O(N) = O(2N)
        //? Space Complexity : O(1)

        //* Optimal : 
        //! (Sliding window and Two pointers)
        int len = Max_ConsecutiveOnes_III(arr, k);
        System.out.println(len);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)

    }
}
