class Solution {
    public int maximumPossibleSize(int[] nums) {
        int cnt=1;
        int c = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(c<=nums[i]){
                cnt++;
                c=nums[i];
            }
        }
        return cnt;
    }
}