class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = Integer.MIN_VALUE, e = 0;
        for(int i : weights) {
            e+=i;
            s = Math.max(s,i);
        }
        while(s < e) {
            int mid = s + (e-s)/2;
            int need = 1, curr = 0;
            for(int i : weights) {
                if(curr+i > mid) {
                    need++;curr=0;
                }
                curr+=i;
            }
            if(need > days) s = mid+1;
            else e = mid;
        }
        return s;
    }
}