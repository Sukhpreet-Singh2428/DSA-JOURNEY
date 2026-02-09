//* Word Search
//! (Hard Problem)

//? Given a grid of n x m dimension grid of characters board and a string word.
//? The word can be created by assembling the letters of successively surrounding cells, 
//? whether they are next to each other vertically or horizontally. 
//? It is forbidden to use the same letter cell more than once.
//? Return true if the word exists in the grid otherwise false.
//? Example 1
//? Input : board = [ ["A", "B", "C", "E"] , 
//?                   ["S" ,"F" ,"C" ,"S"] , 
//?                   ["A", "D", "E", "E"] 
//?                 ] 
//?        , word = "ABCCED"
//? Output : true

import java.util.Scanner;
public class J2_WordSearch {
    public static boolean wordSearch(int idx, int i, int j, char[][] board, int n, int m, String word){
        if(idx == word.length()){
            return true;
        }
        if(board[i][j] == ' ' || board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans = false;
        //* top 
        if(i-1 >= 0){
            ans = ans || wordSearch(idx+1, i-1, j, board, n, m, word);
        }
        //* down
        if(i+1 < n){
            ans = ans || wordSearch(idx+1, i+1, j, board, n, m, word);
        }
        //* rigth
        if(j+1<m){
            ans = ans || wordSearch(idx+1, i, j+1, board, n, m, word);
        }
        if(j-1 >= 0){
            ans = ans || wordSearch(idx+1, i, j-1, board, n, m, word);
        }

        board[i][j] = temp;

        return ans;
    }
    public static boolean exist(char[][] board, String word, int n, int m){
        if(word.length()==1 && board[0][0] == word.charAt(0)){
            return true;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(wordSearch(0, i, j, board, n, m, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //? Time Complexity : O(N * M * 4^L) where N is rows, M is columns 
    //?         and L is the word length; recursive search through board.
    //? Space Complexity : O(L) due to recursive call stack depth, where L is the length of the word.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();
        sc.close();

        //* Optimal : 
        System.out.println(exist(board, word, n, m));
        //? Time Complexity : O(N * M * 4^L) where N is rows, M is columns 
        //?         and L is the word length; recursive search through board.
        //? Space Complexity : O(L) due to recursive call stack depth, where L is the length of the word.
    }
}
