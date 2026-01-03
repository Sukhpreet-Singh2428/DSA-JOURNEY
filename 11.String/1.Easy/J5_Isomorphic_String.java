//* Isomorphic String
//! (Easy Problem)

//? Given two strings s and t, determine if they are isomorphic. 
//? Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//? All occurrences of a character must be replaced with another character while preserving the order of characters. 
//? No two characters may map to the same character, but a character may map to itself.

//? Example 1
//? Input : s = "egg" , t = "add"
//? Output : true
//* Explanation :
//* The 'e' in string s can be replaced with 'a' of string t.
//* The 'g' in string s can be replaced with 'd' of t.
//* Hence all characters in s can be replaced to get t.

//? Example 2
//? Input : s = "apple" , t = "bbnbm"
//? Output : false
//* Explanation :
//* It can be proved that no solution exists for this example.
//* All the "b"s in t have to take places of "a", "p", "l", which requires "p" to be mapped to "b", but that makes it impossible for "p" at index 2 (0-indexed) to become "n". Thus no solution exists.

import java.util.Scanner;
public class J5_Isomorphic_String {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static Boolean isomorphicString(String s, String t){
        
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        int n = s.length();   //? Given in ques, both string has same length

        for(int i=0; i<n; i++){
            if(sMap[s.charAt(i)] != tMap[t.charAt(i)]){
                return false;
            }

            sMap[s.charAt(i)] = i+1;
            tMap[t.charAt(i)] = i+1;
        }

        return true;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(2*256)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();
        
        //* Optimal : 
        Boolean ans = isomorphicString(s, t);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(2*256)
    }
}
