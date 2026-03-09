class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i : nums) pq.add(i);
        int i = 1;
        while(i<k){
            pq.remove();
            i++;
        }
        return pq.peek();
    }
}