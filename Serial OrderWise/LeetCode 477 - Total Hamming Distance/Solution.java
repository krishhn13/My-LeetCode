class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i<32; i++) {
            int bitC = 0;
            for(int num : nums) {
                bitC += (num>>i)&1;
            }
            sum += bitC*(n-bitC);
        }
        return sum;
    }
}