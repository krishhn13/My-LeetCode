class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
                int ans = 0;
                while (mainTank >= 5 && additionalTank > 0) {
                        ans += 50;
                        mainTank -= 4;
                        additionalTank -= 1;
                }
                if (mainTank > 0) {
                        ans += mainTank * 10;
                }
                return ans;
        }
}