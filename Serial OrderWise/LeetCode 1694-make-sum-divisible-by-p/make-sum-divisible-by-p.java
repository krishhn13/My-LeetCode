class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0; 
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int target = (int)(total % p);
        if(target == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        long prefix = 0;   
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            prefix += nums[i];
            int cur = (int)(prefix % p);
            if(cur < 0) cur += p; 
            int need = cur - target;
            need %= p;
            if(need < 0) need += p;
            if(map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
            map.put(cur, i);
        }
        return (res != nums.length) ? res : -1;
    }
}
