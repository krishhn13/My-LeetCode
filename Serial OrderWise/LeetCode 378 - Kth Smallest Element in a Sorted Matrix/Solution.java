import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] ar : matrix) {
            for(int i : ar) {
                pq.add(i);
            }
        }
        int cnt = 0 ;
        while(cnt < k-1) {
            pq.poll();
            cnt++;
        }
        return pq.peek();
    }
}