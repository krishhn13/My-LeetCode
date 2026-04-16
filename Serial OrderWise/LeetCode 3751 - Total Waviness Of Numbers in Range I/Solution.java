class Solution {
        public int totalWaviness(int num1, int num2) {
                int ans = 0;
                for (int i = num1; i <= num2; i++) {
                        String str = String.valueOf(i);
                        if (str.length() < 3) continue;
                        int count = 0;
                        for (int j = 1; j < str.length() - 1; j++) {
                                if (str.charAt(j) < str.charAt(j - 1) && str.charAt(j) < str.charAt(j + 1)) {
                                        count++;
                                }
                                if (str.charAt(j) > str.charAt(j - 1) && str.charAt(j) > str.charAt(j + 1)) {
                                        count++;
                                }
                        }
                        ans += count;
                }
                return ans;
        }
}