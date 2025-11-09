// Took 46ms and 46.42MB space
// Beats 14.72% in time and 6.84% in memory
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++) {
                for(int j = i+1; j < nums.length;j++) {
                        if(nums[i]+nums[j] == target) {
                                return new int[]{i,j};
                        }
                }
        }
        return new int[]{-1,-1};
    }
}
public class BruteForce {
        public static void main(String[] args) {
                Solution s = new Solution();
                int[] nums = {1,2,3,4,2};
                System.out.println(s.twoSum(nums,4));
        }
}


