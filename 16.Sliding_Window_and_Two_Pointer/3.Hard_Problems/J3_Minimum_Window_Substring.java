//* Minimum Window Substring
//! (Hard Problem)

//?  s = "ddaaabbca"   t = "abc"

import java.util.Scanner;

public class J3_Minimum_Window_Substring {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static String minimumWindowSubstring(String s, String t){
        int n = s.length();
        int m = t.length();

        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        for(int i=0; i<n; i++){
            int[] hash = new int[256];
            for(int j=0; j<m; j++){
                hash[t.charAt(j)]++;
            }

            int cnt = 0;
            for(int j=i; j<n; j++){
                if(hash[s.charAt(j)] > 0){
                    cnt++;
                }
                hash[s.charAt(j)]--;
                if(cnt == m){
                    if(j-i+1 < minLen){
                        minLen = j-i+1;
                        startIdx = i;
                        break;
                    }
                }
            }
        }

        if(startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(256)


    //* Optimal : 
    public static String minimum_Window_Substring(String s, String t){
        int n = s.length();
        int m = t.length();

        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        int[] hash = new int[256];
        for(int i=0; i<m; i++){
            hash[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;
        int cnt = 0;
        while(r < n){
            if(hash[s.charAt(r)] > 0){
                cnt++;
            }
            hash[s.charAt(r)]--;

            while(cnt == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    startIdx = l;
                }

                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    cnt--;
                }
                l++;
            }

            r++;
        }

        if(startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
    //? Time Complexity : O(M) + O(N) + O(N)  => O(2N) + O(M)
    //? Space Complexity : O(256)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();

        //* Brute --> Better --> Optimal 

        //* Brute : 
        // String windowSub = minimumWindowSubstring(s, t);
        // System.out.println(windowSub);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(256)

        //* Optimal : 
        String windowSub = minimum_Window_Substring(s, t);
        System.out.println(windowSub);
    }
}
