public class Solution {
        public int[][] generateMatrix(int n) {
                int[][] mat = new int[n][n];
                if (n == 0) {
                        return mat;
                }
                int rowStart = 0;
                int rowEnd = n - 1;
                int colStart = 0;
                int colEnd = n - 1;
                int num = 1;
                while (rowStart <= rowEnd && colStart <= colEnd) {
                        for (int i = colStart; i <= colEnd; i++) {
                                mat[rowStart][i] = num++;
                        }
                        rowStart++;
                        for (int i = rowStart; i <= rowEnd; i++) {
                                mat[i][colEnd] = num++;
                        }
                        colEnd--;
                        for (int i = colEnd; i >= colStart; i--) {
                                if (rowStart <= rowEnd)
                                        mat[rowEnd][i] = num++;
                        }
                        rowEnd--;
                        for (int i = rowEnd; i >= rowStart; i--) {
                                if (colStart <= colEnd)
                                        mat[i][colStart] = num++;
                        }
                        colStart++;
                }
                return mat;
        }
}