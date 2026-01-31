import java.util.*;

class Solution {
        public String largestNumber(int[] nums) {
                String[] s = new String[nums.length];
                int k = 0;
                for (int i : nums) {
                        s[k++] = String.valueOf(i);
                }
                Arrays.sort(s, (a, b) -> (b + a).compareTo(a + b));
                if (s[0].equals("0"))
                        return "0";
                String ans = "";
                for (String c : s) {
                        ans += c;
                }
                return ans;
        }
}