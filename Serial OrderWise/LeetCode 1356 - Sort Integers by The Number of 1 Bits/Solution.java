import java.util.*;

class Solution {
        public int[] sortByBits(int[] arr) {
                Integer[] ans = new Integer[arr.length];
                for (int i = 0; i < ans.length; i++) {
                        ans[i] = arr[i];
                }
                Arrays.sort(ans, (a, b) -> {
                        int cmp = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
                        if (cmp == 0)
                                return Integer.compare(a, b);
                        return cmp;
                });
                for (int i = 0; i < ans.length; i++) {
                        arr[i] = ans[i];
                }
                return arr;
        }
}