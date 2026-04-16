class Solution {
    public int totalMoney(int n) {
        int monday = 1;
        int weeks = n/7;
        int remainingDays = n%7;
        int money = 0;

        while(weeks-->0){
            money+=sum(monday,7);
            monday+=1;
        }
        // System.out.println(monday +" -> money : " + money);
        while(remainingDays-->0){
            money+=monday++;
        }
        return money;
    }
    int sum(int start, int days) {
        int count = 0;
        int ans = 0;
        while(count<days) {
            ans+=start;
            start++;
            count++;
        }
        return ans;
    }
}