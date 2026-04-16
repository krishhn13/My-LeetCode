class Solution {
    public int findMiddleIndex(int[] nums) {
        int prefixSum =0;
        int leftSum =0;
        for(int  i : nums) prefixSum+=i;
        for(int i = 0;i < nums.length;i++) {
            // because leftSum must be equal to rightSum leaving a pivot index
            if(prefixSum - leftSum - nums[i] == leftSum ) return i;
            leftSum+=nums[i];
        }
        // mujhe koi esa index nahi mila dosto 
        return -1;
    }
}