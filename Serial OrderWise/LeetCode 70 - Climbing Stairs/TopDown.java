import java.util.*;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        count(0,n,dp);
        System.out.println(Arrays.toString(dp));
        return 0;
    }
    int count(int i , int n, int[] dp){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=-1) {
            return dp[i];
        }
        dp[i] = count(i+1,n,dp) + count(i+2,n,dp);
        return dp[0];
    }
}

public class TopDown{
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(44));
    }
}
