class Solution {
    private final static int ALPHABET_COUNT = 26;

    public int[] solution(String my_string) {
        int[] answer = new int[ALPHABET_COUNT * 2];
        char[] charArray = my_string.toCharArray();
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                answer[c - 'A']++;
            } else {
                answer[c - 'a' + ALPHABET_COUNT]++;
            }
        }
        return answer;
    }
}