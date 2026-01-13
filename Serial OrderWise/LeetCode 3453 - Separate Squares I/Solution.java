class Solution {
        public double separateSquares(int[][] squares) {
                double left = 0;
                double right = 0;
                for (int[] square : squares) {
                        right = Math.max(right, square[1] + square[2]);
                }
                while (right - left > 1e-6) {
                        double mid = (left + right) / 2;
                        double aboveArea = 0;
                        double belowArea = 0;
                        for (int[] square : squares) {
                                int y = square[1];
                                int l = square[2];
                                if (mid >= y + l) {
                                        belowArea += (double) l * l;
                                } else if (mid <= y) {
                                        aboveArea += (double) l * l;
                                } else {
                                        belowArea += (double) l * (mid - y);
                                        aboveArea += (double) l * (y + l - mid);
                                }
                        }
                        if (belowArea < aboveArea) {
                                left = mid;
                        } else {
                                right = mid;
                        }
                }
                return left;
        }
}
