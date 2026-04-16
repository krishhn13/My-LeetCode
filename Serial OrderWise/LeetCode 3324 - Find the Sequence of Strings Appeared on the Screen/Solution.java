class Solution {
    public List<String> stringSequence(String target) {
        List<String> list = new ArrayList<>();
        int p = 0;
        while(p < target.length()) {
            char ch = 'a';
            String prev = "";
            if(list.size() != 0) {
                prev = list.get(list.size()-1);
            }
            while(ch != target.charAt(p)) {
                list.add(prev+ch);
                ch++;
            }
            list.add(prev + ch);
            p++;
        }
        return list;
    }
}