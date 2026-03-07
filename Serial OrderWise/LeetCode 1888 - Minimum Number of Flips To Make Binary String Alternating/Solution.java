class Solution {
        public int minFlips(String s) {
                String dup = s + s;
                int n = s.length();
                int d1 = 0, d2 = 0;
                int idx = 0, mini = Integer.MAX_VALUE;
                while (idx < dup.length()) {
                        char evenZ = idx % 2 == 0 ? '0' : '1';
                        char oddZ = idx % 2 == 0 ? '1' : '0';
                        if (dup.charAt(idx) != evenZ) {
                                d1++;
                        }
                        if (dup.charAt(idx) != oddZ) {
                                d2++;
                        }
                        if (idx >= n) {
                                char last = dup.charAt(idx - n);
                                char lastE = (idx - n) % 2 == 0 ? '0' : '1';
                                char lastO = (idx - n) % 2 == 0 ? '1' : '0';
                                if (last != lastE) {
                                        d1--;
                                }
                                if (last != lastO) {
                                        d2--;
                                }
                        }
                        if (idx >= n - 1) {
                                mini = Math.min(mini, Math.min(d1, d2));
                        }
                        idx++;
                }
                return mini;
        }
}