//* Jump Game - I
//! (Easy Problem)

//? Given an array of integers nums, each element in the array represents the maximum jump length at that position. 
//? Initially starting at the first index of the array, determine if it is possible to reach the last index. 
//? Return true if the last index can be reached, otherwise return false.
//? Example 1
//? Input : [2, 3, 1, 1, 4]
//? Output : true
//* Explanation : We can simply take Jump of 1 step at each index to reach the last index.


import java.util.Scanner;

public class J3_Jump_Game_I {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static boolean jumpGame(int[] jump){
        int maxIdx = 0;

        for(int i=0; i<jump.length; i++){
            if(i>maxIdx) return false;
            maxIdx = Math.max(maxIdx, i+jump[i]);
        }

        return true;
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

        //* Brute --> Better --> Optimal 

        //* Optimal : 
        boolean ans = jumpGame(jump);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }    
}
