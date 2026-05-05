import java.util.*;

class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> used = new HashSet<>();
        int sum = 0;
        for(int i = 1; used.size() < n; i++) {
            if(!used.contains(k - i)) {
                used.add(i);
                sum += i;
            }
        }
        return sum;
    }
}