class Solution {
        public int compareBitonicSums(int[] nums) {
                int maxi = Integer.MIN_VALUE, ind = -1;
                for (int i = 0; i < nums.length; i++) {
                        if (nums[i] > maxi) {
                                maxi = nums[i];
                                ind = i;
                        }
                }
                int n = nums.length;
                long left = 0, right = 0;
                for (int i = 0; i <= ind; i++) {
                        left += nums[i];
                }
                for (int i = ind; i < n; i++) {
                        right += nums[i];
                }
                if (left > right) {
                        return 0;
                } else if (left < right) {
                        return 1;
                } else {
                        return -1;
                }
        }
}