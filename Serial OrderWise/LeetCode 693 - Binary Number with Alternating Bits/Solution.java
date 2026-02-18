class Solution {
        public boolean hasAlternatingBits(int n) {
                int last = -1;
                while(n > 0) {
                        int now = n%2;
                        if(last == now) {
                                return false;
                        }
                        last = now;
                        n>>=1;
                }
                return true;
        }
}