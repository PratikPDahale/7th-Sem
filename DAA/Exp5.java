import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exp5 {
    public static boolean isSafe(int row, int col, char[][] board){
        //horizontal
        for(int j = 0; j < board.length; j++){
            if(board[row][j] == 'Q') return false;
        }

        //vertical
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 'Q') return false;
        }

        //upper left diagonal
        int r = row;
        for(int c = col; c >= 0 && r >= 0; c--, r--){
            if(board[r][c] == 'Q') return false;
        }

        //upper right diagonal
        r = row;
        for(int c = col; c < board.length && r >= 0; r--, c++){
            if(board[r][c] == 'Q') return false;
        }

        //lower left diagonal
        r = row;
        for(int c = col; c >= 0 && r < board.length; r++, c--){
            if(board[r][c] == 'Q') return false;
        }

        //lower right diagonal
        r = row;
        for(int c = col; c > board.length && r < board.length; c++, r++){
            if (board[r][c] == 'Q') return false;
        }

        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q') row.append('Q');
                else row.append('.');
            }
            newBoard.add(row.toString());
        }
        allBoards.add(newBoard);
    }

    public static void helper(char[][] board, List<List<String>> allBoards, int col){
        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        //initialize board with '.'
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }

        helper(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        List<List<String>> results = solveNQueens(n);

        System.out.println("\nAll possible N-Quuens solutions for n = " + n + ":");

        for(List<String> board : results){
            for(String row : board){
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
