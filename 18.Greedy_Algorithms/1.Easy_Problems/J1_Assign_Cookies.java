//* Assign Cookies
//! (Easy Problem)

//? Consider a scenario where a teacher wants to distribute cookies to students, with each student receiving at most one cookie.
//? Given two arrays, student and cookie, the ith value in the Student array describes the minimum size of cookie 
//? that the ith student can be assigned. The jth value in the Cookie array represents the size of the jth cookie. 
//? If Cookie[j] >= Student[i], the jth cookie can be assigned to the ith student.
//? Maximize the number of students assigned with cookies and output the maximum number.
//? Example 1
//? Input : student = [1, 2, 3] , cookie = [1, 1]
//? Output :1
//* Explanation : You have 3 students and 2 cookies.
//* The minimum size of cookies required for students are 1 , 2 ,3.
//* You have 2 cookies both of size 1, So you can assign the cookie only to student having minimum cookie size 1.
//* So your answer is 1.

import java.util.Arrays;
import java.util.Scanner;

public class J1_Assign_Cookies {

    //* Brute --> Better --> Optimal

    //* Optimal : 
    public static int assignCookies(int[] greed, int[] cookies){
        int n = greed.length;
        int m = cookies.length;

        Arrays.sort(greed);
        Arrays.sort(cookies);

        int l=0;
        int r=0;
        while(l<n && r<m){
            if(greed[l] <= cookies[r]){
                l++;
            }
            r++;
        }

        return l;
    }
    //? Time Complexity : O(min(N,M)) + O(NlogN) + O(MlogM)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] greed = new int[n];
        for(int i=0; i<n; i++){
            greed[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] cookies = new int[m];
        for(int i=0; i<m; i++){
            cookies[i] = sc.nextInt();
        }

        sc.close();

        
        //* Brute --> Better --> Optimal 

        //* Optimal : 
        int ans = assignCookies(greed, cookies);
        System.out.println(ans);
        //? Time Complexity : O(M) + O(NlogN) + O(MlogM)
        //? Space Complexity : O(1)
    }
}
