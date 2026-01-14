import java.util.*;

class Pair {
        int ones, idx;

        Pair(int ones, int idx) {
                this.ones = ones;
                this.idx = idx;
        }
}

public class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
                PriorityQueue<Pair> pq = new PriorityQueue<>(
                                (a, b) -> {
                                        if (a.ones == b.ones) {
                                                return Integer.compare(a.idx, b.idx);
                                        } else {
                                                return Integer.compare(a.ones, b.ones);
                                        }
                                });
                for (int i = 0; i < mat.length; i++) {
                        int cnt = 0;
                        for (int j = 0; j < mat[i].length; j++) {
                                if (mat[i][j] == 1)
                                        cnt++;
                        }
                        pq.add(new Pair(cnt, i));
                }
                int[] ans = new int[k];
                int idx = 0;
                int last = k;
                while (last > 0) {
                        ans[idx] = pq.poll().idx;
                        idx++;
                        last--;
                }
                return ans;
        }
}