import java.util.*;

class Solution {
        public int countPairs(int[] deliciousness) {
                long cnt = 0;
                int mod = (int) 1e9 + 7;
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < deliciousness.length; i++) {
                        for (int j = 0; j < 22; j++) {
                                int need = (1 << j) - deliciousness[i];
                                if (map.containsKey(need)) {
                                        cnt += map.get(need);
                                }
                        }
                        map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
                }
                return (int) (cnt % mod);
        }
}