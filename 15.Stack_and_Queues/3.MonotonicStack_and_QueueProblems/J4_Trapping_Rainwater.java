//* Trapping Rainwater
//! (Medium Problem)

//? Example 1
//? Input: height= [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
//? Output: 6
//? Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

import java.util.Scanner;

public class J4_Trapping_Rainwater {
    //* Brute --> Better --> Optimal 

    //* Brute : 
    public static int[] findPrefixMax(int[] height, int n){
        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];
        
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }

        return prefixMax;
    } 
    public static int[] findSuffixMax(int[] height, int n){
        int[] suffixMax = new int[n];
        suffixMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        return suffixMax;
    }
    public static int trap(int[] height){
        int n = height.length;
        
        int total = 0;

        int[] leftMax = findPrefixMax(height, n);
        int[] rightMax = findSuffixMax(height, n);

        for(int i=0; i<n; i++){
            if(height[i] < leftMax[i] && height[i] < rightMax[i]){
                total += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }

        return total;
    }
    //? Time Complexity : O(3N)
    //? Space Complexity : O(2N)


    //* Optimal : 
    public static int findTotal(int[] height){
        int lMax = 0;
        int rMax = 0;
        int total = 0;

        int l = 0;
        int r = height.length - 1;
        while(l<r){
            if(height[l] <= height[r]){
                if(lMax > height[l]){
                    total += lMax - height[l];
                }
                else{
                    lMax = height[l];
                }
                l = l+1;
            }
            else{
                if(rMax > height[r]){
                    total += rMax - height[r];
                }
                else{
                    rMax = height[r];
                }
                r = r-1;
            }
        }

        return total;
    }
    //? Time Complexity : O(N)
    //? Space Complexity : O(1)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0; i<n; i++){
            height[i] = sc.nextInt();
        }
        sc.close();

        //* Brute : 
        // int ans = trap(height);
        // System.out.println(ans);
        //? Time Complexity : O(3N)
        //? Space Complexity : O(2N)

        //* Optimal : 
        int ans = findTotal(height);
        System.out.println(ans);
        //? Time Complexity : O(N)
        //? Space Complexity : O(1)

    }
}
