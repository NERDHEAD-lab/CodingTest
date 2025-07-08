class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = code.length(); i < len; i++) {
            char c = code.charAt(i);
            if (c == '1') {
                mode = 1 - mode;
            } else if (i % 2 == mode) {
                sb.append(c);
            }
        }

        return sb.length() > 0 ? sb.toString() : "EMPTY";
    }
}
