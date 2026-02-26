class Solution {
        public int numSteps(String s) {
                int cnt = 0, carry = 0;
                for (int i = s.length() - 1; i > 0; i--) {
                        int bit = (s.charAt(i) - '0') + carry;
                        if (bit % 2 == 0) {
                                cnt++;
                        } else {
                                cnt += 2;
                                carry = 1;
                        }
                }
                return cnt + carry;
        }
}