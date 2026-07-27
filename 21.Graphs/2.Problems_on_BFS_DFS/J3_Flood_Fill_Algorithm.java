//* Flood Fill Algorithm
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
public class J3_Flood_Fill_Algorithm {

    public static void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int iniColor, int[] drow, int[] dcol){
        ans[row][col] = newColor;

        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];  //? neighbour row
            int ncol = col + dcol[i];  //? neighbour col
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && ans[nrow][ncol]!=newColor){
                dfs(nrow, ncol, ans, image, newColor, iniColor, drow, dcol);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int n = image.length;
        int m = image[0].length;

        int iniColor = image[sr][sc];
        int[][] ans = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = image[i][j];
            }
        }

        int[] drow = {-1, 0, 1, 0};   //? delta row
        int[] dcol = {0, 1, 0, -1};   //? delta col
        dfs(sr, sc, ans, image, newColor, iniColor, drow, dcol);
        // bfs(sr, sc, ans, image, iniColor, newColor);   //* can do it with BFS as well 

        return ans;
    }
    //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
    //? Space Complexity : O(N*M) [ans] + O(N*M) [recursive stack space]

    public static void bfs(int row, int col, int[][] ans, int[][] image, int iniColor, int newColor){
        int n = image.length;
        int m = image[0].length;

        Queue<Pair> qu = new ArrayDeque<>();
        qu.offer(new Pair(row, col));
        ans[row][col] = newColor;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            qu.poll();

            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=newColor && image[nrow][ncol]==iniColor){
                    qu.offer(new Pair(nrow, ncol));
                    ans[nrow][ncol] = newColor;
                }
            }
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] image = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                image[i][j] = scanner.nextInt();
            }
        }

        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        int newColor = scanner.nextInt();

        scanner.close();


        //* Optimal : 
        int[][] ans = floodFill(image, sr, sc, newColor);

        //? output : 
        System.out.println();
        for(int[] row : ans){
            for(int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        //? Time Complexity : O(N*M) + O(N*M * 4)  =>  O(N*M)
        //? Space Complexity : O(N*M) [ans] + O(N*M) [recursive stack space]
    }
}
