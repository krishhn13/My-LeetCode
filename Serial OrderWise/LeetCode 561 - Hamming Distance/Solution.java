public class Solution {
    public int hammingDistance(int x, int y) {
        String a = Integer.toBinaryString(x);
        String b = Integer.toBinaryString(y);
        int bada = a.length()-b.length();
        String c = "";
        if(bada < 0) {
            bada*=-1;
            for(int i = 0;i < bada;i++) {
                c += "0";
            }
            c+=a;
            a=""; 
        } else {
            for(int i = 0;i < bada;i++) {
                c += "0";
            }
            c+=b;
            b="";
        } 
        if(b.equals("")) {
            return diff(c,a);
        } else {
            return diff(c,b);
        }
    }
    int diff(String a, String b) {
        int cnt = 0;
        for(int i = 0;i < a.length();i++) {
            if(a.charAt(i)!=b.charAt(i)) cnt++;
        }
        return cnt;
    }
}