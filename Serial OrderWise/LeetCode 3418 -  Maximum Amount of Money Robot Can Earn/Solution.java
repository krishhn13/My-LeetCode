class Solution {
    Integer[][][] dp;
    public int maximumAmount(int[][] coins) {
        dp = new Integer[coins.length+1][coins[0].length+1][3];
        // for(Integer[][] d : dp) {
        //     for(Integer[] f : d) {
        //         Arrays.fill(f, -1);
        //     }
        // }
        return solve(coins, 0, 0, 2);
    }

    private int solve(int[][] coins, int row, int col, int leftOver) {
        if (row < 0 || col < 0 || row >= coins.length || col >= coins[0].length) {
            return Integer.MIN_VALUE;
        }
        if (row == coins.length - 1 && col == coins[0].length - 1) {
            if (coins[row][col] < 0 && leftOver > 0)
                return 0;
            return coins[row][col];
        }
        if(dp[row][col][leftOver]!=null) {
            return dp[row][col][leftOver];
        }
        if (coins[row][col] < 0) {
            if (leftOver > 0) {
                return dp[row][col][leftOver] = Math.max(
                        Math.max(
                                solve(coins, row + 1, col, leftOver - 1),
                                solve(coins, row, col + 1, leftOver - 1)),
                        Math.max(
                                solve(coins, row + 1, col, leftOver),
                                solve(coins, row, col + 1, leftOver)) + coins[row][col]);
            } else {
                return dp[row][col][leftOver] = Math.max(
                        solve(coins, row + 1, col, leftOver),
                        solve(coins, row, col + 1, leftOver)) + coins[row][col];
            }
        } else {
            return dp[row][col][leftOver] = coins[row][col]
                    + Math.max(solve(coins, row + 1, col, leftOver), solve(coins, row, col + 1, leftOver));
        }
    }
}

/*
class Solution {
    int[][][] dp;
    int INF = -(int)1e9;
    public int maximumAmount(int[][] coins) {
        dp = new int[coins.length+1][coins[0].length+1][3];
        for(int[][] d : dp) {
            for(int[] f : d) {
                Arrays.fill(f, INF);
            }
        }
        return solve(coins, 0, 0, 2);
    }

    private int solve(int[][] coins, int row, int col, int leftOver) {
        if (row < 0 || col < 0 || row >= coins.length || col >= coins[0].length) {
            return Integer.MIN_VALUE;
        }
        if (row == coins.length - 1 && col == coins[0].length - 1) {
            if (coins[row][col] < 0 && leftOver > 0)
                return 0;
            return coins[row][col];
        }
        if(dp[row][col][leftOver]!=INF) {
            return dp[row][col][leftOver];
        }
        if (coins[row][col] < 0) {
            if (leftOver > 0) {
                return dp[row][col][leftOver] = Math.max(
                        Math.max(
                                solve(coins, row + 1, col, leftOver - 1),
                                solve(coins, row, col + 1, leftOver - 1)),
                        Math.max(
                                solve(coins, row + 1, col, leftOver),
                                solve(coins, row, col + 1, leftOver)) + coins[row][col]);
            } else {
                return dp[row][col][leftOver] = Math.max(
                        solve(coins, row + 1, col, leftOver),
                        solve(coins, row, col + 1, leftOver)) + coins[row][col];
            }
        } else {
            return dp[row][col][leftOver] = coins[row][col]
                    + Math.max(solve(coins, row + 1, col, leftOver), solve(coins, row, col + 1, leftOver));
        }
    }
}

*/