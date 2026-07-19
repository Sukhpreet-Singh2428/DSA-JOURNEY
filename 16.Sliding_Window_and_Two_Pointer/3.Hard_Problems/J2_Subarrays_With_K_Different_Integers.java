//* Subarrays with K Different Integers
//! (Hard Problems)

//?  arr = {1, 2, 1, 3, 4}   k=3

import java.util.HashMap;
import java.util.Scanner;

public class J2_Subarrays_With_K_Different_Integers {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int subarraysWithKDifferentIntegers(int[] arr, int k){
        int n = arr.length;

        int cnt = 0;
        for(int i=0; i<n; i++){
            HashMap<Integer, Integer> mp = new HashMap<>();

            for(int j=i; j<n; j++){
                mp.put(arr[j], mp.getOrDefault(arr[j], 0)+1);
                if(mp.size() == k){
                    cnt++;
                }
                else if(mp.size() > k){ 
                    break;
                }
            }
        }

        return cnt;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static int countSubarrays_whereDifferentIntegerLessThanEqualToK(int[] arr, int k){
        if(k<0) return 0;
        int n = arr.length;

        int l = 0;
        int r = 0;
        int cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        while(r < n){
            mp.put(arr[r], mp.getOrDefault(arr[r], 0)+1);

            while(mp.size() > k){
                mp.put(arr[l], mp.get(arr[l])-1);
                
                if(mp.get(arr[l]) == 0){
                    mp.remove(arr[l]);
                }

                l++;
            }

            if(mp.size() <= k){
                cnt = cnt + r-l+1;
            }

            r++;
        }

        return cnt;
    }
    public static int subarrays_WithKDifferentIntegers(int[] arr, int k){
        return countSubarrays_whereDifferentIntegerLessThanEqualToK(arr, k) - countSubarrays_whereDifferentIntegerLessThanEqualToK(arr, k-1);
    }
    //? Time Complexity : O(2N) + O(2N)  => O(N)
    //? Space Complexity : O(N) + O(N)   => O(N)
    
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
        // int cnt = subarraysWithKDifferentIntegers(arr, k);
        // System.out.println(cnt);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N)

        //* Optimal :   
        int cnt = subarrays_WithKDifferentIntegers(arr, k);
        System.out.println(cnt);
        //? Time Complexity : O(2N) + O(2N)  => O(N)
        //? Space Complexity : O(N) + O(N)   => O(N)
    }
}
