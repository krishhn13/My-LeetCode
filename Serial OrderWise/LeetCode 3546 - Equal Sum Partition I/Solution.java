class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        long sum = 0;
        for(int[] ar : grid) {
            for(int i : ar) {
                sum += i;
            }
        }
        if(sum%2 != 0) return false;
        long temp = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < m; j++) {
                temp += grid[i][j];
            }
            if(temp*2 == sum) return true;
        }
        temp = 0;
        for(int j = 0; j < m-1; j++) {
            for(int i = 0; i < n; i++) {
                temp+=grid[i][j];
            } 
            if(temp*2 == sum) return true;
        }
        return false;
    }
}