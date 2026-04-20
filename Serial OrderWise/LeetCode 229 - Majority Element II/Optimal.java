import java.util.*;

public class Optimal {
        static class Solution {
                static int inf = -(int)1e9;
                public List<Integer> majorityElement(int[] nums) {
                        List<Integer> result = new ArrayList<>();
                        int cnt1 = 0, cnt2 = 0, ele1 = inf, ele2 = inf;
                        int n = nums.length;
                        for(int i = 0; i < n; i++) {
                                if(cnt1 == 0 && nums[i] != ele1) {
                                        cnt1 = 1; ele1 = nums[i];
                                } else if(cnt2 == 0 && nums[i] != ele2) {
                                        cnt2 = 1; ele2 = nums[i];
                                } else if(nums[i] == ele1) {
                                        cnt1++;
                                } else if(nums[i] == ele2) {
                                        cnt2++;
                                } else {
                                        cnt1--; cnt2--;
                                }
                        }
                        cnt1 = 0; cnt2 = 0;
                        for(int i = 0; i < nums.length; i++) {
                                if(nums[i] == ele1) cnt1++;
                                if(nums[i] == ele2) cnt2++;
                        }
                        if(cnt1 > n/3) result.add(ele1);
                        if(cnt2 > n/3) result.add(ele2);
                        return result;
                }
        }
        public static void main(String[] args) {
                int[] nums = {3,2,3};
                Solution sol = new Solution();
                List<Integer> list = sol.majorityElement(nums);
                System.out.println(list);
        }
}