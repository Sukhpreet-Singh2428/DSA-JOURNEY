//* Longest Substring with at most k distinct characters
//! (Hard Problem)

//?  s = "aaabbccd"   k=2

import java.util.HashMap;
import java.util.Scanner;

public class J1_Longest_Substring_With_At_Most_k_Distinct_Characters {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int longestSubstringWithAtMostKDistinctCharacters(String s, int k){
        int n = s.length();

        int maxLen = 0;
        for(int i=0; i<n; i++){
            HashMap<Character, Integer> mp = new HashMap<>();
            for(int j=i; j<n; j++){
                char c = s.charAt(j);
                mp.put(c, mp.getOrDefault(c, 0)+1);
                if(mp.size() <= k){
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
    //? Space Complexity : O(256)


    //* Better : 
    public static int longestSubstring_withAtMost_kDistinctCharacters(String s, int k){
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(r < n){
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0)+1);

            while(mp.size() > k){
                char left = s.charAt(l);
                mp.put(left, mp.get(left)-1);

                if(mp.get(left) == 0){
                    mp.remove(left);
                }

                l++;
            }

            if(mp.size() <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O(2N)
    //? Space Complexity : O(256)


    //* Optimal : 
    public static int LongestSubstring_WithAtMostK_DistinctCharacters(String s, int k){
        int n = s.length();

        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(r < n){
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0)+1);

            if(mp.size() > k){
                char left = s.charAt(l);
                mp.put(left, mp.get(left)-1);

                if(mp.get(left) == 0){
                    mp.remove(left);
                }

                l++;
            }

            if(mp.size() <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }

            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(256)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();


        //* Brute --> Better --> Optimal 

        //* Brute : 
        // int len = longestSubstringWithAtMostKDistinctCharacters(s, k);
        // System.out.println(len);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(256)

        //* Better : 
        // int len = longestSubstring_withAtMost_kDistinctCharacters(s, k);
        // System.out.println(len);
        //? Time Complexity : O(2N)
        //? Space Complexity : O(256)
        
        //* Optimal : 
        int len = LongestSubstring_WithAtMostK_DistinctCharacters(s, k);
        System.out.println(len);
        //? Time Complexity : O(N)
        //? Space Complexity : O(256)
    }
}
