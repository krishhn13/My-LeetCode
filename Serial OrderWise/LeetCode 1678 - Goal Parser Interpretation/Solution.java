class Solution {
        public String interpret(String command) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < command.length(); i++) {
                        if (command.charAt(i) == 'G') {
                                str.append('G');
                        } else if (i + 1 < command.length() && command.charAt(i) == '('
                                        && command.charAt(i + 1) == ')') {
                                str.append('o');
                                i++;
                        } else if (i + 3 < command.length() && command.substring(i, i + 4).equals("(al)")) {
                                str.append("al");
                                i += 3;
                        }
                }
                return str.toString();
        }
}