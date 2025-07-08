import java.util.function.BiFunction;

class Solution {
    private final BiFunction<Integer, Integer, Integer> sumHandler = Integer::sum;
    private final BiFunction<Integer, Integer, Integer> mulHandler = (a, b) -> a * b;

    public int solution(int[] num_list) {
        boolean sumOrMul = num_list.length >= 11;
        final BiFunction<Integer, Integer, Integer> handler = sumOrMul ? sumHandler : mulHandler;
        int answer = sumOrMul ? 0 : 1;
        for (int i : num_list) {
            answer = handler.apply(answer, i);
        }

        return answer;
    }
}