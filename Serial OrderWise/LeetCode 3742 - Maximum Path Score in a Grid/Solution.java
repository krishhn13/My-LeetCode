class Solution {
    int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][k + 1];
        for(int[][] d : dp) {
            for(int[] a : d) Arrays.fill(a, -2);
        }
        return solve(grid, n, m, 0, 0, k, 0);
    }

    private int solve(int[][] grid, int n, int m, int i, int j, int k, int cost) {
        if (i >= n || j >= m) return -1;
        if (grid[i][j] != 0) cost++;
        if (cost > k) return -1;
        if (i == n - 1 && j == m - 1) return grid[i][j];
        if (dp[i][j][cost] != -2) return dp[i][j][cost];
        int right = solve(grid, n, m, i, j + 1, k, cost);
        int down = solve(grid, n, m, i + 1, j, k, cost);
        int best = Math.max(right, down);
        if (best == -1) return dp[i][j][cost] = -1;
       return dp[i][j][cost] = grid[i][j] + best;
    }
}