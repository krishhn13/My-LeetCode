class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
                int[] ans = new int[nums.size()];
                int idx = 0;
                for (int i : nums) {
                        if (i == 2) {
                                ans[idx] = -1;
                        } else {
                                int num = findNext(i);
                                ans[idx] = num;
                        }
                        idx++;
                }
                return ans;
        }

        private int findNext(int n) {
                String bin = Integer.toBinaryString(n);
                int cnt = 0;
                for (int i = bin.length() - 1; i >= 0; i--) {
                        if (bin.charAt(i) == '0') {
                                break;
                        }
                        cnt = i;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(bin.substring(0, cnt));
                sb.append('0');
                sb.append(bin.substring(cnt + 1));
                return Integer.parseInt(sb.toString(), 2);
        }
}