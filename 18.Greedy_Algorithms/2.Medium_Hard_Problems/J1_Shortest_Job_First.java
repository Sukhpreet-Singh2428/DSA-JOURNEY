//* Shortest Job First
//! (Medium Problem)

import java.util.Arrays;
import java.util.Scanner;

public class J1_Shortest_Job_First {

    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static int SJF(int[] bt){
        int n = bt.length;
        Arrays.sort(bt);

        int waitingTime = 0;
        int time = 0;

        for(int i=0; i<n; i++){
            waitingTime += time;
            time += bt[i];
        }

        return (waitingTime/n);
    }
    //? Time Complexity : O(N) + O(NlogN)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bt = new int[n];
        for(int i=0; i<n; i++){
            bt[i] = sc.nextInt();
        }
        sc.close();

        
        //* Brute --> Better --> Optimal 

        //* Optimal : 
        int ans = SJF(bt);
        System.out.println(ans);
        //? Time Complexity : O(N) + O(NlogN)
        //? Space Complexity : O(1)
    }    
}
