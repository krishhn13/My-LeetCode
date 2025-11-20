class Solution {
    public String reformatDate(String date) {
        String[] ans = date.split(" ");
        StringBuilder str = new StringBuilder();
        str.append(ans[2]);
        str.append("-");
        str.append(getMonth(ans[1]));
        str.append("-");
        if (ans[0].length() == 3) {
            str.append("0" + ans[0].charAt(0));
        } else {
            str.append(ans[0].charAt(0));
            str.append(ans[0].charAt(1));
        }
        return str.toString();
    }

    String getMonth(String mon) {
        switch (mon) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
        }
        return "";
    }
}

public class Answer {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reformatDate("13th Nov 2005"));
    }
}
