//* Number of Distinct Islands
//! (Medium Problem)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Pair)) return false;

        Pair other = (Pair) obj;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public int hashCode(){
        return 31*row + col;
    }
}
public class J10_Number_of_Distinct_Islands {

    //* Optimal : 
    //! (or we can also use String/StringBuilder instad of Pair class as Set doesn't know about Custom Pair class so for that we need to implement equals and hasCode)

    //? 1. Pair class based
    public static void dfs(int row, int col, int[][] grid, boolean[][] vis, List<Pair> ls, int row0, int col0, int[] drow, int[] dcol){
        vis[row][col] = true;
        ls.add(new Pair(row-row0, col-col0));

        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                dfs(nrow, ncol, grid, vis, ls, row0, col0, drow, dcol);
            }
        }
        
    }
    public static int numberOfDistinctIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Set<List<Pair>> shapes = new HashSet<>();
        
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    List<Pair> ls = new ArrayList<>();
                    dfs(i, j, grid, vis, ls, i, j, drow, dcol);
                    shapes.add(ls);
                }
            }
        }

        return shapes.size();
    }
    //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
    //? Space Complexity : O(N*M) [vis] + O(N*M) [set]  => O(N*M)

    //! 2. String based 
    public static void dfs(int row, int col, boolean[][] vis, int[][] grid, StringBuilder s, int row0, int col0, int[] drow, int[] dcol){
        vis[row][col] = true;
        s.append((row-row0) + "," + (col-col0) + " ");

        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1){
                dfs(nrow, ncol, vis, grid, s, row0, col0, drow, dcol);
            }
        }
    }
    public static int number_of_DistinctIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Set<String> shapes = new HashSet<>();

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    StringBuilder s = new StringBuilder();
                    dfs(i, j, vis, grid, s, i, j, drow, dcol);
                    shapes.add(s.toString());
                }
            }
        }

        return shapes.size();
    }
    //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
    //? Space Complexity : O(N*M) [vis] + O(N*M) [set]  => O(N*M)


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
        //! (or we can also use String/StringBuilder instad of Pair class as Set doesn't know about Custom Pair class so for that we need to implement equals and hasCode)

        //! 1. Pair class based
        int cnt = numberOfDistinctIslands(grid);
        System.out.println(cnt);
        //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
        //? Space Complexity : O(N*M) [vis] + O(N*M) [set]  => O(N*M)

        //! 2. String based
        int count = number_of_DistinctIslands(grid);
        System.out.println(count);
        //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
        //? Space Complexity : O(N*M) [vis] + O(N*M) [set]  => O(N*M)
    }
}
