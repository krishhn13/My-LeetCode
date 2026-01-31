class Solution {
    public int countSegments(String s) {
        String[] st = s.trim().split("\\s+");
        if(st.length == 1 && st[0].equals("")) return 0;
        return st.length;
    }
}