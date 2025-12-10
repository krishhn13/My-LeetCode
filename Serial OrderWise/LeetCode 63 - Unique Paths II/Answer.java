import java.util.*;
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(obstacleGrid[0][0]!=0 || obstacleGrid[n-1][m-1] != 0) return 0;
        int[][] dp = new int[n+1][m+1];
        for(int[] i : dp) {
            Arrays.fill(i,-1);
        } 
        return dfs(obstacleGrid,0,0,dp,n,m);
    }
    private int dfs(int[][] mat, int r, int c, int[][] dp, int n ,int m) {
        if(r<0|| r>=n || c<0 || c>=m) return 0;
        if(r==n-1 && c == m-1) return 1;
        if(dp[r][c] != -1) return dp[r][c];
        int rightCall = 0, bottomCall = 0; 
        if(c+1 < m && mat[r][c+1]==0) rightCall = dfs(mat,r,c+1,dp,n,m);
        if(r+1 < n && mat[r+1][c]==0) bottomCall = dfs(mat,r+1,c,dp,n,m);
        return dp[r][c] = rightCall+bottomCall;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.);
        }        
}
