class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int mini = Integer.MAX_VALUE;
        for(int i = nums.length-1;i>-1;i--) {
            int ele = reverse(nums[i]);
            if(map.containsKey(ele)){
                mini = mini < map.get(ele)-i ? mini : map.get(ele)-i;
            }
            map.put(nums[i],i);
        }
        return mini == Integer.MAX_VALUE?-1:mini;
    }
    int reverse(int num) {
        int ans = 0;
        while(num>0) {
            ans = ans*10 + num%10;
            num/=10;
        }
        return ans;
    }
}