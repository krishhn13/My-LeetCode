import java.util.*;

class Solution {
        public List<List<Integer>> subsets(int[] nums) {
                List<List<Integer>> list = new ArrayList<>();
                generate(list, 0, new ArrayList<>(), nums);
                return list;
        }

        private void generate(List<List<Integer>> list, int idx, List<Integer> temp, int[] nums) {
                if (idx == nums.length) {
                        list.add(new ArrayList<>(temp));
                        return;
                }
                temp.add(nums[idx]);
                generate(list, idx + 1, temp, nums);
                temp.remove(temp.size() - 1);
                generate(list, idx + 1, temp, nums);
        }
}