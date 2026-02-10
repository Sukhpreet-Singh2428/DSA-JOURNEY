//* Rat in a Maze
//! (Hard Problem)

//? Given a grid of dimensions n x n. A rat is placed at coordinates (0, 0) and wants to reach at coordinates (n-1, n-1).
//? Find all possible paths that rat can take to travel from (0, 0) to (n-1, n-1). 
//? The directions in which rat can move are 'U' (up) , 'D' (down) , 'L' (left) , 'R' (right).
//? The value 0 in grid denotes that the cell is blocked and rat cannot use that cell for travelling, 
//? whereas value 1 represents that rat can travel through the cell. If the cell (0, 0) has 0 value, then mouse cannot move to any other cell.
//! Note :
//! In a path no cell can be visited more than once.
//! If there is no possible path then return empty vector.
//? Example 1
//? Input : n = 4 , grid = [ [1, 0, 0, 0] , [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1] ]
//? Output : [ "DDRDRR" , "DRDDRR" ]
//* Explanation : The rat has two different path to reach (3, 3).
//* The first path is (0, 0) => (1, 0) => (2, 0) => (2, 1) => (3, 1) => (3, 2) => (3, 3).
//* The second path is (0,0) => (1,0) => (1,1) => (2,1) => (3,1) => (3,2) => (3,3).

//? 1 means --> you can go in that cell
//? 0 means --> you can't go on that cell
//? we can go in four directions : up, down, left, right
//? we have to go from (0, 0) --> (N-1, N-1)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J4_Rat_in_a_Maze {
    public static void func(int i, int j, String path, List<String> ans, int[][] grid, int n){
        if(i==n-1 && j==n-1){
            ans.add(path);
            return;
        }

        grid[i][j] = 0;
        //* upward : 
        if(i-1>=0 && grid[i-1][j] == 1){
            func(i-1, j, path+"U", ans, grid, n);
        }

        //* right : 
        if(j+1 < n && grid[i][j+1] == 1){
            func(i, j+1, path+"R", ans, grid, n);
        }

        //* left : 
        if(j-1 >= 0 && grid[i-1][j] == 1){
            func(i, j-1, path+"L", ans, grid, n);
        }

        //* downward : 
        if(i+1 < n && grid[i+1][j] == 1){
            func(i+1, j, path+"D", ans, grid, n);
        }

        grid[i][j] = 1;
    }
    public static void ratInMaze(int[][] grid){
        List<String> ans = new ArrayList<>();
        int n = grid.length;

        if(grid[0][0] == 0 || grid[n-1][n-1] == 0){
            System.out.println(ans);
            return;
        }

        func(0, 0, "", ans, grid, n);
        System.out.println(ans);
    }
    //? Time Complexity : O(4 ^ (N^2))
    //? Space Complexity : O(N^2)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        //* Optimal : 
        ratInMaze(grid);
        //? Time Complexity : O(4 ^ (N^2))
        //? Space Complexity : O(N^2)
    }
}
