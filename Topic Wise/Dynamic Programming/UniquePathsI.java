import java.util.*;

class Solution {
        public int uniquePaths(int m, int n) {
                int[][] dp = new int[m + 1][n + 1];
                for (int[] arr : dp) {
                        Arrays.fill(arr, -1);
                }
                return dfs(dp, m, n, 0, 0);
        }

        private int dfs(int[][] dp, int m, int n, int i, int j) {
                if (i < 0 || i >= m || j < 0 || j >= n)
                        return 0;
                if (i == m - 1 && j == n - 1)
                        return 1;
                if (dp[i][j] != -1)
                        return dp[i][j];
                int l = 0, r = 0;
                if (i + 1 < m)
                        l = dfs(dp, m, n, i + 1, j);
                if (j + 1 < n)
                        r = dfs(dp, m, n, i, j + 1);
                return l + r;
        }
}

public class UniquePathsI {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.uniquePaths(3, 7));
        }
}
