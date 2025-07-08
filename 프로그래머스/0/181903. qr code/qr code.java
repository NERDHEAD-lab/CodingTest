import java.util.stream.IntStream;

class Solution {
    public String solution(int q, int r, String code) {
        return IntStream.range(0, code.length())
                .filter(i -> i % q == r)
                .collect(StringBuilder::new, (sb, i) -> sb.append(code.charAt(i)), StringBuilder::append)
                .toString();
    }
}