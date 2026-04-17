//* Sum of Subarray Ranges
//! (Medium Problem)

//? subarray range = largest - smallest
//? arr = [1, 4, 3, 2]
//? [1]  -> 0
//? [1, 4] -> 3
//? [1, 4, 3] -> 3
//? [1, 4, 3, 2] -> 3
//? [4] -> 0
//? [4, 3] -> 1
//? [4, 3, 2] -> 2
//? [3] -> 0
//? [3, 2] -> 1
//? [2] -> 0
//? => 0+3+3+3+0+1+2+0+1+0
//? => 13

import java.util.Scanner;
import java.util.Stack;

public class J6_Sum_Of_Subarray_Ranges {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int sumOfSubarrayRanges(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            int largest = arr[i];
            int smallest = arr[i];
            for(int j=i; j<n; j++){
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);

                sum = sum + (largest - smallest);
            }
        }

        return sum;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(1)


    //* Optimal : 
    public static int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }
    public static int[] findPSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }
    public static int sumOfSubarrayMinimums(int[] arr){
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        int sum = 0;
        for(int i=0; i<n; i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            sum = sum + (left*right*arr[i]);
        }

        return sum;
    }
    public static int[] findNGE(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }
    public static int[] findPGE(int[] arr){
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pge;
    }
    public static int sumOfSubarrayMaximums(int[] arr){
        int n = arr.length; 
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);

        int sum = 0;
        for(int i=0; i<n; i++){
            int left = i-pge[i];
            int right = nge[i]-i;
            sum = sum + (left*right*arr[i]);  //? this may give large values, so for that we can use mod or long depends on the problem
        }

        return sum;
    }
    public static int Sum_Of_SubarrayRanges(int[] arr){
        return sumOfSubarrayMaximums(arr) - sumOfSubarrayMinimums(arr);
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();


        //* Brute : 
        // int ans = sumOfSubarrayRanges(arr);
        // System.out.println(ans);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)


        //* Optimal : 
        int ans = Sum_Of_SubarrayRanges(arr);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(N)
    }
}
