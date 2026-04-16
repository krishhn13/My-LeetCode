class Solution {
        public boolean judgeCircle(String moves) {
                int l = 0, d = 0;
                for (char c : moves.toCharArray()) {
                        switch (c) {
                                case 'D':
                                        d++;
                                        break;
                                case 'L':
                                        l++;
                                        break;
                                case 'U':
                                        d--;
                                        break;
                                case 'R':
                                        l--;
                                        break;
                        }
                }
                return l == 0 && d == 0;
        }
}