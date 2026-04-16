class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i < board.length;i++) {
                for(int j = 0;j<board.length;j++) {
                        char val = board[i][j];
                        if(val!='.'){
                                if(!isValid(val,i,j,board)) return false;
                        }
                }
        }
        return true;
    }
    private boolean isValid(char val , int row, int col, char[][] board) {
        // checking the row
        for(int i = 0;i < board.length;i++) {
                if(i!=col && board[row][i]==val) return false;
        }
       // checking the col
        for(int i = 0;i < 9;i++) {
            if(i!=row && board[i][col] == val ) return false;
        }

        // checking 3x3 matrix
        for(int i = 0;i<9;i++) {
            if(row == 3*(row/3)+i/3 && col == 3*(col/3)+i%3) continue;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==val) return false; 
        }
        return true;
    }
}
public class Answer {
        
}
