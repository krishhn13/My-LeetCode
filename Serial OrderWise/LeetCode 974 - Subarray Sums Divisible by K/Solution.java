class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        int curr = 0;
        for(int i : nums) {
            curr += i;
            int rem = curr % k;
            if(rem < 0) rem += k;
            if(map.containsKey(rem)) {
                cnt += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        } 
        return cnt;
    }
}