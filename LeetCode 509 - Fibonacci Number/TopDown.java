import java.util.Arrays;

class Solution{
        public int fib(int n){
                int[] dp = new int[n+1];
                Arrays.fill(dp,-1);
                return fibo(n,dp);
        }
        int fibo(int n, int[] dp) {
                if(n <= 1) {
                        return n;
                }
                if(dp[n]!=-1) {
                        return dp[n];
                } 
                dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
                return dp[n];
        }
}
public class TopDown {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.fib(5));
        }
}
