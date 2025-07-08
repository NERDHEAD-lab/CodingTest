class Solution {
    public int solution(String myString, String pat) {
        int count = 0;
        int patLength = pat.length();
        char[] myChar = myString.toCharArray();
        char[] patChar = pat.toCharArray();
        for (int i = 0; i < myChar.length - patLength + 1; i++) {
            int j = 0;
            while (j < patLength && myChar[i + j] == patChar[j]) {
                j++;
            }
            if (j == patLength) {
                count++;
            }
        }
        return count; 
    }
}