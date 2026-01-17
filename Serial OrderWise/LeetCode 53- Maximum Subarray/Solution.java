class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0, maxi = -(int)1e9;
        for(int i : nums) {
            curr = Math.max(i, curr + i);
            maxi = Math.max(maxi, curr);
        }
        return maxi;
    }
}