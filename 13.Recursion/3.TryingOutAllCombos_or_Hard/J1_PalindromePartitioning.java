//* Palindrome Partitioning
//! (Hard Problem)

//? Given a string s partition string s such that every substring of partition is palindrome. Return all possible palindrome partition of string s.
//? Example 1
//? Input : s = "aabaa"
//? Output : [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]
//* Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.
//? Example 2
//? Input : s = "baa"
//? Output : [ [ "b", "a", "a"] , [ "b", "aa" ] ]
//* Explanation : Above all are the possible ways in which the string can be partitioned so that each substring is a palindrome.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J1_PalindromePartitioning {
    public static void palindromePartitioning(int idx, List<List<String>> ans, List<String> ls, String s, int n){
        if(idx == n){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int j=idx; j<n; j++){
            if(check(s, idx, j)){
                String SubString = s.substring(idx, j+1);
                ls.add(SubString);
                palindromePartitioning(j+1, ans, ls, s, n);
                ls.remove(ls.size()-1);
            }
        }
    }
    public static boolean check(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    //? Time Complexity : exponential nature [recursion calls depends on length of String]
    //? Space Complexity : O(N)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        //* Optimal : 
        List<List<String>> ans = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        palindromePartitioning(0, ans, ls, s, s.length());
        System.out.println(ans);
        //? Time Complexity: O(N × 2N), where N is the length of string given.
        //?      This is because we generate all possible partitions (exponential) 
        //?      and each palindrome check can take up to O(N).
        //? Space Complexity: O(N), because the auxiliary space used (recursion stack + path) is O(N).
    }
}
