class Solution {
        int[] arr;
        Map<Integer, List<Integer>> map;

        public Solution(int[] nums) {
                arr = Arrays.copyOf(nums, nums.length);
                map = new HashMap<>();
                for (int i = 0; i < arr.length; i++) {
                        map.putIfAbsent(arr[i], new ArrayList<>());
                        map.get(arr[i]).add(i);
                }
        }

        public int pick(int target) {
                if (map.containsKey(target)) {
                        List<Integer> list = map.get(target);
                        int randomIndex = new Random().nextInt(list.size());
                        return list.get(randomIndex);
                }
                return -1;
        }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */