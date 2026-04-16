class Solution {
        public String truncateSentence(String s, int k) {
                String[] arr = s.split(" ");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < k; i++) {
                        String str = arr[i];
                        sb.append(str);
                        sb.append(" ");
                }
                return sb.toString().trim();
        }
}