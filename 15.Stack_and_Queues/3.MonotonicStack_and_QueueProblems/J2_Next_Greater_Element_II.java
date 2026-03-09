//* Next Greater Element - II
//! (Medium Problem)

//? Given a circular integer array arr, return the next greater element for every element in arr.
//? example : 
//? Input  :  arr = [2, 10, 12, 1, 11]
//? Output :  --> [10, 12, -1, 11, 12] 

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class J2_Next_Greater_Element_II {
    //* Brute --> Better --> Optimal

    //* Brute : 
    public static int[] nextGreaterElement2(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0; i<n; i++){
            for(int j=i+1; j<i+n; j++){
                int idx = j%n;
                if(arr[idx]>arr[i]){
                    ans[i] = arr[idx];
                    break;
                }
            }
        }

        return ans;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static int[] Next_Greater_Element_2(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=arr[i%n]){
                st.pop();
            }

            if(i<n){
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(arr[i%n]);
        }

        return ans;
    }
    //? Time Complexity : O(2N) + O(2N)
    //? Space Complexity : O(N) + O(N)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();


        //* Brute : 
        // int[] ans = nextGreaterElement2(arr);
        // System.out.println(Arrays.toString(ans));
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N)


        //* Optimal : 
        int[] ans = Next_Greater_Element_2(arr);
        System.out.println(Arrays.toString(ans));
        //? Time Complexity : O(2N) + O(2N)
        //? Space Complexity : O(N) + O(N)
    }
}
