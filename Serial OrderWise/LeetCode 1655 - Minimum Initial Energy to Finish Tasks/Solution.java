import java.util.*;

class Solution {
        public int minimumEffort(int[][] tasks) {
                Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
                // for(int[] d : tasks) {
                // System.out.println(Arrays.toString(d));
                // }
                int energy = 0, ans = 0;
                for (int[] t : tasks) {
                        if (energy < t[1]) {
                                int need = t[1] - energy;
                                energy += need;
                                ans += need;
                        }
                        energy -= t[0];
                }
                return ans;
                // return 0;
        }
}