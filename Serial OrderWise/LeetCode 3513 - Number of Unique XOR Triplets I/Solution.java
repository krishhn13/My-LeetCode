import java.util.*;

class Solution {
        public int uniqueXorTriplets(int[] nums) {
                int n = nums.length;
                if (n <= 3) {
                        Set<Integer> xorSet = new HashSet<>();
                        for (int i = 0; i < n; i++) {
                                for (int j = i; j < n; j++) {
                                        for (int k = j; k < n; k++) {
                                                xorSet.add(nums[i] ^ nums[j] ^ nums[k]);
                                        }
                                }
                        }
                        return xorSet.size();
                }
                int bits = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
                return 1 << bits;
        }
}