import java.util.*;

class Solution {
        public long maximumTotalDamage(int[] power) {
                Map<Integer, Long> map = new TreeMap<>();
                for (int i : power) {
                        map.put(i, map.getOrDefault(i, 0L) + i);
                }
                int m = map.size();
                if (m == 0)
                        return 0;
                int[] keys = new int[m];
                long[] values = new long[m];
                long[] dp = new long[m];
                int idx = 0;
                for (var e : map.entrySet()) {
                        keys[idx] = e.getKey();
                        values[idx] = e.getValue();
                        idx++;
                }
                dp[0] = values[0];
                for (int i = 1; i < m; i++) {
                        int j = findPrev(keys, i);
                        long take = values[i] + (j >= 0 ? dp[j] : 0);
                        long skip = dp[i - 1];
                        dp[i] = Math.max(skip, take);
                }

                return dp[m - 1];
        }

        int findPrev(int[] keys, int i) {
                int target = keys[i] - 3;
                int l = 0, r = i - 1, ans = -1;
                while (l <= r) {
                        int mid = (l + r) / 2;
                        if (keys[mid] <= target) {
                                ans = mid;
                                l = mid + 1;
                        } else {
                                r = mid - 1;
                        }
                }
                return ans;
        }
}
