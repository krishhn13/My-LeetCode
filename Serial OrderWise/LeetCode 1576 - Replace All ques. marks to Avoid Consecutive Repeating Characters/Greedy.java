class Solution {
    public String modifyString(String s) {
        if (s.length()==1) return "a";
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(int i = 0;i<n;i++) {
            if(s.charAt(i)!='?') {
                str.append(s.charAt(i));
            } else {
                char a='0';
                char b ='0';
                if(i>0 && i<s.length()-1) {
                    a = str.charAt(i-1);
                    b = s.charAt(i+1);
                } else if(i == s.length()-1) {
                    a = str.charAt(i-1);
                } else if(i == 0) {
                    b = s.charAt(i+1);
                }
                for(int ij = 0;ij < 26;ij++) {
                    char prob = (char)(97+ij);
                    // System.out.println(prob + " " + a + "  " + b);
                    if(a!=prob && b!=prob) {
                        str.append(prob);
                        break;
                    } 
                }
            }
        }
        return str.toString();
    }
}
public class Greedy {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.modifyString("j?qg??b"));
        }
}
