class Solution {
        public long maxProduct(int[] nums) {
                long max1 = 0, max2 = 0;
                for (int n : nums) {
                        n = Math.abs(n);
                        if (n > max1) {
                                max2 = max1;
                                max1 = n;
                        } else if (n > max2) {
                                max2 = n;
                        }
                }
                return max1 * max2 * 100000L;
        }
}
public class LeetCode3732 {
        
}
