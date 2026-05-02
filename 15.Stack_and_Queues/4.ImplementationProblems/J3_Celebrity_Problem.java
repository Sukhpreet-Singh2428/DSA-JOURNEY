//* Celebrity Problem
//! (Hard Problem)

//? Celebrity --> Everyone know him, but he knows no one
//? Celebrity --> min = 0 , max = 1 . No matrix can have more than 1 celebrity, not possible

import java.util.Scanner;
import java.util.Stack;

public class J3_Celebrity_Problem {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int celebrityProblem(int[][] arr){
        int n = arr.length;

        int[] knowMe = new int[n];
        int[] iKnow = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(knowMe[i]==n-1 && iKnow[i]==0){
                return i;
            }
        }
        return -1;
    }
    //? Time Complexity : O(N*N) + O(N) => O(N^2) + O(N)
    //? Space Complexity : O(2N)


    //* Optimal : 
    public static int CelebrityProblem(int[][] arr){
        int n = arr.length;

        int top = 0;
        int down = n-1;
        while(top<down){
            if(arr[top][down]==1){
                top = top+1;
            }
            else if(arr[down][top]==1){
                down = down-1;
            }
            else{
                top++;
                down--;
            }
        }

        if(top>down) return -1;

        //? top == down
        for(int i=0; i<n; i++){
            if(i==top) continue;
            if(arr[top][i] == 0 && arr[i][top]==1){
                continue;
            }
            else{
                return -1;
            }
        }

        return top;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(1)


    //* Optimal : 
    //? Stack based solution 
    public static int celebrityStack(int[][] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        //? Step 1: Push all people
        for(int i = 0; i < n; i++){
            st.push(i);
        }

        //? Step 2: Eliminate
        while(st.size() > 1){
            int a = st.pop();
            int b = st.pop();

            if(arr[a][b] == 1){
                //? a knows b → a not celebrity
                st.push(b);
            } else {
                //? a doesn't know b → b not celebrity
                st.push(a);
            }
        }

        int candidate = st.pop();

        //? Step 3: Verify
        for(int i = 0; i < n; i++){
            if(i == candidate) continue;

            if(arr[candidate][i] == 1 || arr[i][candidate] == 0){
                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();


        //* Brute : 
        // int ans = celebrityProblem(arr);
        // System.out.println(ans);
        //? Time Complexity : O(N*N) + O(N) => O(N^2) + O(N)
        //? Space Complexity : O(2N)

        //* Optimal : 
        int ans = CelebrityProblem(arr);
        System.out.println(ans);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(1)

        //* Optimal : 
        //? Stack based solution 
        int res = celebrityStack(arr);
        System.out.println(res);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(N)
    }
}
