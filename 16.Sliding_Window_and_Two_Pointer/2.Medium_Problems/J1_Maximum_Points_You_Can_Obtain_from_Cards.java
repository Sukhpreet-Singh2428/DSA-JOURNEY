//* Maximum Points you can obtain from cards
//! (Medium Problem)

//?  arr = [6, 2, 3, 4, 7, 2, 1, 7, 1]   k = 4
//*  answer : 16  (6+2+7+1) [6, 2 from beginning and 7,1 from ending]

//? Given N cards arranged in a row, each card has an associated score denoted by the cardScore array.
//? Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row.
//? The score is the sum of the scores of the chosen cards.
//? Return the maximum score that can be obtained.

import java.util.Scanner;

public class J1_Maximum_Points_You_Can_Obtain_from_Cards {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static int maxPoints(int[] arr, int k){
        int n = arr.length;

        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        for(int i=0; i<k; i++){
            lsum += arr[i];
        }
        maxSum = lsum;

        int rIdx = n-1;
        for(int i=k-1; i>=0; i--){
            lsum = lsum - arr[i];
            rsum = rsum + arr[rIdx];
            rIdx = rIdx - 1;

            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }
    //? Time Complexity : O(k) + O(k) => O(2k)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();


        //* Brute --> Better --> Optimal 

        //* Optimal : 
        int sum = maxPoints(arr, k);
        System.out.println(sum);
        //? Time Complexity : O(k) + O(k) => O(2k)
        //? Space Complexity : O(1)
    }
}
