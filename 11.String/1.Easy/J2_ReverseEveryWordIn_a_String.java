//* Reverse every word in a String
//! (Easy Problem)

//? Given an input string, containing upper-case and lower-case letters, digits, and spaces( ' ' ). 
//? A word is defined as a sequence of non-space characters. The words in s are separated by at least one space.

//? Example 1
//? Input: s = "welcome to the jungle"
//? Output: "jungle the to welcome"
//* Explanation: The words in the input string are "welcome", "to", "the", and "jungle". 
//*              Reversing the order of these words gives "jungle", "the", "to", and "welcome". 
//*              The output string should have exactly one space between each word.

//? Example 2
//? Input: s = " amazing coding skills "
//? Output: "skills coding amazing"
//* Explanation: The input string has leading and trailing spaces, as well as multiple spaces between the words "amazing", "coding", and "skills". 
//*              After trimming the leading and trailing spaces and reducing the multiple spaces 
//*              between words to a single space, the words are "amazing", "coding", and "skills". 
//*              Reversing the order of these words gives "skills", "coding", and "amazing". 
//*              The output string should not have any leading or trailing spaces and should have exactly one space between each word.

//? Example 3
//? Input: s = "_ _ Hello _ _ _ raj _ _ vikram _ _"
//? Output: "vikram raj Hello"

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J2_ReverseEveryWordIn_a_String {

    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static String reverseEveryWordInString(String str){
        List<String> ls = new ArrayList<>();
        
        int i = 0;
        int n = str.length();
        int start = 0;
        while(i<n){
            while(i<n && str.charAt(i) == ' ') i++;

            if(i>=n) break;
            start = i;

            while(i<n && str.charAt(i) != ' ') i++;
            int end = i;

            ls.add(str.substring(start, end));
        }

        StringBuilder res = new StringBuilder();
        for(int j=ls.size()-1; j>=0; j--){
            res.append(ls.get(j));
            if(j != 0){
                res.append(" ");
            }
        }

        return res.toString();
    }
    //? Time Complexity : O(N) + O(N)[substring]
    //? Space Complexity : O(N)


    //* Optimal : 
    //! task-1 : Find out first ch != ' '
    //! task-2 : Move to the left
    //! task-3 : Reverse the word
    //! task-4 : Add a Space After the word

    public static void reverseWord(StringBuilder s, int i, int j){
        while(i < j){
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
            i++;
            j--;
        }
    }
    public static String Reverse_Everyword_in_a_String(String str){
        StringBuilder s = new StringBuilder(str);
        s.reverse();

        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        while(j<n){
            while(j<n && s.charAt(j) == ' ') j++;
            start = i;
            while(j<n && s.charAt(j) != ' '){
                s.setCharAt(i, s.charAt(j));
                i++;
                j++;
            }
            end = i-1;
            reverseWord(s, start, end);

            s.setCharAt(i, ' ');
            i++;
        }

        return s.substring(0, i);
    }
    //? Time Complexity : O(N) + O(N) + O(N)
    //? Space Complexity : O(1) [ignoring StringBuilder space, as in java String is immutuable]

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        //* Brute : 
        // String ans = reverseEveryWordInString(str);
        // System.out.println(ans);
        //? Time Complexity : O(N) + O(N)[substring]
        //? Space Complexity : O(N)

        //* Optimal : 
        String ans = Reverse_Everyword_in_a_String(str);
        System.out.println(ans);
        //? Time Complexity : O(N) + O(N) + O(N)
        //? Space Complexity : O(1) [ignoring StringBuilder space, as in java String is immutuable]
    }
}
