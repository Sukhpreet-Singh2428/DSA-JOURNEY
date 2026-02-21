//* Single Number - I
//! (Medium Problem)

//? Given an array of nums of n integers. Every integer in the array 
//? appears twice except one integer. Find the number that appeared once in the array.
//? Example 1
//? Input : nums = [1, 2, 2, 4, 3, 1, 4]
//? Output : 3
//* Explanation : The integer 3 has appeared only once.
//? Example 2
//? Input : nums = [5]
//? Output : 5
//* Explanation : The integer 5 has appeared only once.

//? -10^9 < nums[i] < 10^9

import java.util.HashMap;
import java.util.Scanner;
public class J2_SingleNumber_I {
    //* Brute : 
    public static int singleNumber(int[] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);
        }

        for(int key : mp.keySet()){
            if(mp.get(key)==1){
                return key;
            }
        }

        return -1;
    }
    //? Time Complexity : O(N + M) [where M, is the size of the map]
    //? Space Complexity : O(M)

    //* Optimal : 
    public static int single_Number(int[] arr){
        int xor = 0;
        for(int i : arr){
            xor = xor ^ i;
        }

        return xor;
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
        sc.close();

        //* Brute : (HashMap)
        // System.out.println(singleNumber(arr));
        //? Time Complexity : O(N + M) [where M, is the size of the map]
        //? Space Complexity : O(M)

        //* Optimal : (Bit Manipulation)
        System.out.println(single_Number(arr));
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
        //! if numbers are negative, the XOR solution is still optimal.
        //! XOR solution only breaks when number appear 3 times or two numbers appear once
    }
}
