import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public String solution(String[] str_list, String exclude) {
        return Stream.of(str_list).filter(str -> !str.contains(exclude)).collect(Collectors.joining());
    }
}