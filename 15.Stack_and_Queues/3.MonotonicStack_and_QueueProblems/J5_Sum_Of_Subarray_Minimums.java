//* Sum of Subarray Minimums
//! (Medium Problem)

//? example:
//? arr = [3, 1, 2, 4]
//? subarrays : [3], [3, 1], [3, 1, 2], [3, 1, 2, 4]
//?             [1], [1, 2], [1, 2, 4]
//?             [2], [2, 4]
//?             [4]
//?  Minimums : 3, 1, 1, 1
//?             1, 1, 1
//?             2, 2
//?             4
//?  Sum = 3+1+1+1+1+1+1+2+2+4 = 17
//?  If Sum goes to big then use mod = 10^9 + 7

import java.util.Scanner;
import java.util.Stack;
public class J5_Sum_Of_Subarray_Minimums {

    //* Brute --> Better --> Optimal

    //* Brute : 
    public static int sum_of_subarray_minimums(int[] arr){
        int mod = (int)(1e9 + 7);

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            int mini = arr[i];
            for(int j=i; j<arr.length; j++){
                mini = Math.min(mini, arr[j]);
                sum += mini % mod;
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
        int[] psee = new int[n];   //? previous smallest or equal element
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return psee;
    }
    public static int Sum_of_Subarray_Minimums(int[] arr){
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        int sum = 0;
        int mod = (int)(1e9 + 7);

        for(int i=0; i<arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            sum = ( sum + (right*left*arr[i])%mod )%mod;
        }

        return sum;
    }
    //? Time Complexity : O(2N) + O(2N) + O(N) => O(5N)
    //? Space Complexity : O(4N)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        //* Brute : 
        // int sum = sum_of_subarray_minimums(arr);
        // System.out.println(sum);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)

        //* Optimal : 
        int sum = Sum_of_Subarray_Minimums(arr);
        System.out.println(sum);
        //? Time Complexity : O(2N) + O(2N) + O(N) => O(5N)
        //? Space Complexity : O(4N)
        
    }
}
