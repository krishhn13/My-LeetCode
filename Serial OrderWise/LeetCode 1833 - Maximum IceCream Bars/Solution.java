import java.util.*;
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int idx = 0;
        int cnt = 0;
        while(coins>0 && idx < costs.length) {
            if(coins < costs[idx]) {
                break;
            }
            cnt++;
            coins-=costs[idx];
            idx++;
        }
        return cnt;
    }
}