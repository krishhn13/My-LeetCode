class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int n = nums.length;
        for(int i = 0 ; i < queries.length; i++) {
            int ele = queries[i];
            int num = nums[ele];
            List<Integer> temp = map.get(num);
            if(temp.size() == 1) {
                list.add(-1);
                continue;
            }
            int left = 0, right = temp.size() - 1;
            int ans = -1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(temp.get(mid) == ele) {
                    ans = mid;
                    break;
                }
                else if(temp.get(mid) > ele) right = mid - 1;
                else left = mid + 1;
            }
            int prob = Integer.MAX_VALUE;
            int prev = temp.get((ans - 1 + temp.size()) % temp.size());
            int next = temp.get((ans + 1) % temp.size());
            int diff = Math.abs(ele - prev);
            prob = Math.min(prob, Math.min(diff, n - diff));
            diff = Math.abs(ele - next);
            prob = Math.min(prob, Math.min(diff, n - diff));
            list.add(prob);
        }
        return list;
    }
}