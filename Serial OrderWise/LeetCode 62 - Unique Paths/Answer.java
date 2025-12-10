import java.util.*;
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] i:dp) {
            Arrays.fill(i,-1);
        }
        return dfs(0,0,m,n,dp);
    }
    private int dfs(int r , int c , int m , int n, int[][] dp) {
        if(r<0||r>=m||c<0||c>=n) return 0;
        if(r == m-1 && c == n-1) return 1;
        if(dp[r][c]!=-1) return dp[r][c];
        int l = 0, ri = 0;
        if(c+1<n) l=dfs(r,c+1,m,n,dp);
        if(r+1<m) ri=dfs(r+1,c,m,n,dp);
        return dp[r][c]=l+ri;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.uniquePaths(3, 7));
        }        
}
