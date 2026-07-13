//* Longest Repeating Character Replacement
//! (Hard Problem)

//? example :    s = "AABABBA"   k = 2

import java.util.Scanner;

public class J5_Longest_Repeating_Character_Replacement {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int longestRepeatingCharacterReplacement(String s, int k){
        int n = s.length();

        int maxLen = 0;

        for(int i=0; i<n; i++){
            int[] hash = new int[26];
            int maxf = 0;

            for(int j=i; j<n; j++){
                char c = s.charAt(j);
                hash[c-'A']++;
                maxf = Math.max(maxf, hash[c-'A']);
                int changes = (j-i+1) - maxf;
                if(changes <= k){
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
    //? Space Complexity : O(26)


    //* Better : 
    //! (Sliding Window and Two pointers)
    public static int longestRepeating_CharacterReplacement(String s, int k){
        int n = s.length();
       
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxf = 0;
        int[] hash = new int[26];

        while(r < n){
            char c = s.charAt(r);
            hash[c-'A']++;
            maxf = Math.max(maxf, hash[c-'A']);

            while( (r-l+1) - maxf > k ){
                hash[s.charAt(l)-'A']--;
                maxf = 0;
                for(int i=0; i<26; i++){
                    maxf = Math.max(maxf, hash[i]);
                }
                l++;
            }

            if( (r-l+1) - maxf <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O((N + N)*26)
    //? Space Complexity : O(26)


    //* Optimal : 
    //! (Sliding window and Two pointers)
    public static int longest_repeatingCharacter_Replacement(String s, int k){
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxf = 0;
        int[] hash = new int[26];

        while(r < n){
            hash[s.charAt(r)-'A']++;
            maxf = Math.max(maxf, hash[s.charAt(r)-'A']);

            if( (r-l+1) - maxf > k ){
                hash[s.charAt(l)-'A']--;
                l++;
            }

            if( (r-l+1) - maxf <= k ){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(26)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();

        //* Brute --> Better --> Optimal 

        //* Brute : 
        // int len = longestRepeatingCharacterReplacement(s, k);
        // System.out.println(len);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(26)

        //* Better : 
        //! (Sliding Window and Two pointers)
        // int len = longestRepeating_CharacterReplacement(s, k);
        // System.out.println(len);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(26)

        //* Optimal : 
        //! (Sliding window and Two pointers)
        int len = longest_repeatingCharacter_Replacement(s, k);
        System.out.println(len);
        //? Time Complexity : O(N)
        //? Space Complexity : O(26)
    }
}
