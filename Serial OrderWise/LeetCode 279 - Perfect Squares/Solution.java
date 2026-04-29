class Solution {
    int inf = (int)1e9;
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        generate(squares, n);
        int[][] dp = new int[squares.size()+1][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = solve(squares, dp, n, squares.size()-1);
        if(ans >= inf) return -1;
        return ans; 
    }
    private int solve(List<Integer> list, int[][] dp, int total, int n) {
        if(total <= 0) return 0;
        if(n < 0) return inf;
        if(dp[n][total]!=-1) return dp[n][total];
        int notTake = solve(list, dp, total, n-1);
        int take = inf;
        if(total >= list.get(n)) {
            take = 1 + solve(list, dp, total-list.get(n), n);
        }
        return dp[n][total] = Math.min(take, notTake);
    }
    private void generate(List<Integer> list, int n) {
        int num = (int)Math.sqrt(n);
        for(int i = 1; i <= num; i++) {
            list.add(i*i);
        }
    }
}