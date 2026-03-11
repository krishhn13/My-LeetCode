class Solution {
        public int bitwiseComplement(int n) {
                if (n == 0)
                        return 1;
                int pow = 0;
                int ans = 1;
                while (ans <= n) {
                        ans = 1 << pow;
                        pow++;
                }
                return ans - 1 - n;
        }
}