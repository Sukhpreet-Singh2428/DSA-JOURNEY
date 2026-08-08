//* Number of Enclaves
//! (Medium Problem)

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
public class J9_Number_of_Enclaves {

    public static void bfs(int row, int col, boolean[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        vis[row][col] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                    qu.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }

    }
    public static int numberOfEnclaves(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        //? first row and last row
        for(int j=0; j<m; j++){
            if(grid[0][j]==1 && vis[0][j]==false){
                bfs(0, j, vis, grid);
            }
            if(grid[n-1][j]==1 && vis[n-1][j]==false){
                bfs(n-1, j, vis, grid);
            }
        }

        //? first col and last col
        for(int i=0; i<n; i++){
            if(grid[i][0]==1 && vis[i][0]==false){
                bfs(i, 0, vis, grid);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==false){
                bfs(i, m-1, vis, grid);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    ans++;
                }
            }
        }

        return ans;

    }
    //? Time Complexity : O(M) + O(N) + O(N*M * 4) + O(N*M)  =>  O(N*M)
    //? Space Complexity : O(N*M) [vis]  +  O(N*M) [queue]   =>  O(N*M)
    

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
        int ans = numberOfEnclaves(grid);
        System.out.println(ans);
        //? Time Complexity : O(M) + O(N) + O(N*M * 4) + O(N*M)  =>  O(N*M)
        //? Space Complexity : O(N*M) [vis]  +  O(N*M) [queue]   =>  O(N*M)
    }
}
