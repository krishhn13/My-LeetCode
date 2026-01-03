/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */
class GuessGame {
        int pick;

        GuessGame() {

        }

        GuessGame(int pick) {
                this.pick = pick;
        }

        int guess(int num) {
                if (num == pick)
                        return 0;
                else if (num < 0)
                        return -1;
                else
                        return 1;
        }
}

class Solution extends GuessGame {
        public int guessNumber(int n) {
                int s = 1, l = n;
                while (s <= l) {
                        int mid = s + (l - s) / 2;
                        if (guess(mid) == 0) {
                                return mid;
                        } else if (guess(mid) == -1) {
                                l = mid - 1;
                        } else {
                                s = mid + 1;
                        }
                }
                return -1;
        }
}

public class Answer {
        @SuppressWarnings("unused")
        public static void main(String[] args) {
                GuessGame guessGame = new GuessGame(6);
                Solution sol = new Solution();
                System.out.println(sol.guess(10));
        }
}
