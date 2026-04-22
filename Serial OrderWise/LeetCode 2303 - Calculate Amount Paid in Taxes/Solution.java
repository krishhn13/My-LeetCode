class Solution {
    public double calculateTax(int[][] nums, int income) {
        if(income == 0) return 0;
        double tax = 0;
        boolean huaKya = false;
        for(int i = 0;i<nums.length;i++) {
            if(i==0) {
                if(nums[i][0]<income) {
                    tax+=nums[i][0]*(nums[i][1]/100.0);
                    income -= nums[i][0];   
                } else {
                    tax += income * (nums[i][1]/100.0);
                    break;
                }
            } else {
                int val = nums[i][0] - nums[i-1][0];
                if(val < income) {
                    tax += val * (nums[i][1]/100.0);
                    income -= val;
                } else {
                    tax += income * (nums[i][1]/100.0);
                    break;
                }
            }
        }
        return tax;
    }
}