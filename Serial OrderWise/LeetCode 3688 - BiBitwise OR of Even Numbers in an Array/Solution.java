class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int or = 0;
        for(int i : nums){
            if(i%2==0) or|=i;
        }
        return or;
    }
}