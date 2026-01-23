import java.util.*;

class Solution {
        int count = 0;

        public int minimumPairRemoval(int[] nums) {
                List<Integer> list = new ArrayList<>();
                for (int i : nums) {
                        list.add(i);
                }
                while (!isSorted(list)) {
                        int x = 0;
                        int y = 1;
                        int sum = (int) 1e9;
                        for (int i = 0; i < list.size() - 1; i++) {
                                int curr = list.get(i) + list.get(i + 1);
                                if (curr < sum) {
                                        sum = curr;
                                        x = i;
                                        y = i + 1;
                                }
                        }
                        list.remove(x);
                        list.set(y - 1, sum);
                        count++;
                }
                return count;
        }

        private boolean isSorted(List<Integer> list) {
                for (int i = 1; i < list.size(); i++) {
                        if (list.get(i) < list.get(i - 1)) {
                                return false;
                        }
                }
                return true;
        }
}

public class LC3507 {

}

class Main {
        public static void main(String[] args) {
                Solution sol = new Solution();

                int[][] tests = {
                                { 3, 2, 1, 4 },
                                { 1, 2, 3, 4 },
                                { 5, 4, 3, 2, 1 },
                                { 2, 2, 2, 2 },
                                { 10, 1, 9, 2, 8 }
                };

                for (int[] nums : tests) {
                        System.out.println(sol.minimumPairRemoval(nums));
                }
        }
}