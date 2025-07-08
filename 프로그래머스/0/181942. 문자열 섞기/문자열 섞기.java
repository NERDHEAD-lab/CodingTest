class Solution {
    public String solution(String str1, String str2) {
        StringBuilder answer = new StringBuilder();
        char[] str1Ch = str1.toCharArray();
        char[] str2Ch = str2.toCharArray();
        
        for (int i = 0; i < str1Ch.length; i++) {
            answer.append(str1Ch[i]);
            answer.append(str2Ch[i]);
        }
        return answer.toString();
    }
}