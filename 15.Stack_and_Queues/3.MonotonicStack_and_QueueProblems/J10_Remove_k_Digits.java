//* Remove k Digits
//! (Medium Problem)

//? num = "1432219"  k = 3

//* Intuition :
//* Keep smaller digits at the start
//* but rid of the larger ones --> k larger

import java.util.Scanner;
import java.util.Stack;

public class J10_Remove_k_Digits {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static String removekDigits(String num, int k){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<num.length(); i++){
            while(!st.isEmpty() && k>0 && st.peek()-'0' > num.charAt(i)-'0'){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        ans.reverse();
        int j = 0;
        while(j<ans.length() && ans.charAt(j)=='0'){
            j++;
        }
        if(j==ans.length()) return "0";

        return ans.substring(j).toString();
    }
    //? Time Complexity : O(N + K)
    //? Space Complexity : O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
        sc.close();

        String ans = removekDigits(num, k);
        System.out.println(ans);
        //? Time Complexity : O(N + K)
        //? Space Complexity : O(N)

    }
}
