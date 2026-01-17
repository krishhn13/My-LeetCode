class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int removedOne = -1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] > 0) {
                if(i - 1 == removedOne) {
                    if(i >= 2 && nums[i] - nums[i-2] < 0) {
                        return false;
                    }
                }
            } else {
                if(removedOne != -1) {
                    return false;
                }
                if(i+1 == nums.length) return true;
                if (i+1 < nums.length && nums[i - 1] < nums[i + 1]) {
                    removedOne = i;
                }
                else {
                    if(i>=2 && nums[i] - nums[i-2] <= 0) {
                        return false;
                    }
                    removedOne = i - 1;
                }
            }
        }
        return true;
    }
}