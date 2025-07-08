import java.util.function.BiFunction;
import java.util.stream.IntStream;

class Solution {
    private final BiFunction<Integer, Integer, Character> detectiveConan = (before, after) -> {
        int diff = after - before;
        if (diff == 1) return 'w';
        if (diff == -1) return 's';
        if (diff == 10) return 'd';
        if (diff == -10) return 'a';

        throw new IllegalArgumentException("Invalid control");
    };

    public String solution(int[] numLog) {
        return IntStream.range(1, numLog.length)
            .mapToObj(i -> detectiveConan.apply(numLog[i - 1], numLog[i]))
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }
}