//* Valid Anagram
//! (Easy Problem)

//? Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//? An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
//? typically using all the original letters exactly once.

//? Example 1
//? Input : s = "anagram" , t = "nagaram"
//? Output : true
//* Explanation :
//* We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.
//? Example 2
//? Input : s = "dog" , t = "cat"
//? Output : false
//* Explanation :
//* We cannot rearrange the characters of string s to get string t as frequency of all characters from both strings is not same.

import java.util.Arrays;
import java.util.Scanner;
public class J7_Valid_Anagram {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static Boolean validAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
    //? Time Complexity : O(NlogN)
    //? Space Complexity : O(1), but in java it will be O(N) as String are immutuble


    //* Optimal :
    public static Boolean Valid_Anagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int freq[] = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : t.toCharArray()){
            freq[c-'a']--;
        }

        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1), as there is always a constant-size array (of length 26) used to store the frequencies that does not depend on the length of the strings.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();

        //* Brute : 
        // Boolean ans = validAnagram(s, t);
        // System.out.println(ans);
        //? Time Complexity : O(NlogN)
        //? Space Complexity : O(1), but in java it will be O(N) as String are immutuble

        //* Optimal : 
        Boolean ans = Valid_Anagram(s, t);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1), as there is always a constant-size array (of length 26) used to store the frequencies that does not depend on the length of the strings.
    }
}
