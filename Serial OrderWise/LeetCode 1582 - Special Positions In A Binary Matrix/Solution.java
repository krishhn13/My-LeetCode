class Solution {
        public int numSpecial(int[][] mat) {
                int cnt = 0;
                for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat[i].length; j++) {
                                if (mat[i][j] == 1) {
                                        if (check(i, j, mat)) {
                                                cnt++;
                                        }
                                }
                        }
                }
                return cnt;
        }

        private boolean check(int row, int col, int[][] mat) {
                for (int i = 0; i < mat.length; i++) {
                        if (i != row && mat[i][col] == 1) {
                                return false;
                        }
                }
                for (int i = 0; i < mat[0].length; i++) {
                        if (i != col && mat[row][i] == 1) {
                                return false;
                        }
                }
                return true;
        }
}