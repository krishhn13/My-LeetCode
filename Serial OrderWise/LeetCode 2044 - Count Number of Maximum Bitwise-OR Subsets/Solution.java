// Count Number of Maximum Bitwise-OR Subsets
class Solution {
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i : nums) {
            maxOr|=i;
        }
        solve(nums,0,0,maxOr);
        return count;
    }
    void solve(int[] nums, int index , int cOr , int maxOr) {
        if(cOr == maxOr) count++;
        for(int i = index;i<nums.length;i++) {
            solve(nums,i+1,cOr|nums[i],maxOr);
        }
    }
}