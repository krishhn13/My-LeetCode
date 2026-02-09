class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target); 
        int right = findRight(nums, target); 
        return new int[]{left, right};
    }
    private int findLeft(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                ans = mid;
                end = mid-1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    private int findRight(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                ans = mid;
                start = mid+1;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return ans;
    }
}
public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        }
}
