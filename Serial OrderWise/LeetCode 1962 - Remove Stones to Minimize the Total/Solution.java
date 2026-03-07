import java.util.*;

class Solution {
        public int minStoneSum(int[] piles, int k) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                for (int i : piles) {
                        pq.add(i);
                }
                while (k > 0) {
                        int val = pq.poll();
                        if (val % 2 == 0) {
                                pq.add(val / 2);
                        } else {
                                pq.add((val / 2) + 1);
                        }
                        k--;
                }
                int sum = 0;
                while (!pq.isEmpty()) {
                        sum += pq.poll();
                }
                return sum;
        }
}