public class Optimal {
        static class Solution {
                public int majorityElement(int[] nums) {
                        // Moore's Voting Algorightm
                        int cnt = 0, ele = Integer.MIN_VALUE;
                        int n = nums.length;
                        for(int i = 0; i < n; i++) {
                                if(cnt == 0) {
                                        cnt = 1;
                                        ele = nums[i];
                                } else if(ele == nums[i]) {
                                        cnt++;
                                } else {
                                        ele = cnt--;
                                }
                        }
                        if(cnt == 0) return -1;
                        if(cnt > n/2) return ele;
                        return -1;
                }
        }
        public static void main(String[] args) {
                int[] nums = {2,2,2,1,2,3,4};
                Solution sol = new Solution();
                System.out.println(sol.majorityElement(nums));
        }
}