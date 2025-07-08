class Solution {
    public int solution(String myString, String pat) {
        char[] charArray = pat.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (charArray[i] == 'A') ? 'B' : 'A';
        }

        return myString.contains(new String(charArray)) ? 1 : 0;
    }
}