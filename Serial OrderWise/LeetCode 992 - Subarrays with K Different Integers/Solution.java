class Solution {
    private int solve(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        int ans = 0;
        while(l <= r) {
            if(map.size() <= k) {
                ans += r-l+1;
                if(r < n-1) {
                    r++;
                    map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
                } else {
                    break;
                }
            } else {
                map.put(arr[l], map.getOrDefault(arr[l],0)-1);
                if(map.get(arr[l]) <= 0) {
                    map.remove(arr[l]);
                }
                l++;
            }
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }
}