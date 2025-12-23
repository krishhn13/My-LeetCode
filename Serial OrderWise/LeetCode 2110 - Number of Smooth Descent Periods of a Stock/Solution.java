class Solution {
        public long getDescentPeriods(int[] prices) {
                long cnt = 0;
                long n = 1;
                for (int i = 0; i < prices.length - 1; i++) {
                        if (prices[i] - 1 == prices[i + 1]) {
                                n++;
                        } else {
                                cnt += (n * (n + 1) / 2);
                                n = 1;
                        }
                }
                cnt += (n * (n + 1) / 2);
                return cnt;
        }
}
