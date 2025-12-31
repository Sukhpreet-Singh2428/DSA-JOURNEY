//* Longest Common Prefix 
//! (Easy Problem)

//? Write a function to find the longest common prefix string amongst an array of strings.
//? If there is no common prefix, return an empty string "".

//? Example 1
//? Input : str = ["flowers" , "flow" , "fly", "flight" ]
//? Output : "fl"
//* Explanation :
//* All strings given in array contains common prefix "fl".

//? Example 2
//? Input : str = ["dog" , "cat" , "animal", "monkey" ]
//? Output : ""
//* Explanation :
//* There is no common prefix among the given strings in array.

import java.util.Arrays;
import java.util.Scanner;
public class J4_Longest_Common_Prefix {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static String longestCommonPrefix(String[] arr){
        int n = arr.length;

        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[n-1];
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder("");
        while(i<first.length() && j<last.length()){
            if(first.charAt(i) != last.charAt(j)){
                break;
            }
            ans.append(first.charAt(i));
            i++;
            j++;
        }

        return ans.toString();
    }
    //? Time Complexity : O(N*M*logN) + O(M)
    //? Space Complexity : O(M)  [That to in order to return answer]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.next();
        }
        sc.close();

        //* Optimal : 
        String ans = longestCommonPrefix(arr);
        System.out.println(ans);
        //? Time Complexity : O(N*M*logN) + O(M)
        //? Space Complexity : O(M)  [That to in order to return answer]
    }
}
