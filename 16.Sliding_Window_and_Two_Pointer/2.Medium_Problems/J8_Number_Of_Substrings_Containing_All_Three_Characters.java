//* Number of Substrings Containing All Three Characters
//! (Hard Problem)

//?  s = bbacba

import java.util.Scanner;

public class J8_Number_Of_Substrings_Containing_All_Three_Characters {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int no_OfSubstringsContainingAllThreeCharacters(String s){
        int n = s.length();

        int cnt = 0;

        for(int i=0; i<n; i++){
            int[] hash = new int[3];
            
            for(int j=i; j<n; j++){
                hash[s.charAt(j) - 'a'] = 1;
                if(hash[0] + hash[1] + hash[2] == 3){
                    cnt = cnt + 1;
                }
            }
        }

        return cnt;
    }
    //? Time Complexity : O(N^2)
    //? Space Complexity : O(1)


    //* Better : 
    public static int no_of_SubstringsContainingAll3Characters(String s){
        int n = s.length();

        int cnt = 0;

        for(int i=0; i<n; i++){
            int[] hash = new int[3];

            for(int j=i; j<n; j++){
                hash[s.charAt(j) - 'a'] = 1;
                if(hash[0] + hash[1] + hash[2] == 3){
                    cnt = cnt + (n-j);
                    break;
                }
            }
        }

        return cnt;
    }
    //? Time Complexity : Better and Little optimized than Brute force
    //?                   still in worst case, time complexity remains 
    //?                   => O(N^2), little optimize version of brute force
    //? Space Complexity : O(1)


    //* Optimal : 
    //? (with every character, there is a substring that ends)
    public static int no_of_substringsContaining_allThreeCharacters(String s){
        int n = s.length();

        int[] lastSeen = {-1, -1, -1};
        int cnt = 0;

        for(int i=0; i<n; i++){
            lastSeen[s.charAt(i) - 'a'] = i;

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                cnt = cnt + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }

        }

        return cnt;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    //* Optimal : 
    //! (Another optimal Solution by myself)
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int cnt = 0;

        int[] freq = new int[3];

        int l = 0;
        int r = 0;

        while(r < n){
            char c = s.charAt(r);

            if(c=='a' || c=='b' || c=='c'){
                freq[c-'a']++;
            }

            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                cnt += n-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }

            r++;
        }

        return cnt;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        //* Brute --> Better --> Optimal 

        //* Brute : 
        // int cnt = no_OfSubstringsContainingAllThreeCharacters(s);
        // System.out.println(cnt);
        //? Time Complexity : O(N^2)
        //? Space Complexity : O(1)

        //* Better : 
        // int cnt = no_of_SubstringsContainingAll3Characters(s);
        // System.out.println(cnt);
        //? Time Complexity : Better and Little optimized than Brute force
        //?                   still in worst case, time complexity remains 
        //?                   => O(N^2), little optimize version of brute force
        //? Space Complexity : O(1)

        //* Optimal : 
        int cnt = no_of_substringsContaining_allThreeCharacters(s);
        System.out.println(cnt);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)

    }
}
