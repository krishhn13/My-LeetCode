class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            pre[i] = pre[i-1]^arr[i];
        }
        int[]ans = new int[queries.length];
        int idx = 0;
        for(int[] q : queries) {
            if(q[0] == 0) {
                ans[idx] = pre[q[1]];
            } else {
                ans[idx] = pre[q[1]]^pre[q[0]-1];
            }
            idx++;
        }
        return ans;
    }
}