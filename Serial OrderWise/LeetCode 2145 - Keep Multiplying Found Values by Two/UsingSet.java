import java.util.*;
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        while(set.contains(original)) {
            original*=2;
        }
        return original;
    }
}
public class UsingSet {
        public static void main(String[] args) {
                Solution sol = new Solution();
               System.out.println(sol.findFinalValue(new int[]{161,28,640,264,81,561,320,2,61,244,183,108,773,61,976,122,988,2,370,392,488,375,349,432,713,563}, 61));
        }
}
