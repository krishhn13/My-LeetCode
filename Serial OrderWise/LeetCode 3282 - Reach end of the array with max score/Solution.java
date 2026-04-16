import java.util.*;

public class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long score = 0;
        int prev = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(prev)) {
                score = score + (long) (i - prev) * nums.get(prev);
                prev = i;
            }
        }
        score += (long) (nums.size() - 1 - prev) * nums.get(prev);
        return score;
    }
}