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

        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] nums;
                if (args != null && args.length > 0) {
                        nums = new int[args.length];
                        for (int i = 0; i < args.length; i++) {
                                nums[i] = Integer.parseInt(args[i]);
                        }
                } else {
                        nums = new int[] { -10, 3, 5, -2 };
                }

                long ans = sol.maxProduct(nums);
                System.out.println(ans);
        }
}
