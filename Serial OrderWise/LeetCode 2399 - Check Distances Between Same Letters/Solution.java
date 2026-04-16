class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(int i = 0 ;i < 26; i++) {
            int idx1 = -1, idx2 = -1;
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'a'+i) {
                    if(idx1!=-1) {
                        idx2 = j;
                        break;
                    } else {
                        idx1 = j;
                    }
                } 
            }
            if(idx1 == -1) continue;
            int val = distance[i];
            if(idx2 - idx1 - 1 != val) return false;
        }
        return true;
    }
}