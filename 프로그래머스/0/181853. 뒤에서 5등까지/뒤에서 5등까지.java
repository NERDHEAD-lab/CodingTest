import java.util.Arrays;

class Solution {
    private static final int MAX_LENGTH = 5;
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOf(num_list, MAX_LENGTH);
    }
}