class Solution {
    int[] arr = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    public boolean isDigitorialPermutation(int n) {
        int[] arr1 = new int[10];
        int num = n;
        while(num > 0) {
            int val = num%10;
            arr1[val]++;
            num/=10;
        }
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            if(arr1[i]!=0) {
                int fact = arr[i];
                sum+=fact * arr1[i];
            }
        }
        while(sum>0) {
            int val = sum%10;
            if(arr1[val] == 0) return false;
            arr1[val]--;
            sum/=10;
        }
        for(int i : arr1) {
            if(i!=0) return false;
        }
        return true;
    }
}