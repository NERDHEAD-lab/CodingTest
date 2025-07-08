import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        return IntStream.of(num_list).reduce(1, (a, b) -> a * b) < (int) Math.pow(IntStream.of(num_list).sum(), 2) ? 1 : 0;
    }
}