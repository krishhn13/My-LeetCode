import java.util.*;
class Solution {
        public String[] findRelativeRanks(int[] score) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                for (int s : score)
                        pq.add(s);
                int n = score.length;
                HashMap<Integer, String> map = new HashMap<>();
                int rank = 1;
                while (!pq.isEmpty()) {
                        int val = pq.poll();
                        if (rank == 1)
                                map.put(val, "Gold Medal");
                        else if (rank == 2)
                                map.put(val, "Silver Medal");
                        else if (rank == 3)
                                map.put(val, "Bronze Medal");
                        else
                                map.put(val, String.valueOf(rank));
                        rank++;
                }

                String[] res = new String[n];
                for (int i = 0; i < n; i++) {
                        res[i] = map.get(score[i]);
                }
                return res;
        }
}
