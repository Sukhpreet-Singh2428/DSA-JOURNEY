//* Jump Game - II
//! (Medium Problem)

import java.util.Scanner;

public class J2_Jump_Game_II {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    //? (recursion)
    public static int jumpGame2(int idx, int jumps, int[] arr){
        if(idx >= arr.length-1){
            return jumps;
        }

        int mini = Integer.MAX_VALUE;

        for(int i=1; i<=arr[idx]; i++){
            mini = Math.min(mini, jumpGame2(idx+i, jumps+1, arr));
        }

        return mini;
    }
    //? Time Complexity : O(N^N) exponential in nature
    //? Space Complexity : O(N) [Recursive Stack Space]


    //* Better : 
    //? (Dynamic Programming)
    //* ==> we will do this one, when we covered dp topic
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N^2)


    //* Optimal : 
    //? (Greedy)
    public static int jumpGame_II(int[] arr){
        int n = arr.length;

        int jumps = 0;
        int l = 0;
        int r = 0;

        while(r < n-1){
            int farthest = 0;
            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, i + arr[i]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jump = new int[n];
        for(int i=0; i<n; i++){
            jump[i] = sc.nextInt();
        }
        sc.close();

        //* Brute --> Better --> Optimal : 

        //* Brute : 
        //? (Recursion)
        // int ans = jumpGame2(0, 0, jump);
        // System.out.println(ans);
        //? Time Complexity : O(N^N) exponential in nature
        //? Space Complexity : O(N) [Recursive Stack Space]

        //* Better : 
        //? (Dynamic Programming)
        //* ==> we will do this one, when we covered dp topic
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N^2)

        //* Optimal : 
        //? (Greedy)
        int ans = jumpGame_II(jump);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
