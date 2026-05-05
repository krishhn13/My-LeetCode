class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        while(k > 0) {
            if(numOnes > 0) {
                numOnes--;
                sum++;
            }
            else if(numZeros > 0){
                numZeros--;
            }
            else {
                numNegOnes--;
                sum--;
            }
            k--;
        }
        return sum;
    }
}