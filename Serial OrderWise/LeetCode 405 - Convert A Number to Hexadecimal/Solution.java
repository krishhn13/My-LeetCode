class Solution {
    public String toHex(int num) {
        return num == 0 ? "0" : Long.toHexString(num & 0xFFFFFFFFL);
    }
}
