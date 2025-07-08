import java.util.Map;
import java.util.function.Function;

class Solution {
    private final Map<String, Function<Integer, Integer>> controllers = Map.of(
        "w", n -> n + 1,
        "s", n -> n - 1,
        "d", n -> n + 10,
        "a", n -> n - 10
    );

    public int solution(int n, String control) {
        return control.chars().reduce(n, (acc, i) -> controllers.get(String.valueOf((char) i)).apply(acc));
    }
}