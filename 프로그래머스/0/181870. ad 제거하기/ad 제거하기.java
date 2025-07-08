import java.util.stream.Stream;

class Solution {
    public String[] solution(String[] strArr) {
        return Stream.of(strArr)
                .filter(s -> !s.contains("ad"))
                .toArray(String[]::new);
    }
}