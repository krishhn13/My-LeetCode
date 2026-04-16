class Solution{
        public int brokenCalc(int startValue, int target) {
                int cnt = 0;
                while(target>startValue) {
                        if(target%2 == 0) {
                                target/=2;
                        } else {
                                target++;
                        }
                        cnt++;
                }
                cnt += startValue-target;
                return cnt;
        }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.brokenCalc(5,8));
        }
}
