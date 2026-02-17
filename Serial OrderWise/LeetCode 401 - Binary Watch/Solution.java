import java.util.*;
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        solve(0, turnedOn, list, new StringBuilder());
        List<String> ans = new ArrayList<>();
        for(String s : list) {
            int hours = Integer.parseInt(s.substring(0,4),2);
            int minutes = Integer.parseInt(s.substring(4),2);
            if(hours < 12 && minutes < 60) {
                StringBuilder str = new StringBuilder();
                str.append(hours);
                str.append(":");
                if(minutes < 10) str.append("0");
                str.append(minutes);
                ans.add(str.toString());
            }
        }
        return ans;
    }
    private void solve(int idx, int count, List<String> list, StringBuilder str) {
        if (count < 0) {
            return;
        }
        if (idx == 10) {
            if (count == 0)
                list.add(str.toString());
            return;
        }
        str.append("1");
        solve(idx + 1, count - 1, list, str);
        str.deleteCharAt(str.length() - 1);
        str.append("0");
        solve(idx + 1, count, list, str);
        str.deleteCharAt(str.length() - 1);
    }
}