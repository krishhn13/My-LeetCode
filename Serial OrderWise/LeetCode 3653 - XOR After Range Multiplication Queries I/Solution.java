class Solution {
        public int xorAfterQueries(int[] nums, int[][] queries) {
                int MOD = (int) 1e9 + 7;
                for (int[] q : queries) {
                        int idx = q[0];
                        long v = q[3];
                        while (idx <= q[1]) {
                                nums[idx] = (int) ((nums[idx] * v) % MOD);
                                idx += q[2];
                        }
                }
                int xor = 0;
                for (int i : nums)
                        xor ^= i;
                return xor;
        }
}