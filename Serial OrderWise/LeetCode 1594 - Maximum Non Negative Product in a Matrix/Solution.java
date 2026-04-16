class Pair {
    long max, min;
    Pair(long max, long min) {
        this.max = max;
        this.min = min;
    }
}
class Solution {
    int n, m;
    Pair[][] dp ;
    public int maxProductPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new Pair[n][m];
        Pair res = solve(grid, 0, 0);
        if (res.max < 0) return -1;
        return (int)(res.max % 1000000007);
    }
    private Pair solve(int[][] grid, int row, int col) {
        if (row >= n || col >= m) {
            return null;
        }
        if (row == n - 1 && col == m - 1) {
            return new Pair(grid[row][col], grid[row][col]);
        }
        if(dp[row][col] != null) {
            return dp[row][col];
        }
        Pair right = solve(grid, row, col + 1);
        Pair down  = solve(grid, row + 1, col);
        long val = grid[row][col];
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        if (right != null) {
            long a = val * right.max;
            long b = val * right.min;
            max = Math.max(max, Math.max(a, b));
            min = Math.min(min, Math.min(a, b));
        }
        if (down != null) {
            long c = val * down.max;
            long d = val * down.min;
            max = Math.max(max, Math.max(c, d));
            min = Math.min(min, Math.min(c, d));
        }
        return dp[row][col] = new Pair(max, min);
    }
}