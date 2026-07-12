//* Fruit Into Baskets
//! (Medium Problem)

//? Fruit Into Baskets => max Length subarray with at most 2 types of numbers.

//?  arr = [3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4]

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class J4_Fruit_Into_Baskets {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int fruitIntoBaskets(int[] arr){
        int n = arr.length;

        int maxLen = 0;

        for(int i=0; i<n; i++){
            HashSet<Integer> st = new HashSet<>();

            for(int j=i; j<n; j++){
                st.add(arr[j]);
                if(st.size() <= 2){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }

            }
        }

        return maxLen;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(3)


    //* Better : 
    //! (Sliding window and two pointers)
    public static int fruit_IntoBaskets(int[] arr){
        int n = arr.length;

        HashMap<Integer, Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLen = 0;

        while(r < n){
            mp.put(arr[r], mp.getOrDefault(arr[r], 0)+1);

            if(mp.size() > 2){
                while(mp.size() > 2){
                    mp.put(arr[l], mp.get(arr[l])-1);

                    if(mp.get(arr[l]) == 0){
                        mp.remove(arr[l]);
                    }

                    l++;
                }
            }

            if(mp.size() <= 2){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(3)


    //* Optimal : 
    //! (Sliding window and two pointers)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();


        //* Brute --> Better --> Optimal 

        //* Brute : 
        // int ans = fruitIntoBaskets(arr);
        // System.out.println(ans);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(3)

        //* Better : 
        //! (Sliding window and two pointers)
        // int ans = fruit_IntoBaskets(arr);
        // System.out.println(ans);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(3)

        //* Optimal : 
        //! (Sliding window and two pointers)
        
    }
}
