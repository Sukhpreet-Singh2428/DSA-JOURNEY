//* Surrounded Regions (also known as Replace O's with X's)
//! (Medium Problem)

//! Algorithm
//* 1) Start from the boundary O's and mark them that will not be
//*    be converted into X
//* 2) Convert the remaining O's into X

import java.util.Scanner;

public class J8_Surrounded_Regions {

    public static void dfs(int row, int col, boolean[][] vis, char[][] mat, int[] drow, int[] dcol){
        vis[row][col] = true;

        int n = mat.length;
        int m = mat[0].length;
        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false && mat[nrow][ncol]=='O'){
                dfs(nrow, ncol, vis, mat, drow, dcol);
            }
        }
    }
    public static void surroundedRegions(char[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        //? first row and last row;
        for(int j=0; j<m; j++){

            //? first row
            if(mat[0][j]=='O' && vis[0][j] == false){
                dfs(0, j, vis, mat, drow, dcol);
            }

            //? last row
            if(mat[n-1][j]=='O' && vis[n-1][j]==false){
                dfs(n-1, j, vis, mat, drow, dcol);
            }
        }

        //? first col and Last col
        for(int i=0; i<n; i++){

            //? first col
            if(mat[i][0]=='O' && vis[i][0]==false){
                dfs(i, 0, vis, mat, drow, dcol);
            } 

            //? last col
            if(mat[i][m-1]=='O' && vis[i][m-1]==false){
                dfs(i, m-1, vis, mat, drow, dcol);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==false && mat[i][j]=='O'){
                    mat[i][j] = 'X';
                }
            }
        }

        //? return mat  {if needed to return modified mat}
    }
    //? Time Complexity : O(N) + O(M) + O(N*M)
    //? Space Complexity : O(N*M) [vis] + O(N*M) [recursive stack space]


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] mat = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mat[i][j] = sc.next().charAt(0);
            }
        }

        sc.close();


        //* Optimal : 
        surroundedRegions(mat);
        //? Time Complexity : O(N) + O(M) + O(N*M)
        //? Space Complexity : O(N*M) [recursive stack space]

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
