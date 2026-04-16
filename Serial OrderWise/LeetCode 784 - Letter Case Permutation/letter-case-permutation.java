class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        generate(s,0,new StringBuilder(),res);
        return res;
    }
    void generate(String s, int index, StringBuilder output, List<String> res) {
        if(index == s.length()) {
            res.add(output.toString());
            return;
        }
        if(Character.isLowerCase(s.charAt(index))) {
            output.append(s.charAt(index));
            generate(s,index+1,output,res);
            output.deleteCharAt(output.length()-1);
            output.append((char)(s.charAt(index)-'a'+'A'));
            generate(s,index+1,output,res);
            output.deleteCharAt(output.length()-1);
        }
        else if(Character.isUpperCase(s.charAt(index))) {
            output.append(s.charAt(index));
            generate(s,index+1,output,res);
            output.deleteCharAt(output.length()-1);
            output.append((char)(s.charAt(index)+'a'-'A'));
            generate(s,index+1,output,res);
            output.deleteCharAt(output.length()-1);
        }
        else{
            output.append(s.charAt(index));
            generate(s,index+1,output,res);
            output.deleteCharAt(output.length()-1);
        }
    }
}