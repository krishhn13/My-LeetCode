import java.util.*;
class Solution {
        public long[] getDistances(int[] a) {
                HashMap<Integer, List<Integer>> map = new HashMap<>();
                for (int i = 0; i < a.length; i++) {
                        map.computeIfAbsent(a[i], k -> new ArrayList<>()).add(i);
                }
                long[] ans = new long[a.length];
                for (List<Integer> l : map.values()) {
                        int n = l.size();
                        long[] pre = new long[n];
                        pre[0] = l.get(0);
                        for (int i = 1; i < n; i++)
                                pre[i] = pre[i - 1] + l.get(i);
                        for (int i = 0; i < n; i++) {
                                int idx = l.get(i);
                                long left = 0, right = 0;
                                if (i > 0)
                                        left = (long) i * l.get(i) - pre[i - 1];
                                else
                                        left = 0;
                                right = pre[n - 1] - pre[i] - (long) (n - i - 1) * l.get(i);
                                ans[idx] = left + right;
                        }
                }
                return ans;
        }
}