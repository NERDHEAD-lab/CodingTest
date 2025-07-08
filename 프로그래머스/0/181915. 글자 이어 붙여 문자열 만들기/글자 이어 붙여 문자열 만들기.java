class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] result = new char[index_list.length];
        char[] my_char = my_string.toCharArray();
        for (int i = 0; i < index_list.length; i++) {
            result[i] = my_char[index_list[i]];
        }

        return new String(result);
    }
}
