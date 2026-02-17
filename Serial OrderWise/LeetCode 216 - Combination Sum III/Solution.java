import java.util.*;

class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
                List<List<Integer>> list = new ArrayList<>();
                generate(list, k, n, 1, new ArrayList<>());
                return list;
        }

        private void generate(List<List<Integer>> list, int k, int n, int idx, List<Integer> l) {
                if (l.size() == k && n == 0) {
                        list.add(new ArrayList<>(l));
                        return;
                }
                for (int i = idx; i <= 9; i++) {
                        l.add(i);
                        generate(list, k, n - i, i + 1, l);
                        l.remove(l.size() - 1);
                }
        }
}