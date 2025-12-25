// this will throw TLE as the time goes ~2^n
class Solution {
        public int longestCommonSubsequence(String x, String y) {
                return recurr(x,y,x.length(),y.length());
        }
        int recurr(String x, String y, int m, int n) {
                if(m == 0 || n == 0) {
                        return 0;
                } 
                if(x.charAt(m-1) == y.charAt(n-1)) {
                        return 1 + recurr(x, y, m-1, n-1); 
                } else {
                        return Math.max(recurr(x, y, m-1, n), recurr(x, y, m, n-1));
                }
        }
}
public class Recursive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.longestCommonSubsequence("hare", "rare"));
        }       
}
