class Solution {
        public int binaryGap(int n) {
                if (Integer.bitCount(n) == 1)
                        return 0;
                String val = Integer.toBinaryString(n);
                int maxi = 0;
                int curr = 0;
                boolean seenOne = false;
                for (char c : val.toCharArray()) {
                        if (c == '1') {
                                if (seenOne) {
                                        maxi = Math.max(maxi, curr);
                                }
                                seenOne = true;
                                curr = 0;
                        } else if (seenOne) {
                                curr++;
                        }
                }
                return maxi + 1;
        }
}