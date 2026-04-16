class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxCount = -1;
        int result = Integer.MAX_VALUE;
        for (int div : divisors) {
            int count = 0;
            for (int num : nums) {
                if (num % div == 0) {
                    count++;
                }
            }
            if (count > maxCount || (count == maxCount && div < result)) {
                maxCount = count;
                result = div;
            }
        }
        return result;
    }
}
