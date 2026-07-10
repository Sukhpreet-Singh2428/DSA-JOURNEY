//* Longest Substring without Repeating Characters
//! (Medium Problem)

//? example :  s = "cadbzabcd"
//?          => output : 5

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class J2_Longest_Substring_Without_Repeating_Characters {

    //* Brute --> Better --> Optimal

    //* Brute : 
    public static int longestSubstring_withoutRepeatingCharacters(String s){
        int n = s.length();

        int maxLen = 0;

        for(int i=0; i<n; i++){
            HashSet<Character> st = new HashSet<>();
            String sub = "";
            for(int j=i; j<n; j++){
                char c = s.charAt(j);
                if(st.contains(c)){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len-1);  //? len-1 => bcz, here len is the length of substring where is getting first duplicate char and we don't want that... so we break out and store the maxLen as Math.max(maxLen, len-1)
                    break;
                }
                sub = sub + c;
                st.add(c);
            }
        }

        return maxLen;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(256)  //? Character hash as at max. 256


    //* Optimal : 
    public static int longest_substring_withoutRepeatingCharacters(String s){
        int n = s.length();

        HashMap<Character, Integer> mp = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        while(r < n){
            char c = s.charAt(r);

            if(mp.containsKey(c)){
                if(mp.get(c) >= l){
                    l = mp.get(c) + 1;
                }
            }

            int len = r-l+1;
            maxLen = Math.max(maxLen, len);

            mp.put(c, r);
            r++;
        }

        return maxLen;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(256)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        //* Brute --> Better --> Optimal

        //* Brute : 
        // int len = longestSubstring_withoutRepeatingCharacters(s);
        // System.out.println(len);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(256)  //? Character hash as at max. 256

        //* Optimal : 
        int len = longest_substring_withoutRepeatingCharacters(s);
        System.out.println(len);
        //? Time Complexity : O(N)
        //? Space Complexity : O(256)
    }
}
