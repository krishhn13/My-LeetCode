class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int[][] pre = new int[grid.length][grid[0].length];
        pre[0][0] = grid[0][0];
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(i == 0 && j==0) {
                    continue;
                } else if (i == 0 && j!=0) {
                    pre[i][j] = pre[i][j-1] + grid[i][j];
                } else if(j == 0 && i!=0) {
                    pre[i][j] = pre[i-1][j] + grid[i][j];
                } else {
                    pre[i][j] = pre[i][j-1] + pre[i-1][j] + grid[i][j] - pre[i-1][j-1];
                }
            }
        }
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[i].length; j++) {
                if(pre[i][j] <= k) {
                    count++;
                }
            }
        }  
        return count;
    }
}