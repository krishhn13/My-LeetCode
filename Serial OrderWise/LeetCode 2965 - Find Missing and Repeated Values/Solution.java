class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
                int n = grid.length;
                int N = n * n;
                int[] ans = new int[2];
                int[] freq = new int[N + 1];
                int sum = 0;

                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                int val = grid[i][j];
                                freq[val]++;
                                sum += val;
                                if (freq[val] == 2) {
                                        ans[0] = val;
                                }
                        }
                }

                int expectedSum = N * (N + 1) / 2;
                ans[1] = expectedSum - (sum - ans[0]);

                return ans;
        }
}
