class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);   
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char val='1';val<='9';val++) {
                        if (isSafe(i, j,board,val)) {
                            board[i][j] = val;
                            if (solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSafe(int row, int col, char[][] board, char val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i]==val) return false;
            if (board[i][col]==val) return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]==val) return false;
        }
        return true;
    }
}

public class SudokuSolver {
        public static void main(String[] args) {
                Solution sol = new Solution();
                char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
                sol.solveSudoku(board);
                for(char[] ch : board) {
                    for( char  c : ch) {
                        System.out.print(c + " ");
                    }
                    System.out.println();
                }
        }       
}
