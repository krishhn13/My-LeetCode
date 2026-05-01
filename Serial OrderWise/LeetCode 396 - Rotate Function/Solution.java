class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int sum = 0;
        int cSum = 0;
        for(int i = 0 ; i < n; i++) {
            sum += nums[i];
            cSum += (i * nums[i]);
        }
        for(int i = 0 ; i < n;i++) {
            pre[i] = sum - nums[i];
        }
        int maxi = Integer.MIN_VALUE;
        maxi = Math.max(cSum, maxi);
        for(int i = 0; i < n; i++) {
            cSum -= pre[i];
            cSum += (nums[i] * (n-1));
            maxi = Math.max(maxi, cSum); 
        }
        return maxi;
    }
}