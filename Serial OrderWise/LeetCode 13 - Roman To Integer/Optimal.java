class Solution {
    public int romanToInt(String s) {
        int ans = value(s.charAt(s.length()-1));
        for(int i = s.length()-2;i>=0;i--) {
            int val1 = value(s.charAt(i));
            int val2 = value(s.charAt(i+1));
            if(val1 < val2) {
                ans-=val1;
            } else {
                ans+=val1;
            }
        }
        return ans;
    }
    int value(char c) {
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}
public class Optimal {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.romanToInt("CDL"));
        }
}
