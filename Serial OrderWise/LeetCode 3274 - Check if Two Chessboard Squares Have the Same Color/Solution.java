class Solution {
        public boolean checkTwoChessboards(String c1, String c2) {
                if (Math.abs(c1.charAt(0) - c2.charAt(0)) % 2 == 0) {
                        if (c1.charAt(1) % 2 == 0 && c2.charAt(1) % 2 == 0) {
                                return true;
                        } else if (c1.charAt(1) % 2 != 0 && c2.charAt(1) % 2 != 0) {
                                return true;
                        } else {
                                return false;
                        }
                } else {
                        if (c1.charAt(1) % 2 == 0 && c2.charAt(1) % 2 != 0) {
                                return true;
                        } else if (c1.charAt(1) % 2 != 0 && c2.charAt(1) % 2 == 0) {
                                return true;
                        } else {
                                return false;
                        }
                }
        }
}