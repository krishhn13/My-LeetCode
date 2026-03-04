class Solution {
        public int finalPositionOfSnake(int n, List<String> commands) {
                int row = 0, col = 0;
                for (String s : commands) {
                        if (s.equals("UP")) {
                                row--;
                        } else if (s.equals("LEFT")) {
                                col--;
                        } else if (s.equals("RIGHT")) {
                                col++;
                        } else {
                                row++;
                        }
                }
                return (row * n) + col;
        }
}