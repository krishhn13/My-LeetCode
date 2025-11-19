class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = -1, l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                f = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target == nums[i]) {
                l = i;
                break;
            }
        }
        return new int[] { f, l };
    }
}
public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.searchRange( new int[]{5,7,7,8,8,10}, 8));
        }
}
