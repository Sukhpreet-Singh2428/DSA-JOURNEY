//* Number of islands
//! (Medium Problem)

//! GFG Number of Islands -> 8 Directions
//! LeetCode 200 Number of Islands -> 4 Directions

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class J4_Number_of_islands {

    public static void bfs(int row, int col, boolean[][] vis, char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = true;
        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));

        int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};  //? 8 directions  {starting from Top and going clockwise}
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};  //? 8 directions  {starting from Top and going clockwise}
        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            for(int i=0; i<8; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==false){
                    qu.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
    public static int numberOfIsland(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        //* This delta row and delta col array here is for DFS, as for BFS it is in their BFS helper function
        // int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};  //? 8 directions  {starting from Top and going clockwise}
        // int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};  //? 8 directions  {starting from Top and going clockwise}
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == false && grid[i][j]=='1'){
                    cnt++;
                    bfs(i, j, vis, grid);
                    // dfs(i, j, vis, grid, drow, dcol);  //? or we can DFS as well 
                }
            }
        }
        
        return cnt;
    }
    //? Time Complexity : O(N*M) + O(N*M * 8)  => O(N*M)
    //? Space Complexity : O(N*M) [vis] + O(N*M) [queue]  => O(N*M)

    public static void dfs(int row, int col, boolean[][] vis, char[][] grid, int[] drow, int[] dcol){
        vis[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<8; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==false){
                dfs(nrow, ncol, vis, grid, drow, dcol);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }

        sc.close();


        //* Optimal : 
        int cnt = numberOfIsland(grid);
        System.out.println(cnt);
        //? Time Complexity : O(N*M) + O(N*M * 8)  => O(N*M)
        //? Space Complexity : O(N*M) [vis] + O(N*M) [queue]  => O(N*M)
    }
}
