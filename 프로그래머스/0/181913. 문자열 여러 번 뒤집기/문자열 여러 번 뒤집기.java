class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] charArray = my_string.toCharArray();
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            reverse(charArray, start, end);
        }
        return new String(charArray);
    }

    private void reverse(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
