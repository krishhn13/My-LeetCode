class Solution {
        int hello(int[] nums) {
                int prev = nums[0];
                int prev2 = 0;
                for (int i = 1; i < nums.length; i++) {
                        int take = nums[i];
                        if (i > 1)
                                take += prev2;
                        int nottake = prev;
                        int curr = Math.max(take, nottake);
                        prev2 = prev;
                        prev = curr;
                }
                return prev;
        }

        public int rob(int[] nums) {
                int n = nums.length;
                if (n == 1)
                        return nums[0];
                int[] a = new int[n - 1];
                int[] b = new int[n - 1];
                int aI = 0, bI = 0;
                for (int i = 0; i < n; i++) {
                        if (i != 0)
                                a[aI++] = nums[i];
                        if (i != n - 1)
                                b[bI++] = nums[i];

                }
                return Math.max(hello(a), hello(b));
        }
}