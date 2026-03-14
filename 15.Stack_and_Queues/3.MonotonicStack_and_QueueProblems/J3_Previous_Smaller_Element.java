//* Previous Smaller Element
//! (Medium Problem)

//? example : 
//?  arr = [4, 5, 2, 10, 8]
//?   --> [-1, 4, -1, 2, 2]

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class J3_Previous_Smaller_Element {
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int[] previousSmallerElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(arr[j]<arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        return ans;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N)


    //* Optimal : 
    public static int[] Previous_Smaller_Element(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return ans;
    }
    //? Time Complexity : O(2N)
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
        // int[] ans = previousSmallerElement(arr);
        // System.out.println(Arrays.toString(ans));
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N)

        //* Optimal : 
        int[] ans = Previous_Smaller_Element(arr);
        System.out.println(Arrays.toString(ans));
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)
    }
}
