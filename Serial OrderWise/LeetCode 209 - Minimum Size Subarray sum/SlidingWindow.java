class Solution{
        public int minSubArrayLen(int target, int[] nums) {
                int winSt = 0,  sum = 0, minVal = Integer.MAX_VALUE;
                for(int winEnd = 0; winEnd < nums.length;winEnd++) {
                        sum += nums[winEnd];
                        if(sum>=target) {
                                int currSize = winEnd-winSt+1;
                                minVal = Math.min(currSize,minVal);
                                sum-=nums[winSt];
                                winSt++;
                        }  
                }
                return minVal == Integer.MAX_VALUE ? 0 : minVal;
        }
}

public class SlidingWindow {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.minSubArrayLen(7, new int[]{2,3,1,3,4,3}));
        }
}
