import java.util.*;

class Solution {
        public int[] decimalRepresentation(int n) {
                List<Integer> res = new ArrayList<>();
                int p = 1;
                while (n > 0) {
                        int d = n % 10;
                        if (d != 0) {
                                res.add(d * p);
                        }
                        n /= 10;
                        p *= 10;
                }

                Collections.sort(res, Collections.reverseOrder());

                int[] ans = new int[res.size()];
                for (int i = 0; i < res.size(); i++) {
                        ans[i] = res.get(i);
                }

                return ans;
        }
}