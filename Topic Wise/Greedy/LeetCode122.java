class Solution {
        public int maxProfit(int[] prices) {
                int profit = -prices[0];
                int pre = prices[0];
                for (int i = 1; i < prices.length; i++) {
                        if (prices[i] > pre) {
                                profit += prices[i];
                        } else {
                                profit += pre;
                        }
                        pre = prices[i];
                        profit -= pre;
                }
                profit += pre;
                return profit;
        }
}

public class LeetCode122 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = { 1, 3, 4, 5, 6, 7 };
                System.out.println(sol.maxProfit(arr));
        }
}
