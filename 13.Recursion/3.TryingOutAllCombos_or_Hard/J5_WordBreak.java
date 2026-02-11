//* Word Break
//! (Medium Problem)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class J5_WordBreak {
    //* Recursive Solution (Brute)
    public static boolean helper(int start, int end, String s, Set<String> st){
        if(s.length()-1 == end){
            if(st.contains(s.substring(start, end+1))){
                return true;
            }
            return false;
        }

        if(st.contains(s.substring(start, end+1))){
            if(helper(end+1, end+1, s, st)){
                return true;
            }
        }

        return helper(start, end+1, s, st);

    }
    public static boolean wordBreak(String s, String[] wordDict){
        Set<String> st = new HashSet<>(Arrays.asList(wordDict));
        return helper(0, 0, s, st);
    }


    //* Recursion + DP (Optimal)
    public static boolean Helper(int start, int end, String s, Set<String> st, int[][] dp){
        if(dp[start][end] != -1){
            return dp[start][end] == 1 ? true : false;
        }
        if(s.length()-1 == end){
            if(st.contains(s.substring(start, end+1))){
                return true;
            }
        }

        if(st.contains(s.substring(start, end+1))){
            if(Helper(end+1, end+1, s, st, dp)){
                dp[start][end] = 1;
                return true;
            }
        }

        dp[start][end] = Helper(start, end+1, s, st, dp) ? 1 : 0;
        return dp[start][end] == 1 ? true : false;
    }
    public static boolean Word_Break(String s, String[] wordDict){
        int dp[][] = new int[s.length()][s.length()];
        for(int[] x : dp){
            Arrays.fill(x, -1);
        }
        
        Set<String> st = new HashSet<>(Arrays.asList(wordDict));

        return Helper(0, 0, s, st, dp);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        String[] wordDict = new String[n];
        for(int i=0; i<n; i++){
            wordDict[i] = sc.next();
        } 
        sc.close();

        //* Brute : (Recursion)
        System.out.println(wordBreak(s, wordDict));

        //* Optimal : (Recursion + DP)
        System.out.println(Word_Break(s, wordDict));
    }
}
