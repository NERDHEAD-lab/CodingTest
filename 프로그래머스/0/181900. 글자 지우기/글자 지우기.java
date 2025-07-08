import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        char[] charArray = my_string.toCharArray();
        char[] result = new char[charArray.length - indices.length];

        int j = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (j < indices.length && i == indices[j]) {
                j++;
                continue;
            }
            result[i - j] = charArray[i];
        }

        return new String(result);
    }
}