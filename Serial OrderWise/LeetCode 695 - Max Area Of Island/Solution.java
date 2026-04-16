class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i < m;i++) {
            for(int j = 0; j < n;j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid,m,n,i,j,visited);
                    maxi = Math.max(area,maxi);
                }
            }
        }
        return maxi==Integer.MIN_VALUE ? 0 : maxi ; 
    }
    int dfs(int[][] grid, int m, int n, int i, int j,boolean[][] visited) {
        if(i<0 || i>= m || j < 0 || j >= n) return 0;
        if(grid[i][j]!=1 || visited[i][j]) return 0;
        visited[i][j] = true;
        int l = dfs(grid,m,n,i,j-1,visited);
        int r = dfs(grid,m,n,i,j+1,visited);
        int u = dfs(grid,m,n,i-1,j,visited);
        int d = dfs(grid,m,n,i+1,j,visited);
        return 1+l+r+u+d;
    }
}