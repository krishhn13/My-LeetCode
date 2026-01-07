public class Solution {
        boolean[][] visited; 
        int n, m ;
        public boolean exist(char[][] board, String word) {
                n = board.length;
                m = board[0].length;
                visited = new boolean[n][m];
                for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m;j++) {
                                if(board[i][j] == word.charAt(0) &&!visited[i][j]) {
                                        if(find(board, word, 0, i, j)) {
                                                return true;
                                        }
                                }
                        }
                }
                return false;
        }
        private boolean find(char[][] board, String word, int i, int r, int c) {
                if(r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || board[r][c] != word.charAt(i)) {
                        return false;
                }
                visited[r][c] = true;
                boolean found = (
                        find(board, word, i+1,r+1,c) || find(board, word, i+1,r+1,c)|| find(board, word, i+1,r+1,c) || find(board, word, i+1,r+1,c)
                );
                visited[r][c] = false;
                return found;
        }
}
