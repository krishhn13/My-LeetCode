class Solution {
        public int[][] modifiedMatrix(int[][] matrix) {
                int[][] ans = matrix;
                for (int i = 0; i < ans.length; i++) {
                        for (int j = 0; j < ans[i].length; j++) {
                                if (matrix[i][j] == -1) {
                                        ans[i][j] = replaceAtJ(j, ans);
                                }
                        }
                }
                return ans;
        }

        int replaceAtJ(int j, int[][] ans) {
                int maxi = Integer.MIN_VALUE;
                for (int i = 0; i < ans.length; i++) {
                        if (ans[i][j] > maxi) {
                                maxi = ans[i][j];
                        }
                }
                return maxi;
        }
}