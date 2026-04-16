import java.util.*;

class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
                int ans = -1;
                List<Integer> list = arrays.get(0);
                int maxiF = list.get(list.size() - 1);
                int miniF = list.get(0);
                for (int i = 1; i < arrays.size(); i++) {
                        List<Integer> val = arrays.get(i);
                        int maxi = val.get(val.size() - 1);
                        int mini = val.get(0);
                        ans = Math.max(ans, Math.max(maxiF - mini, maxi - miniF));
                        maxiF = Math.max(maxi, maxiF);
                        miniF = Math.min(mini, miniF);
                }
                return ans;
        }
}