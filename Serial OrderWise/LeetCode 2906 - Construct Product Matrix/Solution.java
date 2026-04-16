import java.util.*;

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int sz = n*m;
        int mod = 12345;
        int[] pre = new int[n*m];
        int[] suff = new int[n*m];
        pre[0] = 1;
        suff[sz-1] = 1;
        List<Integer> list = new ArrayList<>();
        for(int[] ar : grid) {
            for(int i : ar) { list.add(i%mod); }
        }
        for(int i = 1; i < sz ; i++) {
            pre[i] = (pre[i-1] * list.get(i-1))%mod;
        }
        for(int j = sz-2; j >=0 ; j--) {
            suff[j] = (suff[j+1] * list.get(j+1))%mod;
        }
        int[][] ans = new int[n][m];
        List<Integer> temp = new ArrayList<>();
        for(int i = 0 ;i < sz; i++) {
            temp.add((pre[i]*suff[i])%mod);
        }
        int idx = 0;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = temp.get(idx);
                idx++;
            }
        }
       return ans;
    }
}