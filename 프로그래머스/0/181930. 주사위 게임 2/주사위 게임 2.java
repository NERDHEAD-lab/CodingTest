import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {
    //확장성을 고려한다면 이런 방법도 있습니다.
    public int solution(int... values) {
        Set<Integer> set = new HashSet<>();
        for (int value : values) {
            set.add(value);
        }

        return IntStream.range(0, values.length - set.size() + 1)
                .map(i -> IntStream.of(values).map(value -> (int) Math.pow(value, i + 1)).sum())
                .reduce(1, (a, b) -> a * b);
    }
}