//* Next Greater Element
//! (Medium Problem)

//? example : 
//?     arr = [6, 0, 8, 1, 3]
//?   --> [8, 8, -1, 3, -1]

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class J1_Next_Greater_Element {
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j]>arr[i]){
                    ans[i] = arr[j];
                    break;
                }
            }
        }

        return ans;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(N) [this space is used to return the answer, not in order to solve the problem]

    
    //* Optimal : 
    public static int[] Next_Greater_Element(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            
            st.push(arr[i]);
        }

        return ans;
    }
    //? Time Complexity : O(N)
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
        // int[] ans = nextGreaterElement(arr);
        // System.out.println(Arrays.toString(ans));
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(N) [this space is used to return the answer, not in order to solve the problem]


        //* Optimal : 
        int[] ans = Next_Greater_Element(arr);
        System.out.println(Arrays.toString(ans));
        //? Time Complexity : O(N)
        //? Space Complexity : O(N) + O(N)
    }
}
