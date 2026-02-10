//* N Queen 
//! (Hard Problem)

//? The challenge of arranging n queens on a n × n chessboard so that no two queens attack one another is known as the "n-queens puzzle."
//? Return every unique solution to the n-queens puzzle given an integer n. The answer can be returned in any sequence.
//? Every solution has a unique board arrangement for the placement of the n-queens, where 'Q' and '.' stand for a queen and an empty space, respectively.
//? Example 1
//? Input : n = 4
//? Output : [[".Q.." , "...Q" , "Q..." , "..Q."] , ["..Q." , "Q..." , "...Q" , ".Q.."]]
//* Explanation : There are two possible combinations as shown below.
//*                (go and check in TUF+)

//! Conditions : 
//* 1. Every row has 1 Queen
//* 2. Every column has 1 Queen
//* 3. No Queen attack each other

//* --> Queen attacks in 8 directions 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class J3_NQueen {
    public static boolean placingIsPossible(List<String> board, int row, int col){
        int r = row;
        int c = col;

        //* top 
        while(r >= 0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
        }
        r = row;
        c = col;

        //* upper right diagonal
        while(r >= 0 && c < board.get(0).length()){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c++;
        }
        r = row;
        c = col;

        //* Upper left diagonal
        while(r >= 0 && c >= 0){
            if(board.get(r).charAt(c) == 'Q'){
                return false;
            }
            r--;
            c--;
        }

        return true;
    }
    public static void func(int row, List<String> board, List<List<String>> ans, int n){
        if(row == n){  //? or row == board.size()
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col = 0; col<n; col++){
            if(placingIsPossible(board, row, col)){
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));

                func(row+1, board, ans, n);

                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for(int i=0; i<n; i++){
            String str = "";
            for(int j=0; j<n; j++){
                str += ".";
            }
            board.add(str);
        }

        func(0, board, ans, n);
        return ans;
    }
    //? Time Complexity: O(N!), where N is the number of queens
    //?     Due to the recursive search through potential placements and backtracking.
    //? Space Complexity: O(N), for the recursion stack and the storage of the solutions.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //* Optimal : 
        List<List<String>> ans = solveNQueens(n);
        System.out.println(ans);
        //? Time Complexity: O(N!), where N is the number of queens
        //?     Due to the recursive search through potential placements and backtracking.
        //? Space Complexity: O(N), for the recursion stack and the storage of the solutions.
    }
}
