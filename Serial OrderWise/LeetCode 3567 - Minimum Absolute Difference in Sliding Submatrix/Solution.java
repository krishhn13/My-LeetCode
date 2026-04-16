import java.util.*;

class Solution {
        public int[][] minAbsDiff(int[][] grid, int k) {
                int m = grid.length, n = grid[0].length;
                int[][] ans = new int[m - k + 1][n - k + 1];
                if (k == 1)
                        return ans;
                for (int i = 0; i < m - k + 1; i++) {
                        for (int j = 0; j < n - k + 1; j++) {
                                List<Integer> list = findSub(grid, i, j, m, n, k);
                                ans[i][j] = findAbs(list);
                        }
                }
                return ans;
        }

        private List<Integer> findSub(int[][] grid, int row, int col, int m, int n, int k) {
                Set<Integer> set = new TreeSet<>();
                for (int i = row; i < row + k; i++) {
                        for (int j = col; j < col + k; j++) {
                                set.add(grid[i][j]);
                        }
                }
                return new ArrayList<>(set);
        }

        private int findAbs(List<Integer> list) {
                int mini = Integer.MAX_VALUE;
                for (int i = 0; i < list.size() - 1; i++) {
                        mini = Math.min(Math.abs(list.get(i) - list.get(i + 1)), mini);
                }
                return mini == Integer.MAX_VALUE ? 0 : mini;
        }
}