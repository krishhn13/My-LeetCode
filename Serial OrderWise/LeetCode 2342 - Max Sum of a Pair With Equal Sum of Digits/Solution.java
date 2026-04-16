class Solution {
        private int sum(int n) {
                int sod = 0;
                while (n > 0) {
                        sod += n % 10;
                        n /= 10;
                }
                return sod;
        }

        public int maximumSum(int[] nums) {
                int[] maxNum = new int[82];
                int maxSum = -1;
                for (int num : nums) {
                        int sod = sum(num);
                        if (maxNum[sod] != 0) {
                                maxSum = Math.max(maxSum, num + maxNum[sod]);
                                maxNum[sod] = Math.max(maxNum[sod], num);
                        } else {
                                maxNum[sod] = num;
                        }
                }
                return maxSum;
        }
}
