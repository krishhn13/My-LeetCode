class Solution {
    public boolean checkDivisibility(int n) {
        int prod = prod(n);
        int sum = sum(n);
        return n%(sum+prod) == 0;
    }
    int prod(int n) {
        int ans = 1;
        while(n>0) {
            ans*=n%10;
            n/=10;
        }
        return ans;
    }
    int sum(int n) {
        int ans = 0;
        while(n>0) {
            ans += n%10;
            n/=10;
        }
        return ans;
    }
}