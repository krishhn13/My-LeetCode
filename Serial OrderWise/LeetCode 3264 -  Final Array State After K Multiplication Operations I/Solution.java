class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
                while (k > 0) {
                        int mini = nums[0];
                        int idx = 0;
                        for (int i = 0; i < nums.length; i++) {
                                if (mini > nums[i]) {
                                        mini = nums[i];
                                        idx = i;
                                }
                        }
                        nums[idx] = mini * multiplier;
                        k--;
                }
                return nums;
        }
}