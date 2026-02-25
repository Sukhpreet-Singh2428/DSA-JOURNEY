//* Single Number - III
//! (Medium Problem)

//? Given an array nums of length n, every integer in the array appears twice except for two integers. 
//? Identify and return the two integers that appear only once in the array. 
//? Return the two numbers in ascending order.
//? For example, if nums = [1, 2, 1, 3, 5, 2], the correct answer is [3, 5], not [5, 3].
//? Example 1
//? Input : nums = [1, 2, 1, 3, 5, 2]
//? Output : [3, 5]
//* Explanation : The integers 3 and 5 have appeared only once.
//? Example 2
//? Input : nums = [-1, 0]
//? Output : [-1, 0]
//* Explanation : The integers -1 and 0 have appeared only once.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class J5_SingleNumber_III {

    //* Brute : 
    public static int[] single_NumberIII(int[] nums){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }

        int[] ans = new int[2];
        int i=0;
        for(int key : mp.keySet()){
            if(mp.get(key) == 1){
                if(i==2) break;
                ans[i] = key;
                i++;
            }
        } 

        Arrays.sort(ans);
        return ans;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)


    //* Optimal : 
    //! Concept of Buckets
    public static int[] Single_NumberIII(int[] nums){
        int n = nums.length;

        long XOR_all = 0;
        for(int i=0; i<n; i++){
            XOR_all = XOR_all ^ nums[i];
        }

        int rightmost = (int)(XOR_all & (XOR_all-1)) ^ (int)XOR_all;

        int b1 = 0;
        int b2 = 0;
        for(int i=0; i<n; i++){
            if((nums[i] & rightmost) != 0){
                b1 = b1 ^ nums[i];
            }
            else{
                b2 = b2 ^ nums[i];
            }
        }

        if(b1<b2) return new int[]{b1, b2};
        return new int[]{b2, b1};
    }
    //? Time Complexity : O(N) + O(1) + O(N) -> O(2N)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        //* Brute :
        // int[] res = single_NumberIII(nums);
        // System.out.println(Arrays.toString(res));
        //? Time Complexity : O(N + M) [where M is the size of map]
        //? Space Complexity : O(N)

        //* Optimal : (Bit Manipulation)
        //! Concept of Buckets
        int[] res = Single_NumberIII(nums);
        System.out.println(Arrays.toString(res));
        //? Time Complexity : O(N) + O(1) + O(N) -> O(2N)
        //? Space Complexity : O(1)
        //* Intuition:
        //? An optimal approach to solve this problem will be possible 
        //? if we can divide the elements in array into two groups such that 
        //? each group only contains one unique element. This way, the problem 
        //? boils down to Single Number-I and both the unique elements can be identified with ease.
        //? Now, to divide the numbers into two groups(buckets), 
        //? the rightmost set bit in the overall XOR of all elements can be used. 
        //? The overall XOR of all elements is equivalent to the XOR of the two unique numbers.

        //* Why Divide using the Rightmost Set Bit?
        //? This is because of the following reasons:
        //? The two unique numbers needs to be separated into two different groups, 
        //? and the rightmost set bit in the overall XOR will indicate the bit position 
        //? where the the two unique numbers differ.
        //? Using this bit, all the elements in the array can be divided into two groups (buckets):
        //? One group where this bit is set.
        //? Another group where this bit is not set.
    }
}
