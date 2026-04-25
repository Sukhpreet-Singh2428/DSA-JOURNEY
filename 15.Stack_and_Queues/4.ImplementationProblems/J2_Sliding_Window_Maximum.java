//* Sliding Window Maximum
//! (Hard Problem)

//? nums = [1, 3, -1, -3, 5, 3, 2, 1, 6]  k = 3
//? => [3, 3, 5, 5, 5, 3, 6]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J2_Sliding_Window_Maximum {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static List<Integer> slidingWindowMaximum(int[] arr, int k){
        int n = arr.length;
        
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<n-k+1; i++){
            int maxi = arr[i];
            for(int j=i; j<i+k; j++){
                maxi = Math.max(maxi, arr[j]);
            }
            ls.add(maxi);
        }

        return ls;
    }
    //? Time Complexity : O(N-k)*k
    //? Space Complexity : O(N-K) [for storing, not in solving the problem]


    //* Optimal : 
    //? (using Monotonic stack concept)
    public static List<Integer> SlidingWindowMaximum(int[] arr, int k){
        int n = arr.length;

        List<Integer> ls = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k-1){
                ls.add(arr[dq.peekFirst()]);
            }
        }

        return ls;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(K) + O(N-K) [ O(N-K) for storing answer ]


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        //* Brute : 
        // List<Integer> ans = slidingWindowMaximum(arr, k);
        // System.out.println(ans);
        //? Time Complexity : O(N-k)*k
        //? Space Complexity : O(N-K) [for storing, not in solving the problem]

        //* Optimal : 
        List<Integer> ans = SlidingWindowMaximum(arr, k);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(K) + O(N-K) [ O(N-K) for storing answer ]

    }
}
