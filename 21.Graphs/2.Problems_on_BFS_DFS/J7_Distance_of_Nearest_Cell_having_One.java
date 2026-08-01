//* Distance of Nearest Cell having One (also known as 01-matrix)
//! (Medium Problem)

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int row;
    int col;
    int dist;

    public Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
public class J7_Distance_of_Nearest_Cell_having_One {

    public static int[][] distance_ofNearestCellHavingOne(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dist = new int[n][m]; 
        Queue<Pair> qu = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    qu.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
                else{
                    vis[i][j] = false; 
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            int row = qu.peek().row;
            int col = qu.peek().col;
            int steps = qu.peek().dist;
            qu.poll();

            dist[row][col] = steps;

            for(int i=0; i<4; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false){
                    vis[nrow][ncol] = true;
                    qu.offer(new Pair(nrow, ncol, steps+1));
                }
            }
        }

        return dist;
    }
    //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
    //? Space Complexity : O(N*M) [vis]  +  O(N*M) [queue]  + O(N*M) [dist, need to return ans]  =>  O(N*M)


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        sc.close();


        //* Optimal : 
        int[][] ans = distance_ofNearestCellHavingOne(grid);
        //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
        //? Space Complexity : O(N*M) [vis]  +  O(N*M) [queue]  + O(N*M) [dist, need to return ans]  =>  O(N*M) 

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
