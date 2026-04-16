import java.util.*;

class Solution {
        public int minSwapsCouples(int[] row) {
                int n = row.length;
                int[][] couples = new int[n / 2][2];
                int idx = 0;
                for (int i = 0; i < n; i += 2) {
                        couples[idx][0] = row[i];
                        couples[idx][1] = row[i + 1];
                        idx++;
                }
                Map<Integer, Integer> pairedUp = new HashMap<>();
                for (int[] couple : couples) {
                        pairedUp.put(couple[0], couple[1]);
                        pairedUp.put(couple[1], couple[0]);
                }
                int swaps = 0;
                for (int man : new ArrayList<>(pairedUp.keySet())) {
                        if ((man % 2 == 0 && pairedUp.get(man) == man + 1)
                                        || (man % 2 != 0 && pairedUp.get(man) == man - 1)) {
                                continue;
                        } else {
                                int now = pairedUp.get(man);
                                int need = -1;
                                if (man % 2 == 0)
                                        need = man + 1;
                                else
                                        need = man - 1;
                                int pair = pairedUp.get(need);
                                pairedUp.put(man, need);
                                pairedUp.put(need, man);
                                pairedUp.put(now, pair);
                                pairedUp.put(pair, now);
                                swaps++;
                        }
                }
                return swaps;
        }
}