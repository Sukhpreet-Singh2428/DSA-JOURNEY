//* Lemonade Change
//! (Easy Problem)

//? Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders, following the billing order. 
//? Every consumer will purchase a single lemonade and may pay with a $5, $10, or $20 bill. Each customer must receive the 
//? appropriate change so that the net transaction is $5. Initially, there is no change available.
//? Determine if it is possible to provide the correct change to every customer. Return true if the correct change can be given 
//? to every customer, and false otherwise.
//? Given an integer array bills, where bills[i] is the bill the ith customer pays, return true if the correct 
//? change can be given to every customer, and false otherwise.
//? Example 1
//? Input : bills = [5, 5, 10, 5, 20]
//? Output : true
//* Explanation : Initially we have $0 available for change.
//* From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.
//* From the third customer , we collect bill of $10 and give back $5. After third customer we have one $5 and one $10 bill available with us for change.
//* From fourth customer , we collect $5 bill. After fourth customer we have two $5 and one $10 bills available with us for change if required.
//* From fifth customer , we collect bill of $20 and give back $15 (one $10 + one $5 bill).
//* Since all the customers did receive the change correctly , so we return true.


import java.util.Scanner;

public class J2_Lemonade_Change {
    
    //* Brute --> Better --> Optimal 

    //* Optimal : 
    public static boolean lemonadeChange(int[] bills){
        int five = 0;
        int ten = 0;

        for(int i=0; i<bills.length; i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }
                else return false;
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five -= 3;
                }
                else return false;
            }
        }

        return true;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bills = new int[n];
        for(int i=0; i<n; i++){
            bills[i] = sc.nextInt();
        }
        sc.close();

        //* Brute --> Better --> Optimal

        //* Optimal : 
        boolean ans = lemonadeChange(bills);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)
    }
}
