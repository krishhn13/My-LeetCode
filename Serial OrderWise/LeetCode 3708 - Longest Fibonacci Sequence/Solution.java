class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length<=2) return nums.length;
        int maxi = 2, ans = 2;
        for(int i = 2;i<nums.length;i++) {
            if(nums[i-1] + nums[i-2] == nums[i]) {
                ans++;
            } else {
                maxi = maxi > ans ? maxi  :ans;
                ans = 2;
            }
        }
        maxi = maxi > ans ? maxi  :ans;
        return maxi;
    }
}