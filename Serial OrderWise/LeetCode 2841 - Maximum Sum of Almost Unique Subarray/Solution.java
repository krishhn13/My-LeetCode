import java.util.*;

class Solution {
        public long maxSum(List<Integer> nums, int m, int k) {
                long sum = 0;
                long maxi = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < k; i++) {
                        map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
                        sum += nums.get(i);
                }
                if (map.size() >= m) {
                        maxi = Math.max(sum, maxi);
                }
                for (int i = k; i < nums.size(); i++) {
                        int prev = nums.get(i - k);
                        int now = nums.get(i);
                        if (map.get(prev) == 1) {
                                map.remove(prev);
                        } else {
                                map.put(prev, map.get(prev) - 1);
                        }
                        map.put(now, map.getOrDefault(now, 0) + 1);
                        sum -= prev;
                        sum += now;
                        if (map.size() >= m) {
                                maxi = Math.max(sum, maxi);
                        }
                }
                return maxi;
        }
}