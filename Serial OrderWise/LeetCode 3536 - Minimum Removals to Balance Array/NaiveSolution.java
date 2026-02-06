class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long find = (long) nums[i] * k;
            int lastIdx = findEle(find, nums, i);
            if (lastIdx == -1) {
                min = Math.min(min, nums.length - 1);
                continue;
            }
            min = Math.min(min, nums.length - (lastIdx - i) - 1);
        }
        return min;
    }

    private int findEle(long ele, int[] nums, int idx) {
        int l = idx, r = nums.length - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= ele) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
public class NaiveSolution {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.minRemoval(new int[]{2,1,5}, 2)); // expected  : 1 -> remove 5 to get 1*2<=2
        }
}
