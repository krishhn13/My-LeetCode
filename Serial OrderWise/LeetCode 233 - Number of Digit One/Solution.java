
// LeetCode Hard 233
// Topic Digit DP
import java.util.*;

public class Solution {
        int[][][] dp;

        public int countDigitOne(int n) {
                String str = String.valueOf(n);
                dp = new int[str.length()][2][str.length() + 1];
                for (int[][] d : dp) {
                        for (int[] r : d) {
                                Arrays.fill(r, -1);
                        }
                }
                return solve(str, 0, 1, 0);
        }

        private int solve(String str, int idx, int bound, int count) {
                if (idx == str.length()) {
                        return count;
                }
                int limit = (bound == 1) ? str.charAt(idx) - '0' : 9;
                int ans = 0;
                for (int i = 0; i <= limit; i++) {
                        int updatedBound = (bound == 1 && i == limit) ? 1 : 0;
                        int updatedCount = count + (i == 1 ? 1 : 0);
                        ans += solve(str, idx + 1, updatedBound, updatedCount);
                }
                return ans;
        }
}
