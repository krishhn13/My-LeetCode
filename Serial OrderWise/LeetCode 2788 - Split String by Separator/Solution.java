class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for(String st : words) {
            String[] ar = st.split("\\"+separator);
            for(String s : ar) {
                if (!s.isEmpty()) list.add(s);
            }
        }
        return list;   
    }
}