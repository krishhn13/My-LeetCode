class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int i : nums) {
            freq[i]++;
        }
        int maxi = -1;
        for(int i : freq) {
            maxi = Math.max(maxi, i);
        }
        int cnt = 0;
        for(int i : freq) {
            if(i == maxi) {
                cnt++;
            }
        }
        return maxi*cnt;
    }
}